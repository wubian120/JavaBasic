/**
 * Copyright (C), 2015-2018, ele me
 * FileName: KthSmallestSnd
 * Author:   bian.wu
 * Date:     2018/7/4 13:28
 * Description: ${DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 */
package cn.brady.leecode;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/description/
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * @author bian.wu
 * @create 2018/7/4
 * @since 1.0.0
 */
public class KthSmallestSnd {

    public class TreeNode {
        private int val;
        KthSmallestSnd.TreeNode left;
        KthSmallestSnd.TreeNode right;

        TreeNode(int v) {
            this.val = v;
        }
    }


    public int kthSmallest(TreeNode root, int k) {

        if (root == null || k == 0) return -1;
        Stack<TreeNode> nodeStack = new Stack<>();

        TreeNode node = root;
        int knum = 0;
        nodeStack.add(node);
        while (node !=null || !nodeStack.isEmpty()){

            while (node != null){
                nodeStack.add(node);
                node = node.left;
            }

            node = nodeStack.pop();
            knum++;
            if(knum == k){
                return node.val;
            }
        }

        return -1;
    }


    public static void main(String... args){

//        TreeNode




    }


}