package cn.brady.leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/1 20:53
 */
public class A94二叉树的中序遍历 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return list;
    }

    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
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
        int[] numbers = {1,0,2,3};

        TreeNode root = A94二叉树的中序遍历.buildTree(numbers);


        System.out.println("end");

    }




    /***
     * 非递归
     * @beat 43%
     * @return
     */
    public List<Integer> inorderTraversal_two(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        //往左走
        while(null != root){
            stack.push(root);
            root = root.left;
        }

        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if(null != cur.right){
                stack.push(cur.right);
                while(null != stack.peek().left)
                    stack.push(stack.peek().left);
            }
        }

        return res;
    }


    /***
     * 非递归
     * @beat 43%
     */
    List<Integer> data;
    public List<Integer> inorderTraversal_three(TreeNode root)
    {
        data=new ArrayList<>();
        Stack<TreeNode> temp=new Stack<>();

        TreeNode treeNode=root;
        while (treeNode!=null||!temp.empty())
        {
            /*
             * 当前节点入栈，treenode指向当前节点的left节点
             */
            while (treeNode!=null)
            {
                temp.push(treeNode);
                treeNode=treeNode.left;
            }
            //
            if (!temp.empty())
            {
                treeNode=temp.pop();
                data.add(treeNode.val);
                treeNode=treeNode.right;
            }

        }
        return data;
    }



}
