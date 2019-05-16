package cn.brady.leecode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/5/15 10:06
 */
public class A114二叉树展开为链表 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /***
     * @beat 95%
     * @param root
     */
    public void flatten(TreeNode root) {
        findNext(root);
    }

    private TreeNode findNext(TreeNode root) {
        if (root == null)
            return null;

        TreeNode r = findNext(root.right);
        TreeNode l = findNext(root.left);
        TreeNode tmp = l;

        if (l != null) {
            //tmp 是左子， 如果tmp.right 不空，一直往下走
            while (tmp.right != null)
                tmp = tmp.right;
            //把左子的  最右下 与 原 右子 连上。
            tmp.right = r;
            //根的 右 连为 左子
            root.right = l;
            //根的原左子，置为空。
            root.left = null;
        }
        return root;
    }


    /***
     * @beat 95%
     */
    private TreeNode prev = null;

    public void flatten_two(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }


    /***
     * @beat 60%
     * @param root
     */
    public void flatten_three(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
            if (!stack.isEmpty()) current.right = stack.peek();
            current.left = null;
        }
    }

    public TreeNode buildTree(int[] nums) {
        int len = nums.length;
        List<TreeNode> nodeList = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            TreeNode node = new TreeNode(nums[i]);
            nodeList.add(node);
        }

        for (int i = 0; i < len; i++) {
            TreeNode node = nodeList.get(i);
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if(left<len){
                node.left = nodeList.get(left);
            }
            if(right < len){
                node.right = nodeList.get(right);
            }
        }
        return nodeList.get(0);
    }


    public static void main(String...args){

        int[] nums = {1,2,3,4,5,6,7};

        A114二叉树展开为链表 a = new A114二叉树展开为链表();
        TreeNode root = a.buildTree(nums);
        System.out.println("...");
        a.flatten(root);


        System.out.println("end");

    }


}
