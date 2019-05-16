package cn.brady.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/30 15:39
 */
public class TreeBuilder {

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


    public static void main(String... args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        TreeNode root = TreeBuilder.buildTree(nums);

        System.out.println("end");


    }

}
