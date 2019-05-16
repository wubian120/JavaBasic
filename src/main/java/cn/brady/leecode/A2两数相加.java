package cn.brady.leecode;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/add-two-numbers/description/
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * [2,4,3]
 * [5,6,4]
 * @auther: bian.wu
 * @date: 2018/11/28 10:53
 */
public class A2两数相加{


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        List<ListNode> numberList = new LinkedList<ListNode>();
        ListNode lab;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val;
            } else if (l1 == null) {
                sum = l2.val;
            } else if (l2 == null) {
                sum = l1.val;
            }
            lab = new ListNode(sum);
            numberList.add(lab);
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            boolean isAddNew = l1 == null && l2 == null && sum >= 10;
            if (isAddNew) {
                numberList.add(new ListNode(0));
                continue;
            }
        }
        lab = numberList.stream().findFirst().get();

        /**是否大于10 需要进位*/
        boolean isAdd = false;
        if (lab.val >= 10) {
            isAdd = true;
            lab.val -= 10;
        }

        for (int i = 1; i < numberList.size(); i++) {
            ListNode node = numberList.get(i);
            int len = numberList.size();
            if (isAdd) {
                node.val += 1;
                isAdd = false;
            }
            if (i == len - 1 && node.val >= 10) {
                numberList.add(new ListNode(0));
            }
            if (node.val >= 10) {
                isAdd = true;
                node.val -= 10;
            }
            lab.next = node;
            lab = node;
        }

        return numberList.stream().findFirst().get();
    }

    public ListNode constructNode(int[] nums) {

        ListNode head = new ListNode(nums[0]);
        ListNode temp = head;
//        head.next = temp;
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            ListNode node = new ListNode(nums[i]);
            temp.next = node;
            temp = node;
        }
        return head;
    }

    public static void main(String... args) {


        A2两数相加 ast = new A2两数相加();
        int[] num11 = {2, 4, 9};
        int[] num12 = {5, 6, 4};

        int[] num21 = {5};
        int[] num22 = {5};

        int[] num31 = {1, 8};
        int[] num32 = {0};

        int[] num51 = {9, 9};
        int[] num52 = {1};

        int[] num41 = {9};
        int[] num42 = {1,9,8,9,9,9};
        ListNode l1 = ast.constructNode(num41);
        ListNode l2 = ast.constructNode(num42);

        ListNode result = ast.addTwoNumbers(l1, l2);

        System.out.println("end");

    }


}
