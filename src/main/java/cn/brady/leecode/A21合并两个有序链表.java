package cn.brady.leecode;

/**
 * @description: leetcode 21 合并有序链表
 * @题目： https://leetcode-cn.com/problems/merge-two-sorted-lists/submissions/
 * @递归解法: https://www.cnblogs.com/leavescy/p/5879625.html
 * @非递归解法 ： https://blog.csdn.net/zxzxzx0119/article/details/81710111
 * https://blog.csdn.net/zxzxzx0119/article/details/81710111
 * @auther: bian.wu
 * @date: 2019/3/10 15:45
 */
public class A21合并两个有序链表 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**递归解法**/
    public ListNode reMergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 == null ? l2 : l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }




    /**非递归解法 */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null)
            cur.next = l1;
        if (l2 != null)
            cur.next = l2;
        return dummyHead.next;

    }

    public static ListNode mergeTwo(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l2;
        }
        ListNode label = new ListNode(-1);
        ListNode cur = label;
        while (l1 !=null && l2 != null){
            if(l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if(l1 != null){
            cur.next = l1;
        }
        if(l2 != null){
            cur.next = l2;
        }
        return label.next;
    }


    public static A21合并两个有序链表.ListNode buildListNode(int[] nums) {
        A21合并两个有序链表.ListNode node = null;
        A21合并两个有序链表.ListNode lab = null;
        for (int i : nums) {
            if (node == null) {
                node = new A21合并两个有序链表.ListNode(i);
            } else {
                A21合并两个有序链表.ListNode tempNode = new A21合并两个有序链表.ListNode(i);
                lab = node;
                while (lab.next != null) {
                    lab = lab.next;
                }
                lab.next = tempNode;
            }
        }
        return node;
    }

    public static void main(String... args) {
        int[] nums1 = {1, 2, 4};
        int[] nums2 = {1, 3, 4};

        A21合并两个有序链表.ListNode listNode1 = A21合并两个有序链表.buildListNode(nums1);
        A21合并两个有序链表.ListNode listNode2 = A21合并两个有序链表.buildListNode(nums2);

//        LC21_1st.inputListNode(listNode1);
//        LC21_1st.inputListNode(listNode2);

        A21合并两个有序链表.ListNode result = A21合并两个有序链表.mergeTwoLists(listNode1,listNode2);











        System.out.println("end");

    }

}
