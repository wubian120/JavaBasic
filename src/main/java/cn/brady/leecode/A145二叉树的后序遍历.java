package cn.brady.leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/12 10:15
 */
public class A145二叉树的后序遍历 {

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

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    /***
     * 递归实现
     */
    static List<Integer> list = new ArrayList<Integer>();
    public static List<Integer> postorderTraversal(TreeTools.TreeNode root) {
        if(root==null)
            return list;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }


    /***
     * 非递归
     */
    public List<Integer> postorderTraversal_two(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<>();
        if(root==null)
            return res;
        Stack<TreeNode> s=new Stack<>();
        s.push(root);
        while (!s.empty()){
            TreeNode temp=s.pop();
            res.add(0,temp.val);//根右左-左右根（每次都在第一个位置添加，相当于reverse）
            //借助栈的先进后出(根左右-根右左)
            if(temp.left!=null){
                s.push(temp.left);
            }
            if(temp.right!=null){
                s.push(temp.right);
            }
        }
        return res;
    }


}
