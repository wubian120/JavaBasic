package cn.brady.collections;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListTraverse {


    public static void main(String[] args){

        List<Integer> listOne = new ArrayList<>();
        for(int i= 1 ; i<20;i++){
            listOne.add(i);
        }


        Iterator<Integer> iterator = listOne.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
        System.out.println("List Iterator...");
        ListIterator<Integer> listIterator = listOne.listIterator();
        while (listIterator.hasNext()){
            listIterator.next();
        }

        while (listIterator.hasPrevious()){
            System.out.println(listIterator.previous().toString());
        }



    }

}
