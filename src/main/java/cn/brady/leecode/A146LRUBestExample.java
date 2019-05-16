package cn.brady.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 *
 *
 *
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，
 * 它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * 进阶:
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * 示例:
 * LRUCache cache = new LRUCache( 2  缓存容量  )
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // 返回  1
 * cache.put(3,3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4,4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 *
 *
 * @status   choosen
 * @auther: bian.wu
 * @date: 2019/4/1 22:32
 */
public class A146LRUBestExample {

    /**
     * @beat 90%
     */

    public A146LRUBestExample(int capacity) {
        capa = capacity;
        dummy.next = tail;
        tail.prev = dummy;
    }

    class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }

    Map<Integer, Node> map = new HashMap<>();

    int size = 0;
    Node dummy = new Node();
    Node tail = new Node();
    int capa;



    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        //拿出来 放到队尾；
        Node i = map.get(key);
        Node tempPrev = i.prev;
        Node tempNext = i.next;
        tempPrev.next = tempNext;
        tempNext.prev = tempPrev;
        Node tempTailPrev = tail.prev;
        tempTailPrev.next = i;
        i.prev = tempTailPrev;
        i.next = tail;
        tail.prev = i;
        return i.value;

    }

//     private moveNodetoTail (Node cur) {

//     }

    public void put(int key, int value) {
        Node i = map.get(key);
        //新增
        if (i == null) {
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            //超过 容量
            if(size >= capa){
                Node tempHead = dummy.next;
                dummy.next = tempHead.next;
                dummy.next.prev = dummy;
                map.remove(tempHead.key);
            }
            map.put(key, newNode);
            //新增的 node  放在最后面
            Node tempTailPrev = tail.prev;
            tempTailPrev.next = newNode;
            newNode.prev = tempTailPrev;
            newNode.next = tail;
            tail.prev = newNode;
            size++;
        } else {
            // 已存在
            i.value = value;
            Node tempPrev = i.prev;
            Node tempNext = i.next;
            tempPrev.next = tempNext;
            tempNext.prev = tempPrev;

            Node tempTailPrev = tail.prev;
            tempTailPrev.next = i;
            i.prev = tempTailPrev;
            i.next = tail;
            tail.prev = i;
        }
    }
}
