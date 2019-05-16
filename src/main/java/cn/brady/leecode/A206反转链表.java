package cn.brady.leecode;

/**
 * @description: https://leetcode-cn.com/problems/reverse-linked-list/submissions/
 * <p>
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * @beat 100%
 * @auther: bian.wu
 * @date: 2019/4/19 12:58
 */
public class A206反转链表 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode pre = head.next;
        ListNode cur = pre.next;
        // head 变为tail
        head.next = null;
        /***
         *
         *   head -> pre -> cur
         *   以 pre 为中心 ， pre 回指向 head， cur 往下走。
         */
        while (cur != null) {
            // head 变成 tail， pre反指回去
            pre.next = head;
            //整体往下走
            head = pre;

            pre = cur;

            cur = cur.next;
        }
        //最后 指回去
        pre.next = head;
        return pre;
    }
}
