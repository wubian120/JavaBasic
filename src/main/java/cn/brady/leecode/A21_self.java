package cn.brady.leecode;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/10 11:08
 */
public class A21_self {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode buildListNode(int[] nums) {
        ListNode node = null;
        ListNode lab = null;
        for (int i : nums) {
            if (node == null) {
                node = new ListNode(i);
            } else {
                ListNode tempNode = new ListNode(i);
                lab = node;
                while (lab.next != null) {
                    lab = lab.next;
                }
                lab.next = tempNode;
            }
        }
        return node;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        ListNode p = l1, q = l2;
        while (p != null && q != null) {
            if(p.val<=q.val){
                cur.next = new ListNode(p.val);
                cur = cur.next;
                p = p.next;
            }else {
                cur.next = new ListNode(q.val);
                cur = cur.next;
                q = q.next;
            }
        }
        while (p != null){
            cur.next = new ListNode(p.val);
            cur = cur.next;
            p= p.next;
        }
        while (q !=null){
            cur.next = new ListNode(q.val);
            cur = cur.next;
            q = q.next;
        }
        return head.next;
    }

    public static void main(String...args){

        int[] n1 = {2,4,30};
        ListNode node1 = buildListNode(n1);

        int[] n2 = {1,3,5,6,7};
        ListNode node2 = buildListNode(n2);


    }

}
