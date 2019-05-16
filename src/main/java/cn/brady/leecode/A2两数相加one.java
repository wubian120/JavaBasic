package cn.brady.leecode;

/**
 * @description:
 * 给出两个 非空 的链表用来表示两个非负的整数。
 * 其中，它们各自的位数是按照 逆序 的方式存储的，
 * 并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @auther: bian.wu
 * @date: 2019/4/11 10:34
 */
public class A2两数相加one {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode constructNode(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode temp = head;
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            ListNode node = new ListNode(nums[i]);
            temp.next = node;
            temp = node;
        }
        return head;
    }

    /***
     * @beat  75%
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode cal = listNode;
        int sum = 0;
        while (l1 != null || l2 != null) {

            int x = (l1 == null ? 0 : l1.val);
            int y = (l2 == null ? 0 : l2.val);

            cal.next = new ListNode((x + y + sum) % 10);
            cal = cal.next;

            sum = (x + y + sum) / 10;

            //往下走
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (sum > 0) {
            cal.next = new ListNode(sum);
        }
//        listNode = listNode.next;
        //listNode.next=null;
        return listNode.next;
    }

    public static void main(String... args) {
        int[] num11 = {2, 4, 9};
        int[] num12 = {5, 6, 4};

        A2两数相加one a2one = new A2两数相加one();
        ListNode l1 = a2one.constructNode(num11);
        ListNode l2 = a2one.constructNode(num12);
        ListNode result = a2one.addTwoNumbers(l1, l2);

        System.out.println("end");

    }

}
