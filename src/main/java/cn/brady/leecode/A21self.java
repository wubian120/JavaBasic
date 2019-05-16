package cn.brady.leecode;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/7 16:58
 */
public class A21self {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return l1==null ? l2:l1;
        }

        if(l1.val>l2.val){
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }else{
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }
    }

}
