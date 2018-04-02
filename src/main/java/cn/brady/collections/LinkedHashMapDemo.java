package cn.brady.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {


    public static void hashMapExample(){

        Map<String,String> hashMapDemo = new HashMap<>();

        hashMapDemo.put("key 1","value 1");
        hashMapDemo.put("key 2","value 2");
        hashMapDemo.put("key 3","value 3");
        hashMapDemo.put("key 4","value 4");

        Iterator iterator = hashMapDemo.entrySet().iterator();
        while (iterator.hasNext()){

            Map.Entry entry = (Map.Entry)iterator.next();
            System.out.println("key: " + entry.getKey() + " ... value: " + entry.getValue());

        }

    }


    public static void linkedHashMapExample(){
        Map<String,String> linkedHashMapDemo = new LinkedHashMap<>();

        linkedHashMapDemo.put("apple","apple value");
        linkedHashMapDemo.put("water melon","wm value");
        linkedHashMapDemo.put("banana","banana value");
        linkedHashMapDemo.put("peach","peach value");

        Iterator iterator = linkedHashMapDemo.entrySet().iterator();
        while (iterator.hasNext()){

            Map.Entry entry = (Map.Entry)iterator.next();
            System.out.println("key: " + entry.getKey() + " ... value: " + entry.getValue());

        }

    }

    public static void main(String[] args){

        System.out.println(" hashMap  ");
        LinkedHashMapDemo.hashMapExample();

        System.out.println(" .... ");

        System.out.println(" LinkedHashMap  ");
        LinkedHashMapDemo.linkedHashMapExample();

    }




}
