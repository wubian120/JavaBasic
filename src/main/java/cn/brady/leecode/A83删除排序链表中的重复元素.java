package cn.brady.leecode;

/**
 * @description:
 * @beat  62%
 * @auther: bian.wu
 * @date: 2019/4/18 17:23
 */
public class A83删除排序链表中的重复元素 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
