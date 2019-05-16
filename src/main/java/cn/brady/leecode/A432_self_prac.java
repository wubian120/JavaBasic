package cn.brady.leecode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/3 10:31
 */
public class A432_self_prac {

    class DNode {
//        int value;
        HashSet<String> keySet;
        DNode pre, next;

        DNode() {
            keySet = new HashSet<>();
        }
    }

    HashMap<String, Integer> keyMap = new HashMap<>();

    HashMap<Integer, DNode> valueMap = new HashMap<>();
    //双向链表， 升序， 最大在tail,
    DNode head, tail;

    public A432_self_prac() {
        head = new DNode();
        tail = new DNode();
        head.next = tail;
        tail.pre = head;
    }

    // 插入新 节点，  dir 是 根据操作 +1 或者 -1
    private void insertNode(String key, int currentValue, int dir) {
        DNode newNode = new DNode();

        valueMap.put(currentValue + dir, newNode);
        newNode.keySet.add(key);

        //插入到 链表头
        if (currentValue == 0) {
            newNode.next = head.next;
            head.next.pre = newNode;
            newNode.pre = head;
            head.next = newNode;
            return;
        }

        DNode currentNode = valueMap.get(currentValue);
        if (dir == 1) {
            // inc() ，则newNode 放在currentNode之后
            newNode.next = currentNode.next;
            currentNode.next.pre = newNode;
            newNode.pre = currentNode;
            currentNode.next = newNode;
        } else if (dir == -1) {
            //dec()  newNode放在currentNode之前
            newNode.pre = currentNode.pre;
            newNode.next = currentNode;
            currentNode.pre.next = newNode;
            currentNode.pre = newNode;
        }
    }

    /***
     * 删除节点
     * @param currentValue
     */
    private void removeNode(int currentValue) {
        DNode currentNode = valueMap.get(currentValue);
        //哪里维护 DNode 的 HashSet
        if (currentNode.keySet.isEmpty()) {
            valueMap.remove(currentValue);
            currentNode.next.pre = currentNode.pre;
            currentNode.pre.next = currentNode.next;
            currentNode.pre = null;
            currentNode.next = null;
        }
    }

    // 新key 设为1， 如果已存在， 则 加一
    public void inc(String key) {
        if (keyMap.containsKey(key)) {
            int currentValue = keyMap.get(key);
            valueMap.get(currentValue).keySet.remove(key);
            keyMap.replace(key, currentValue + 1);

            if (valueMap.containsKey(currentValue + 1)) {
                valueMap.get(currentValue + 1).keySet.add(key);
            } else {
                insertNode(key, currentValue, 1);
            }
            removeNode(currentValue);
        } else {
            keyMap.put(key, 1);
            if (valueMap.containsKey(1)) {
                valueMap.get(1).keySet.add(key);
            } else {
                insertNode(key, 0, 1);
            }
        }
    }

    public void dec(String key) {

        if (keyMap.containsKey(key)) {
            //从keyMap中拿到 value
            int currentValue = keyMap.get(key);
            //从valueMap 中 拿到 Node
            DNode currentNode = valueMap.get(currentValue);
            //从node里 删除 key, 因为 value -1 了；
            currentNode.keySet.remove(key);
            if (currentValue == 1) {
                //如果1 需要删除
                keyMap.remove(key);
                // 为啥要都删 这个 node ?
                //如果别的 key  也包含这个 currentValue 咋办？
                removeNode(currentValue);
                return;
            }

            keyMap.replace(key, currentValue - 1);
            if (valueMap.containsKey(currentValue - 1)) {
                valueMap.get(currentValue - 1).keySet.add(key);
            } else {
                insertNode(key, currentValue, -1);
            }
            removeNode(currentValue);

        } else {
            //如果不包含 啥也不做
        }


    }

    public String getMinKey() {
        return (head.next == tail) ? "" : head.next.keySet.iterator().next();
    }

    public String getMaxKey() {
        return tail.pre == head ? "" : tail.pre.keySet.iterator().next();
    }


    public static void main(String... args) {

        String key1 = "AllOne";
        String key2 = "getMaxKey";
        String key3 = "getMin";
        A432_self_prac a432 = new A432_self_prac();

        a432.inc(key1);
        a432.inc(key2);
        a432.inc(key3);
        a432.inc(key3);
        a432.inc(key3);

        a432.dec(key1);

        System.out.println(a432.getMaxKey());
        System.out.println(a432.getMinKey());

    }

}
