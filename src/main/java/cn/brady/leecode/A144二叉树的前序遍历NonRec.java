package cn.brady.leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @description:  非递归实现
 * @beat           38%
 * @ref  https://www.cnblogs.com/liuyang0/p/6271331.html
 * @auther: bian.wu
 * @date: 2019/4/17 06:19
 */
public class A144二叉树的前序遍历NonRec {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode createTree(int[] nums) {
        List<TreeNode> nodes = new LinkedList<>();
        for (int i : nums) {
            nodes.add(new TreeNode(i));
        }
        int len = nums.length;

        for (int i = 0; i < len / 2 - 1; i++) {
            nodes.get(i).left = nodes.get(2 * i + 1);
            nodes.get(i).right = nodes.get(2 * i + 2);
        }
        int lastParentIndex = len / 2 - 1;
        TreeNode lastParent = nodes.get(lastParentIndex);
        lastParent.left = nodes.get(2 * lastParentIndex + 1);
        if (len % 2 == 1) {
            lastParent.right = nodes.get(2 * lastParentIndex + 2);
        }
        return nodes.get(0);
    }


    List<Integer> valueList = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.empty())
        {
            while(root != null)
            {
                valueList.add(root.val);
                stack.push(root);
                root = root.left;
            }
            if(!stack.empty())
            {
                root = stack.pop();
                root = root.right;
            }
        }

        return valueList;
    }

    public static void main(String...args){

        int[] nums = {1,2,3,4,5,6,7,8};

        TreeNode root = createTree(nums);




        System.out.println("end");



    }

}
