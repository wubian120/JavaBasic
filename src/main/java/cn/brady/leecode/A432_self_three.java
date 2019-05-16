package cn.brady.leecode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/4 16:32
 */
public class A432_self_three {

    class ListNode {
        HashSet<String> keySet;
        ListNode pre, next;

        ListNode() {
            keySet = new HashSet<>();
        }
    }

    private HashMap<String, Integer> keyMap;
    private HashMap<Integer, ListNode> valueMap;
    ListNode head, tail;

    A432_self_three() {
        keyMap = new HashMap<>();
        valueMap = new HashMap<>();
        head = tail = new ListNode();
        head.next = tail;
        tail.pre = head;
    }

    public void inc(String key) {

        if(keyMap.containsKey(key)){
            int curvalue = keyMap.get(key);
            valueMap.get(curvalue).keySet.remove(key);
            keyMap.replace(key, curvalue+1);

            if(valueMap.containsKey(curvalue+1)){
                valueMap.get(curvalue+1).keySet.add(key);
            }else {
                insertNode(key,curvalue,1);
            }
            removeNode(curvalue);
        }else {
            keyMap.put(key,1);
            if(valueMap.containsKey(1)){
                valueMap.get(1).keySet.add(key);
            }else {
                insertNode(key,0,1);
            }

        }
    }

    public void dec(String key) {
        if(keyMap.containsKey(key)){
            int currentValue = keyMap.get(key);
            ListNode curnode = valueMap.get(currentValue);
            curnode.keySet.remove(key);
            if(currentValue==1){
                //delete key, delete node
                keyMap.remove(key);
                removeNode(currentValue);
                return;
            }

            keyMap.replace(key, currentValue-1);
            if(valueMap.containsKey(currentValue-1)){
                valueMap.get(currentValue-1).keySet.add(key);
            }else {
                insertNode(key, currentValue,-1);
            }
            removeNode(currentValue);
        }

    }

    public String getMaxKey() { return tail.pre == head ? "" : tail.pre.keySet.iterator().next(); }

    public String getMinKey() { return head.next == tail ? "" : head.next.keySet.iterator().next(); }

    private void insertNode(String key, int currentValue, int dir) {
        ListNode newNode = new ListNode();

        newNode.keySet.add(key);

        valueMap.put(currentValue+dir,newNode);

        if(currentValue == 0){
            // 放在 head 后
            newNode.next = head.next;
            newNode.pre = head;
            head.next.pre = newNode;
            head.next = newNode;
            // dont forget return
            return;
        }

        ListNode currentNode = valueMap.get(currentValue);
        if(dir == 1){
            //currentNode 前， newNode 后
            newNode.pre = currentNode;
            newNode.next = currentNode.next;
            currentNode.next.pre = newNode;
            currentNode.next = newNode;

        }else if(dir == -1){
            //newnode 前  currentNode 后
            newNode.next = currentNode;
            newNode.pre = currentNode.pre;


            currentNode.pre.next = newNode;
            currentNode.pre = newNode;
        }
    }

    private void removeNode(int currentValue) {
        ListNode currentNode = valueMap.get(currentValue);
        if (currentNode.keySet.isEmpty()) {
            valueMap.remove(currentValue);
            currentNode.pre.next = currentNode.next;
            currentNode.next.pre = currentNode.pre;
            currentNode.next = null;
            currentNode.pre = null;
        }
    }

    public static void main(String...args){

        A432_self_three a432_self_three = new A432_self_three();
        a432_self_three.inc("hello");
        a432_self_three.inc("hello");
        a432_self_three.inc("world");
        a432_self_three.inc("world");
        a432_self_three.inc("hello");
        a432_self_three.dec("hello");

        System.out.println(a432_self_three.getMaxKey());
        System.out.println(a432_self_three.getMinKey());
        a432_self_three.inc("world");
        a432_self_three.inc("world");
        a432_self_three.inc("leet");
        System.out.println(a432_self_three.getMaxKey());
        System.out.println(a432_self_three.getMinKey());

        a432_self_three.inc("leet");
        a432_self_three.inc("leet");
        System.out.println(a432_self_three.getMinKey());


    }

}
