package cn.brady.leecode;

/**
 * @description:   23 合并K个排序链表    堆 链表  分治算法
 * @auther: bian.wu
 * @date: 2019/3/21 00:22
 */
public class A23合并K个排序链表 {


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

//  todo: 23 合并k个排序链表 堆
//  todo: 1.跟一遍
//  todo: 2.理解
//  todo: 3. 背着写一遍
//  todo: 4.可以默写完成

    /**
     * 参考 ： https://blog.csdn.net/qq_17550379/article/details/81151977
     *
     * https://www.cnblogs.com/yanhowever/p/10457544.html （major）
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 1)
            return lists[0];
        else if (lists == null)
            return null;
        return MSort(lists, 0, lists.length - 1);
    }

    public ListNode MSort(ListNode[] lists, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            ListNode leftlist = MSort(lists, low, mid);
            ListNode rightlist = MSort(lists, mid + 1, high);
            return mergeTwoLists(leftlist, rightlist);
        } else if (low == high) {
            return lists[low];//
        } else
            return null; //
    }

    /***
     * 合并两个有序链表  pass
     * @beats  99%
     *
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        ListNode p = l1, q = l2;
        while (p != null && q != null) {
            if (p.val <= q.val) {
                cur.next = new ListNode(p.val);
                cur = cur.next;
                p = p.next;
            } else {
                cur.next = new ListNode(q.val);
                cur = cur.next;
                q = q.next;
            }
        }
        while (p != null) {
            cur.next = new ListNode(p.val);
            cur = cur.next;
            p = p.next;
        }
        while (q != null) {
            cur.next = new ListNode(q.val);
            cur = cur.next;
            q = q.next;
        }
        return head.next;
    }

    public static void main(String... args) {


    }

}
