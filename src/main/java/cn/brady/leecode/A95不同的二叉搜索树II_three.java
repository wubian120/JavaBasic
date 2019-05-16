package cn.brady.leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/2 20:24
 */
public class A95不同的二叉搜索树II_three {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /***
     * @beat 53%
     * @ref https://blog.csdn.net/weixin_38823568/article/details/82872770
     * @param n
     * @return
     */
    public static List<TreeNode> generateTrees(int n) {
        if(0 == n){
            return new ArrayList<>();
        }
        return generateTrees(0, n);
    }
    private static  List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> res = new LinkedList<>();
        if(start == end){
            res.add(null);
            return res;
        }

        if(start+1 == end){
            //只有一个数字

            res.add(new TreeNode(start+1));
        } else if(start+2 == end){
            //有俩数字，  两种情况， 一种 大的为小的 右子
            TreeNode start1 = new TreeNode(start+1);
            TreeNode end1 = new TreeNode(start+2);
            start1.right = end1;
            res.add(start1);
            // 一种 小的为大的左子
            TreeNode start2 = new TreeNode(start+1);
            TreeNode end2 = new TreeNode(start+2);
            end2.left = start2;
            // 每次加入 list  代表完成一次。
            res.add(end2);
        } else {
            // 数字大于 2的情况
            for(int i = start; i < end; i++){
                // 左边的 小于 i  左子
                List<TreeNode> left = generateTrees(start, i);
                //右边的 大于 i  右子
                List<TreeNode> right = generateTrees(i+1, end);

                //把建好的 子树 连上
                for(int m = 0; m < left.size(); m++){
                    for(int n = 0; n < right.size(); n++){
                        TreeNode root = new TreeNode(i+1);
                        root.left = left.get(m);
                        root.right = right.get(n);
                        res.add(root);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String...args){

        int n = 3;

        List<TreeNode> treeNodeList = A95不同的二叉搜索树II_three.generateTrees(n);

        System.out.println("end");

    }


}
