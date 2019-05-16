package cn.brady.leecode;

import java.util.HashMap;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/3/30 16:17
 */
public class A146LRU缓存_one {

    private HashMap<Integer,CacheNode> map;
    private int capacity;

    private CacheNode head = new CacheNode(-1,-1);
    private CacheNode tail = new CacheNode(-1,-1);

    private class CacheNode{
        int key, value;
        CacheNode pre, next;

        CacheNode(int key, int value){
            this.key = key;
            this.value = value;
            this.pre = null;
            this.next = null;
        }
    }

    A146LRU缓存_one(int capacity){
        this.map = new HashMap<>();
        this.capacity = capacity;
    }


}
