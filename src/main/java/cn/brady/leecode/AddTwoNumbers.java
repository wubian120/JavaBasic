package cn.brady.leecode;


import java.util.*;

/**
 * date:2017-11-02
 * status:
 * https://leetcode.com/problems/add-two-numbers/description/
 */
public class AddTwoNumbers {

    static  class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }

    public  static  int node2int(ListNode node){
        int i = node.val;
        int j = 10;
        while (node.next != null){
            i += node.next.val * j;
            node = node.next;
            j *= 10;
        }
        return i;
    }

    public static ListNode int2node(int i){
        ListNode node = null;

        int d = 0;
        int r = i;
        while(r != 0){
            r /= 10;
            d++;
        }

        node = new ListNode(d);
        return node;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){

        ListNode result = null;

        Map<Integer, ListNode> nodeMap = new HashMap<>();
        int i = 1;
        while (l1.next != null && l1.next != null){
            int r = l1.val +l2.val ;
            l1 = l1.next;
            l2 = l2.next;

            result = new ListNode(r);
            nodeMap.put(i++, result);
        }
        result = new ListNode(l1.val + l2.val);
        nodeMap.put(i, result);

        ListNode temp = result;
        i--;
        for(;i>0; i--){
            ListNode node = nodeMap.get(i);
            temp.next = node;
            temp = node;
        }
        return result;
    }

    public static int[] getDigit(int i, int n){

        int result[] = new int[n];
        for(int j = n; j > 0 ; j--){
            int t;
            if(i >= 10){
                t = i/10;
                int z = t;
                t *= 10;
                int r = i - t;
                i = z;
                result[j-1] = r;
            }else {
                result[j-1] = i;
            }
        }
        return result;
    }

    public static ListNode transfer(int[] digits){

        ListNode re = null;
        if(digits != null && digits.length > 0){
            int length = digits.length;
            int i = length-1;
            re = new ListNode(digits[i--]);

            ListNode ln= re;

            while(i >= 0){
                ListNode n = new ListNode(digits[i--]);
                ln.next = n;
                ln = n;
            }
            // pre order
//            while (i< digits.length){
//                ListNode n = new ListNode(digits[i++]);
//                ln.next = n;
//                ln = n;
//            }
        }

        return re;

    }

    public static int getLength(int i){
        if(i > 0){
            int l = 0;
            int t = i;
            while(t != 0){
                t /= 10;
                l++;
            }
            return l;

        }else {
            return 0;
        }
    }

    public static void main(String[] args){

        ListNode n11 = new ListNode(2);
        ListNode n12 = new ListNode(4);
        ListNode n13 = new ListNode(3);
        n11.next = n12;
        n12.next = n13;

        ListNode n21 = new ListNode(5);
        ListNode n22 = new ListNode(6);
        ListNode n23 = new ListNode(4);
        n21.next = n22;
        n22.next = n23;

        int i = node2int(n11);
        int j = node2int(n21);
        System.out.println(i);
        System.out.println(j);

        int t = 23;
        int r = t / 100;

//        System.out.println(r);

        int sample = i + j;

        ListNode n = int2node(sample);

//        System.out.println(n.val);

        int[] tt = getDigit(sample, 3);

//        for(int ii : tt){
//            System.out.println(ii);
//            System.out.println(tt.length);
//        }
        System.out.println("----------------");
//        ListNode ln = transfer(tt);

        int nlength = getLength(234);
//        System.out.println(nlength);
        totalTransfer(n11, n21);

        System.out.println("...End...");

    }

    public static void totalTransfer(ListNode ln1, ListNode ln2){
        int i1 = node2int(ln1);
        int i2 = node2int(ln2);

        int result = i1+i2;
        int length = getLength(result);
        int[] digits = getDigit(result,length);

        ListNode fNode = transfer(digits);

        System.out.println("HoooYa");



    }

}
