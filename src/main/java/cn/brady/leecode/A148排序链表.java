package cn.brady.leecode;

/**
 * @description:
 * @beat    34%
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 *
 * @auther: bian.wu
 * @date: 2019/4/13 17:28
 */
public class A148排序链表 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode tmp = null;
        //分为两部分 fast -> end， slow -> mid
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            tmp = slow;
            slow = slow.next;
        }
        //拆分为两个 链表, slow的上一个节点，的next = null 。
        tmp.next = null;
        ListNode l = mergeSort(head);
        ListNode r = mergeSort(slow);
        return merge(l, r);
    }

    public ListNode merge(ListNode l, ListNode r) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l != null && r != null) {
            if (l.val < r.val) {
                cur.next = l;
                cur = cur.next;
                l = l.next;
            } else {
                cur.next = r;
                cur = cur.next;
                r = r.next;
            }
        }
        if (l != null)
            cur.next = l;
        if (r != null)
            cur.next = r;
        return head.next;
    }



    public  ListNode buildList(int[] nums){
        ListNode head = new ListNode(nums[0]);
        ListNode current = head;

        for(int i=1;i< nums.length;i++){
            current.next = new ListNode(nums[i]);
            current = current.next;
        }
        return head;
    }




    public static void main(String...args){
        int[] nums = {4,2,1,3,6,9,12};
        A148排序链表 a = new A148排序链表();
        ListNode head = a.buildList(nums);

        A148排序链表 a148 = new A148排序链表();
        a148.sortList(head);

        System.out.println("end");

    }
}
