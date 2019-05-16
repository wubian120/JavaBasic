package cn.brady.leecode;

import java.util.HashMap;

/**
 * @description: 146 LRU缓存
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 *
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * 示例:
 *
 * LRUCache cache = new LRUCache( 2  缓存容量  )
 *
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // 返回  1
 * cache.put(3,3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4,4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 * @auther: bian.wu
 * @date: 2019/3/22 17:31
 */
public class A146 {


    /**
     * @status: pass
     * @beats: 161ms  31%
     * @ref:  http://www.cnblogs.com/DarrenChan/p/8744354.html
     */
    private class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "[" + key + "," + value + "]";
        }
    }

    private int capacity;
    private HashMap<Integer, Node> map = new HashMap<>();
    private Node head = null;
    private Node tail = null;

    public A146(int capacity) {
        this.capacity = capacity;
    }
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            setHead(n,false);
            return n.value;
        }

        return -1;
    }

    private void remove(Node node) {
        //是头节点
        if (node.pre != null) {
            node.pre.next = node.next;
        } else {
            head = node.next;
        }

        //是否尾节点
        if (node.next != null) {
            node.next.pre = node.pre;
        } else {
            tail = node.pre;
        }

        //貌似与上面条件重复,可以删除
        if (node == tail) {
            tail = tail.pre;
        }
    }

    private void setHead(Node n, boolean isNew) {
        //如果是头，直接返回
        if (head == n) {
            return;
        }

        //是否插入,注意在put的时候有remove 也算新节点
        if (isNew) {
            n.next = head;
            n.pre = null;

            if (head != null) {
                head.pre = n;
            }

            head = n;
            if (tail == null) {
                tail = head;
            }

            if (tail == head && head.next != null) {
                tail = head.next;
                tail.next = null;
            }
            return;
        }

        //非新插入头，只修改头指针
        //是尾节点
        if (n.next == null) {
            tail = n.pre;
            tail.next = null;
            head.pre = n;//记得给原先头节点的前驱赋当前值
            n.next = head;
            //设置新的头节点
            head = n;
            head.pre = null;

        }else {
            //非尾节点
            head.pre = n;//记得给原先头节点的前驱赋当前值
            n.next.pre = n.pre;
            n.pre.next = n.next;
            n.next = head;
            head = n;
            head.pre = null;
        }
    }

    public void put(int key, int value) {
        //已经存在
        //先删除，再设置为头
        if (map.containsKey(key)) {
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old,true);
        } else {
            //不存在新建，包括设置新头和删除溢出节点
            Node created = new Node(key, value);
            if (map.size() >= capacity) {
                map.remove(tail.key);
                remove(tail);
                setHead(created,true);
            } else {
                setHead(created,true);
            }
            map.put(key, created);
        }
    }

    @Override
    public String toString() {
        return this.map.toString();
    }

    public static void main(String[] args) {
        A146 lruCache = new A146(2);
        System.out.println(lruCache.get(2));
        lruCache.put(2, 6);
        System.out.println(lruCache.get(1));
        lruCache.put(1, 5);
        lruCache.put(1, 2);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }


}
