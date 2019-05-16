package cn.brady.leecode;

/**
 * @description: 104 二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/submissions/
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 *
 * @auther: bian.wu
 * @date: 2019/3/31 17:35
 */
public class A104二叉树的最大深度 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * @status pass
     * @beat  52%
     * @ref https://blog.csdn.net/SoulOH/article/details/81050602
     */
    int result = 0;

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        result = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        return result;
    }

}
