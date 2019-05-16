package cn.brady.leecode;

/**
 * @description: 106从中序和后序遍历序列构造二叉树
 *
 *
 * @ref   https://blog.csdn.net/hcm_0079/article/details/82503556
 * @auther: bian.wu
 * @date: 2019/5/8 00:57
 */
public class A106从中序和后序遍历序列构造二叉树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(null == inorder || postorder == null || inorder.length != postorder.length || inorder.length <= 0)
            return null;
        return createTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    public TreeNode createTree(int[] inorder, int is, int ie, int[] postorder, int ps, int pe) {
        if(is > ie || ps > pe)
            return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int i = searchArray(inorder, postorder[pe]);
        root.left = createTree(inorder, is, i - 1, postorder, ps, ps + i - is - 1);
        root.right = createTree(inorder, i + 1, ie, postorder, ps + i - is, pe - 1);
        return root;
    }

    public int searchArray(int[] nums, int key) {   //key一定在nums内
        int i = 0;
        while(nums[i++] != key);
        return --i;
    }

}
