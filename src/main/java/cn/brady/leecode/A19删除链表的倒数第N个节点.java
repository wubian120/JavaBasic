package cn.brady.leecode;

/**
 * @description: 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * @auther: bian.wu
 * @date: 2019/4/17 10:39
 */
public class A19删除链表的倒数第N个节点 {

    /***
     * @beat 99%
     * @param head
     * @param n
     * @return
     */
    public static Tools.ListNode removeNthFromEnd(Tools.ListNode head, int n) {
        //一个正向， 一个逆向 节点
        Tools.ListNode p = head;
        Tools.ListNode q = head;
        //         p先移动n个位置
        for (int i = 0; i < n; i++) {
            p = p.next;
        }

        if (p == null) {
            head = head.next;
            return head;
        }
//         当p达到尾部
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return head;

    }

    public static void main(String... args) {

        int[] nums = {3, 4, 5, 6, 7};
        Tools.ListNode head = Tools.buildList(nums);

        Tools.ListNode headAfter = A19删除链表的倒数第N个节点.removeNthFromEnd(head, 2);


        System.out.println("end");


    }

}
