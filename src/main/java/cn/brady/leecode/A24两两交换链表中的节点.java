package cn.brady.leecode;

/**
 * @description:
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * @auther: bian.wu
 * @date: 2019/4/17 12:59
 */
public class A24两两交换链表中的节点 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /***
     * @beat   100%
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode ahead = new ListNode(0);
        ahead.next = head;
        ListNode current = ahead;

        while (head!=null && head.next!=null){

            current.next = head.next;
            head.next = current.next.next;
            current.next.next = head;
            https://zhuanlan.zhihu.com/p/26733914?refer=dreawer
            current = current.next.next;
            head = current.next;
        }

        return ahead.next;

    }

}
