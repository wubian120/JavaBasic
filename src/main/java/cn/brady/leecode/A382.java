package cn.brady.leecode;

import java.util.Random;

/**
 * @description:  382 链表随机节点
 * @auther: bian.wu
 * @date: 2019/3/23 22:20
 */
public class A382 {


    /**
     * @status  pass
     * @beats   31%
     * @cost    130ms
     *
     */
    public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

        static ListNode h = null;
        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public A382(ListNode head) {
            this.h = head;
        }

        /** Returns a random node's value. */
        public int getRandom() {
            Random rd = new Random ();
            int ans = -1;
            int idx = 0;
            ListNode p = h;
            while(p!=null){
                idx++;
                int rn = rd.nextInt(idx);
                if(rn==idx-1){
                    ans = p.val;
                }
                p = p.next;
            }
            return ans;
        }



}
