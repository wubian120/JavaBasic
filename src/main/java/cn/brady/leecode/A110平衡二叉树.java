package cn.brady.leecode;

/**
 * @description: 110平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：*
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 * @auther: bian.wu
 * @date: 2019/5/8 06:45
 */
public class A110平衡二叉树 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }else if(Math.abs((depth(root.left)-depth(root.right)) ) > 1){
            return false;
        }else {
            return isBalanced(root.left) && isBalanced(root.right);
        }

    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(depth(root.left), depth(root.right)) + 1;
        }
    }
}
