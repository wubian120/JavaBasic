package cn.brady.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 113 路径总和II
 * @auther: bian.wu
 * @date: 2019/5/13 21:41
 */
public class A113路径总和II {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }


    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int path_value = 0;
        preorder(root, path_value, sum, path, result);
        return result;
    }

    public void preorder(TreeNode node, int path_value, int sum, List<Integer> path, List<List<Integer>> result) {
        if (node == null)
            return;
        path_value += node.val;
        path.add(node.val);
        if (node.left == null && node.right == null && path_value == sum)
            result.add(new ArrayList<>(path));
        preorder(node.left, path_value, sum, path, result);
        preorder(node.right, path_value, sum, path, result);
        path_value -= node.val;
        path.remove(path.size() - 1);
    }
}
