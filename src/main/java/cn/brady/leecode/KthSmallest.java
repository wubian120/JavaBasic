/**
 * Copyright (C), 2015-2018, ele me
 * FileName: KthSmallest
 * Author:   bian.wu
 * Date:     2018/6/28 13:33
 * Description: ${DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 */
package cn.brady.leecode;

/**
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/description/
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * @author bian.wu
 * @create 2018/6/28
 * @since 1.0.0
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class KthSmallest {

    public class TreeNode{
        private int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int v){
            this.val = v;
        }
    }
    int[] tree = {3,1,4,10,5,32,21};

    private void buildBST(int[] data){

    }

    public int kthSmallest(TreeNode root, int k){


        int index = 0;
        Map<Integer,Integer> dataMap = new HashMap<>();

        TreeNode temp = root;
        TreeNode left  = null;
        TreeNode right = null;
        boolean isEnd = true;
        while (isEnd){
            if(temp != null){
                right = temp.right;
                left = temp.left;


            }else {
                isEnd = false;
            }

        }



        return 0;
    }





}