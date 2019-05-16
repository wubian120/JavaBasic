package cn.brady.leecode;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/11 01:02
 */
public class A101对称二叉树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null)return true;
        return isSymmetric(root.left,root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        //如果左子，右子 都空， 则 true
        if (left == null && right == null) return true;
        //如果 左子 右子 有一个为空 则 false
        if (left == null || right == null) return false;
        //对称的条件， 根相等， 左子 的左子 与 右子的 右子 对称，  左子的右子 与 右子的 左子 对称
        return left.val == right.val
                && isSymmetric(left.left, right.right)
                && isSymmetric(left.right, right.left);
    }
}
