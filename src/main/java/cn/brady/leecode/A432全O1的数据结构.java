package cn.brady.leecode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @description: https://leetcode-cn.com/problems/all-oone-data-structure/submissions/
 * @beat 94%
 * @auther: bian.wu
 * @date: 2019/4/3 10:24
 */
public class A432全O1的数据结构 {

    class DListNode {
        int value;
        HashSet<String> keySet;
        DListNode pre;
        DListNode next;

        DListNode() {
            keySet = new HashSet<>();
        }
    }

    HashMap<String, Integer> keyMap = new HashMap<>();
    HashMap<Integer, DListNode> valueMap = new HashMap<>();
    DListNode head, tail;

    public A432全O1的数据结构() {
        head = new DListNode();
        tail = new DListNode();
        head.next = tail;
        tail.pre = head;
    }

    /**
     * Insert new node in the order list.
     */
    public void insertNode(String key, int curvalue, int dir) {
        DListNode newnode = new DListNode();
        valueMap.put(curvalue + dir, newnode);
        newnode.keySet.add(key);
        if (curvalue == 0) {
            newnode.next = head.next;
            head.next.pre = newnode;
            newnode.pre = head;
            head.next = newnode;
            return;
        }

        DListNode curnode = valueMap.get(curvalue);
        if (dir == 1) {
            newnode.next = curnode.next;
            curnode.next.pre = newnode;
            newnode.pre = curnode;
            curnode.next = newnode;
        } else if (dir == -1) {
            newnode.pre = curnode.pre;
            newnode.next = curnode;
            curnode.pre.next = newnode;
            curnode.pre = newnode;
        }
    }

    /**
     * Remove the empty node of the order list.
     */
    public void removeNode(int curvalue) {
        DListNode curnode = valueMap.get(curvalue);
        if (curnode.keySet.isEmpty()) {
            valueMap.remove(curvalue);
            curnode.next.pre = curnode.pre;
            curnode.pre.next = curnode.next;
            curnode.next = null;
            curnode.pre = null;
        }
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        if (keyMap.containsKey(key)) {
            int curvalue = keyMap.get(key);
            valueMap.get(curvalue).keySet.remove(key);
            keyMap.replace(key, curvalue + 1);
            if (valueMap.containsKey(curvalue + 1)) {
                valueMap.get(curvalue + 1).keySet.add(key);
            } else {
                insertNode(key, curvalue, 1);
            }
            removeNode(curvalue);
        } else {
            keyMap.put(key, 1);
            if (valueMap.containsKey(1)) {
                valueMap.get(1).keySet.add(key);
            } else {
                insertNode(key, 0, 1);
            }
        }
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        if (keyMap.containsKey(key)) {
            int curvalue = keyMap.get(key);
            DListNode curnode = valueMap.get(curvalue);
            curnode.keySet.remove(key);
            if (curvalue == 1) {
                keyMap.remove(key);
                removeNode(curvalue);
                return;
            }
            keyMap.replace(key, curvalue - 1);
            if (valueMap.containsKey(curvalue - 1)) {
                valueMap.get(curvalue - 1).keySet.add(key);
            } else {
                insertNode(key, curvalue, -1);
            }
            removeNode(curvalue);
        }
    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        return (tail.pre == head) ? "" : tail.pre.keySet.iterator().next();
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        return (head.next == tail) ? "" : head.next.keySet.iterator().next();
    }


    public static void main(String... args) {

        String key1 = "AllOne";
        String key2 = "getMaxKey";
        String key3 = "getMin";
        A432全O1的数据结构 a432 = new A432全O1的数据结构();

        a432.inc(key1);
        a432.inc(key1);
        a432.inc(key1);
        a432.inc(key2);
        a432.inc(key2);
        a432.inc(key3);

        System.out.println(a432.getMaxKey());
        System.out.println(a432.getMinKey());


    }

}
