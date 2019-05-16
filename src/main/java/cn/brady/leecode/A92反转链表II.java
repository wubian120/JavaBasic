package cn.brady.leecode;

/**
 * @description:  https://leetcode-cn.com/problems/reverse-linked-list-ii/
 *
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * @beat   92%
 * @auther: bian.wu
 * @date: 2019/4/19 11:50
 */
public class A92反转链表II {


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n)
            return head;

        // gra = pre -> normal = cur
        ListNode normal = head, last = null, pre, cur, gra = new ListNode(0);
        gra.next = head;
        pre = gra;
        cur = head;

        while (cur != null) {
            if (m == 1) {
                normal = cur;
                // 链表反转,头拼接,
                //last 返回 反转后的 那个 node
                last = reverseList(cur, pre, n);
                // 尾拼接
                normal.next = last;
                break;
            }
            cur = cur.next;
            pre = pre.next;
            m--;
            n--;
        }
        return gra.next;
    }

    public ListNode reverseList(ListNode head, ListNode first, int n) {
        ListNode pre = null;
        ListNode next = head;
        // 这段还是没明白  感觉是在交换。
        while (n > 0) {
            ListNode tmp = next.next;
            next.next = pre;
            pre = next;
            next = tmp;
            n--;
        }
        first.next = pre;
        return next;
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

        int[] nums = {1,2,3,4,5};
        A92反转链表II a92 = new A92反转链表II();
        ListNode  head  = a92.buildList(nums);

        head = a92.reverseBetween(head,2,4);

        System.out.println("end");


    }

}
