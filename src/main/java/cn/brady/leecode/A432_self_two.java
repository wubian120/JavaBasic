package cn.brady.leecode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/3 17:47
 */
public class A432_self_two {

    class DNode {

        HashSet<String> keySet;
        DNode pre, next;

        public DNode() {

            keySet = new HashSet<>();
        }
    }

    HashMap<String, Integer> keyMap;
    HashMap<Integer, DNode> valueMap;
    DNode head, tail;

    public A432_self_two() {
        head = new DNode();
        tail = new DNode();
        head.next = tail;
        tail.pre = head;
        keyMap = new HashMap<>();
        valueMap = new HashMap<>();

    }

    /***
     *
     * @param key  "字符串"
     * @param currentValue 当前值
     * @param dir  +1 或 -1
     */
    private void insertNode(String key, int currentValue,int dir) {

    }

    private void removeNode(int currentValue) {

    }

    public void inc(String key) {

    }

    public void dec(String key) {

    }

    public String getMaxKey() { return tail.pre == head ? "" : tail.pre.keySet.iterator().next(); }

    public String getMinKey() { return head.next == tail ? "" : head.next.keySet.iterator().next(); }


}
