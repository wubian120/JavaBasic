package cn.brady.leecode;

/**
 * @description:  98 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/submissions/
 *
 * @auther: bian.wu
 * @date: 2019/3/31 17:28
 */
public class A98验证二叉搜索树 {

    /**
     * Definition for a binary tree node.
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * @status pass
     * @beat   52%
     * @ref https://blog.csdn.net/xushiyu1996818/article/details/82769330
     *
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean result = true;
        if (root.left != null) {
            if (getMaxVal(root.left) >= root.val) {
                result = false;
            }
        }
        if (root.right != null) {
            if (getMinVal(root.right) <= root.val) {
                result = false;
            }
        }
        if (!isValidBST(root.left)) {
            result = false;
        }
        if (!isValidBST(root.right)) {
            result = false;
        }

        return result;
    }

    public int getMaxVal(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }

    public int getMinVal(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }


    /***
     * @beat  95%
     * @param root
     * @return
     */
    public boolean isValidBST_two(TreeNode root) {
        //Long.MIN_VALUE

        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);

    }

    public boolean isValidBST(TreeNode root,long left,long right) {
        if(root==null) return true;
        if(root.val<=left || root.val>=right) return false;
        return isValidBST(root.left,left,root.val) && isValidBST(root.right,root.val,right);
    }

    public boolean isValidBST_two(TreeNode root, int leftVal, int rightVal){

        if(root == null) return true;
        if(root.val <= leftVal || root.val >= rightVal) return false;
        return isValidBST_two(root.left, root.left.left.val, root.left.right.val) && isValidBST_two(root.right,root.right.left.val,root.right.right.val);
    }


}
