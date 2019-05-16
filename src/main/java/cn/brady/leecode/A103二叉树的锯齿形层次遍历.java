package cn.brady.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * @auther: bian.wu
 * @date: 2019/4/13 17:18
 */
public class A103二叉树的锯齿形层次遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeTools.TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeTools.TreeNode node, int l, List<List<Integer>> res) {
        if (node != null) {
            if (l == res.size()) {
                List<Integer> level = new ArrayList<>();
                res.add(level);
            }
            //利用list添加元素的特性来解决问题:过于trick了,还有用单队列双向出队的特性。。
            if (l % 2 == 1) {
                res.get(l).add(0, node.val);  // insert at the beginning
            } else {
                res.get(l).add(node.val);
            }
            dfs(node.left, l+1, res);
            dfs(node.right, l+1, res);
        }
    }


    public static void main(String...args){

        int i=4 ;
        int result = i % 2;
        System.out.println(result);
        int j = 5 ;
        int result1 = j % 2;
        System.out.println(result1);

        System.out.println("end");



    }
}
