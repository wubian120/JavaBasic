package cn.brady.leecode;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/15 09:42
 */
public class Tools {


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 通过数组 构建 链表
     * @param nums
     * @return
     */
    public static ListNode buildList(int[] nums){
        ListNode head = new ListNode(nums[0]);
        ListNode current = head;

        for(int i=1;i< nums.length;i++){
            current.next = new ListNode(nums[i]);
            current = current.next;
        }
        return head;
    }


    public static void main(String...args){

        int[] nums = {3,4,5,6,7};
        ListNode head = buildList(nums);

        System.out.println("end");



    }
}
