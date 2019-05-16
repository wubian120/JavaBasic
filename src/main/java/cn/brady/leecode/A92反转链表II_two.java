package cn.brady.leecode;

/**
 * @description:
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
 *
 * @beat   100%
 * @auther: bian.wu
 * @date: 2019/4/19 17:05
 */
public class A92反转链表II_two {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n || head == null || head.next == null)
            return head;

        ListNode cur = head;
        ListNode pre = null;
        int count = 1;
        //向前走 m
        while (count < m) {
            pre = cur;
            cur = cur.next;
            count++;
        }
        //保存现场 tpre -> tcur -> nextNode
        ListNode tpre = pre;
        ListNode tcur = cur;
        ListNode nextNode = cur.next;

        //pre -> cur -> nextNode
        while (count < n && cur != null) {
            //往前走
            pre = cur;
            cur = nextNode;

            nextNode = cur.next;
            //指回去
            cur.next = pre;
            count++;
        }
        if (tpre != null)
            tpre.next = cur;
        tcur.next = nextNode;
        if (m == 1)
            return cur;
        return head;
    }


    public ListNode buildList(int[] nums){
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

        A92反转链表II_two  a = new A92反转链表II_two();
        ListNode head = a.buildList(nums);

        head = a.reverseBetween(head,2,4);

        System.out.println("end");

    }



}
