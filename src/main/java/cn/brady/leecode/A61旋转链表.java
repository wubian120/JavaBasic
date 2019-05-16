package cn.brady.leecode;

/**
 * @description:
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 * @beat  99%
 * @auther: bian.wu
 * @date: 2019/4/18 20:01
 */
public class A61旋转链表 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k <= 0)
            return head;
        // 新建一个结点，利于操作
        ListNode tmpHead = new ListNode(0);
        tmpHead.next = head;
        // 使用快慢指针，计算倒数节点数目
        ListNode fast = tmpHead;
        ListNode slow = tmpHead;
        int len = 0;
        // 计算链表长度
        while (slow.next != null) {
            len++;
            slow = slow.next;

        }
        slow = tmpHead;
        // 关键，记录k 的有效长度，输入会有k大于链表长度值 if k > len ？
        k = (len + (k % len)) % len;
        // 不需要翻转
        if (k == 0)
            return tmpHead.next;
        // 快指针先走k步
        while (--k >= 0)
            fast = fast.next;
        // 一起走
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 0  -> 1  -> 2  -> 3  -> 4  -> 5 -> NULL;
        // |               |             |
        // cur            slow          fast
        // 重新链接链表，注意置空
        tmpHead.next = slow.next;
        fast.next = head;
        slow.next = null;
        // 4  -> 5  -> 0  -> 1  -> 2  -> 3 -> NULL;
        // |               |             |
        // fast            cur          slow



        return tmpHead.next;


    }

}
