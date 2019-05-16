package cn.brady.leecode;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: leecode  83. 删除排序链表中的重复元素
 *
 * 通过
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * @auther: bian.wu
 * @date: 2019/1/12 17:31
 */
public class LC83_1st {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode deleteDuplicates(ListNode head) {

        if(head == null){
            return null;
        }
        Set<Integer> valueSet = new HashSet<>();
        ListNode root = new ListNode(head.val);
        ListNode temp = root;
        valueSet.add(head.val);
        if(head.next != null){
            head = head.next;
        }

        while (head != null) {
            int value = head.val;
            if (!valueSet.contains(value)) {
                valueSet.add(value);
                temp.next = new ListNode(value);
                temp = temp.next;
            }
            head = head.next;

            System.out.println("val :" + value);
        }

        if (root.next != null) {
            if (root.val == root.next.val) {
                root.next = null;
            }
        }

        return root;
    }

    public ListNode createList(int[] nums) {

        if (nums.length == 0) {
            return null;
        }
        ListNode head = null;
        ListNode node = null;

        for (int i : nums) {
            if (head == null) {
                head = new ListNode(i);
            } else {
                ListNode temp = new ListNode(i);
                node = head;
                while (node.next != null) {
                    node = node.next;
                }
                node.next = temp;
            }
        }
        return head;
    }

    public static void main(String... args) {

        int[] num1 = {1, 2, 2, 3};
        int[] num2 = {1, 1};
        int[] num3 = {1, 1, 2};
        LC83_1st lc83_1st = new LC83_1st();
        ListNode root = lc83_1st.createList(num3);

        ListNode result = lc83_1st.deleteDuplicates(root);

        System.out.println("....");


    }

}
