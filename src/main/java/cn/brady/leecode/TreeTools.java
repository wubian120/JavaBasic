package cn.brady.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/11 15:10
 */
public class TreeTools {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }


    public static TreeNode buildTree(int[] nums) {

        int len = nums.length;
        List<TreeNode> treeList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            TreeNode node = new TreeNode(nums[i]);
            treeList.add(node);
        }

        for (int i = 0; i < len; i++) {
            TreeNode node = treeList.get(i);
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < len) {
                node.left = treeList.get(left);
            }
            if (right < len) {
                node.right = treeList.get(right);
            }
        }
        return treeList.get(0);
    }

    public static void main(String...args){
        int[] nums = {1,2,3,4,5,6,7};

        TreeNode root= TreeTools.buildTree(nums);

        System.out.println("end");
    }

}
