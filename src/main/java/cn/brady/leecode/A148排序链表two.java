package cn.brady.leecode;

import java.util.Arrays;

/**
 * @description: 148 排序链表
 *
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
 * @beat    97.7%
 * @auther: bian.wu
 * @date: 2019/4/13 17:32
 */
public class A148排序链表two {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /***
     * @beat    93%
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode cur = head;
        int count = 0;
        //获取长度
        while (cur != null) {
            count++;
            cur = cur.next;
        }

        int[] arr = new int[count];
        int index = 0;
        cur = head;

        //值导入数组
        while (cur != null) {
            arr[index++] = cur.val;
            cur = cur.next;
        }
        //排序
        Arrays.sort(arr);

        cur = head;
        index = 0;
        //重新赋值
        while (cur != null) {
            cur.val = arr[index++];
            cur = cur.next;
        }
        return head;
    }
}
