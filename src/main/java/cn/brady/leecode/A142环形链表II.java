package cn.brady.leecode;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/19 17:54
 */
public class A142环形链表II {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fp = head, sp = head;
        while (fp != null && fp.next != null) {
            sp = sp.next;
            fp = fp.next.next;
            //判断是否成环
            if (fp == sp) {
                break;
            }
        }
        // 这个什么意思？
        if (fp == null || fp.next == null) {
            return null;
        }
        //fp到环入口距离 = head到环入口距离
        sp = head;
        while (fp != sp) {
            sp = sp.next;
            fp = fp.next;
        }
        return sp;
    }
}
