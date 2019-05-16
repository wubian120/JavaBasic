package cn.brady.leecode;

/**
 * @description:
 *
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 *
 * 示例 :
 *
 * 给定这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明 :
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * @auther: bian.wu
 * @date: 2019/4/17 13:10
 */
public class A25k个一组翻转链表 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /***
     * @beat  94%
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        int len=0;
        ListNode tmp=head;
        //计算链表长度
        while(tmp!=null){
            len++;
            tmp=tmp.next;
        }
        //根据 k 值，将len分为几组
        len/=k;
        //当没有要反转链表的时候直接返回
        if(len==0)
            return head;
        ListNode cur=head;
        ListNode tail=cur;

        for(int i=0;i<len;i++){
            //newlist表示分离出来的链表
            ListNode newlist=null;
            //newhead表示分离出来链表的头
            ListNode newhead=cur;
            int count=k;
            //反转分离出来的链表
            while(count>0){

                tmp=cur;
                // cur 往下走
                cur=cur.next;
                //本次tmp.next 指向上一次 newlist。
                tmp.next=newlist;
                //newlist ，本次的 cur.
                newlist=tmp;
                count--;
            }

            //只有当第一次反转链表时不用将首尾相连，因为只有头，所以只需要将链表原本的头
            //更新即可，在后面的链表反转中，则需要将分离出来的链表与之前的链表首尾相连
            if(i==0){
                head=newlist;
            }else{
                tail.next=newlist;
                tail=newhead;
            }
        }
        //链接链表剩余的部分， len/k 除不尽 剩余的 node
        while(cur!=null){
            tail.next=cur;
            tail=tail.next;
            cur=cur.next;
        }
        //返回头节点
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

        int len = 10, k = 3;
        len /=k;


        int[] nums = {1,2,3,4,5,6,7,8,9};

        A25k个一组翻转链表 a25 = new A25k个一组翻转链表();
        ListNode head = a25.buildList(nums);

        a25.reverseKGroup(head,k);

        System.out.println("end");

    }
}
