package cn.brady.leecode;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/11 10:45
 */
public class A2_self {

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


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        int sum = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 == null ? 0 : l1.val);
            int y = (l2 == null ? 0 : l2.val);

            current.next = new ListNode((x + y + sum) % 10);
            current = current.next;
            //取高位的值
            sum = (x+y+sum) / 10;
            if(l1 !=null){
                l1 = l1.next;
            }
            if(l2 !=null){
                l2 = l2.next;
            }
        }
        //进位
        if(sum>0){
            current.next = new ListNode(sum);
        }
        return head.next;
    }


    public static void main(String...args){



    }
}
