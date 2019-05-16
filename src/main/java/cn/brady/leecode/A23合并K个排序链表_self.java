package cn.brady.leecode;

/**
 * @description: 23.合并K个排序链表
 * <p>
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 示例:
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * @auther: bian.wu
 * @date: 2019/4/10 11:08
 */
public class A23合并K个排序链表_self {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length > 0) {
            return sort(lists, 0, lists.length - 1);
        } else {
            return null;
        }
    }

    private ListNode sort(ListNode[] lists, int low, int high) {

        if (low < high) {
            int mid = low + (high - low) / 2;
            ListNode left = sort(lists, low, mid);
            ListNode right = sort(lists, mid + 1, high);
            return mergeTwoLists(left, right);

        } else if (low == high) {
            return lists[low];
        } else {
            return null;
        }

    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode ahead = new ListNode(0);
        ListNode current = ahead;

        while (l1!=null && l2!=null){
            if(l1.val<l2.val){
                current.next = new ListNode(l1.val);
                l1 = l1.next;
            }else {
                current.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            current = current.next;
        }

        while (l1 != null){
            current.next = new ListNode(l1.val);
            l1 = l1.next;
            current = current.next;
        }

        while (l2 != null){
            current.next = new ListNode(l2.val);
            current = current.next;
            l2 = l2.next;
        }

        return ahead.next;
    }

}
