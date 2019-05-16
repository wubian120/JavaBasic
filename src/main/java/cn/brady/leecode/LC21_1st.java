package cn.brady.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: leecode 21 合并两个有序链表
 * <p>
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * @auther: bian.wu
 * @date: 2018/12/26 14:10
 */
public class LC21_1st {
    public static Map<Integer,Integer> numMap = new HashMap<>();
    public static ListNode node = null;
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode temp = null;
        numMap.keySet().stream().sorted();
        for(int num : numMap.keySet()){
            if(node == null){
                node = new ListNode(num);
            }else {

            }
            int literTimes = numMap.get(num);
            if(literTimes > 1){

            }else {
            }
        }

        return null;
    }

    public static ListNode buildListNode(int[] nums) {
        ListNode node = null;
        ListNode lab = null;
        for (int i : nums) {
            if (node == null) {
                node = new ListNode(i);
            } else {
                ListNode tempNode = new ListNode(i);
                lab = node;
                while (lab.next != null) {
                    lab = lab.next;
                }
                lab.next = tempNode;
            }
        }
        return node;
    }

    public static void inputListNode(ListNode node) {
        ListNode tempNode = node;
        while (tempNode != null){
            int number = tempNode.val;
            if(numMap.containsKey(number)){
                int sum = numMap.get(number);
                sum++;
                numMap.put(number,sum);
            }else {
                numMap.put(number,1);
            }
            tempNode = tempNode.next;
        }
    }


    public static void main(String... args) {
        int[] nums1 = {1, 2, 4};
        int[] nums2 = {1, 3, 4};

        ListNode listNode1 = LC21_1st.buildListNode(nums1);
        ListNode listNode2 = LC21_1st.buildListNode(nums2);

        LC21_1st.inputListNode(listNode1);
        LC21_1st.inputListNode(listNode2);

        numMap.keySet().stream().sorted();

        for(int num : numMap.keySet()){

            System.out.println(num);
        }




        System.out.println("end");

    }

}
