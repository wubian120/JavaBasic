package cn.brady.leecode;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/19 09:34
 */
public class A82删除排序链表中的重复元素II {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {

        if(head==null||head.next == null) return head;

        ListNode node = head;
        boolean flag = false;
        //重复
        while(head.next!=null&&head.val==head.next.val){
            head = head.next;
            flag = true;
        }
        //如果不重复
        if(!flag){
            node.next = deleteDuplicates(head.next);
            return node;
        }
        return deleteDuplicates(head.next);

    }

}
