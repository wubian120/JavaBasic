//package cn.brady.realization;
//
//import java.io.Serializable;
//import java.util.AbstractMap;
//import java.util.Map;
//
//public class HashMapW<K, V> extends AbstractMap<K, V>
//    implements Map<K,V>, Cloneable, Serializable
//{
//    private static final long  serialVersionUID = 00001;
//
//    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; //aka 16; also known as
//    static final int MAXIMUM_CAPACITY = 1 << 30;
//    static final float DEFAULT_LOAD_FACTOR = 0.75f;
//
//    static final int TREEIFY_THRESHOLD = 8;
//    static final int UNTREEIFY_THRESHOLD = 6;
//
//    static final int MIN_TREEIFY_CAPACITY = 64;
//
//    static class Node<K, v> implements Map.Entry<K, V> {
//        final int hash;
//        final K key;
//        v value;
//        Node<K, V> next;
//
//        Node(int hash, K key, V value, Node<K,V> next){
//            this.hash = hash;
//            this.key = key;
//            this.value = value;
//            this.next = next;
//        }
//
//    }
//
//
//
//}
