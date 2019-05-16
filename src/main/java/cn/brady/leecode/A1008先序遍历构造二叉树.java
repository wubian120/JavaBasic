package cn.brady.leecode;

/**
 * @description: 返回与给定先序遍历 preorder 相匹配的二叉搜索树（binary search tree）的根结点。
 * <p>
 * (回想一下，二叉搜索树是二叉树的一种，其每个节点都满足以下规则，对于 node.left 的任何后代，
 * 值总 < node.val，而 node.right 的任何后代，值总 > node.val。
 * 此外，先序遍历首先显示节点的值，然后遍历 node.left，接着遍历 node.right。）
 * <p>
 * 示例：
 * 输入：[8,5,1,7,10,12]
 * 输出：[8,5,10,1,7,null,12]
 * @auther: bian.wu
 * @date: 2019/4/30 11:59
 */
public class A1008先序遍历构造二叉树 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    int i = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return construct(preorder, Integer.MAX_VALUE);
    }

    private TreeNode construct(int[] preorder, int bound) {

        if (i == preorder.length || preorder[i] > bound)
            return null;

        TreeNode root = new TreeNode(preorder[i++]);
        root.left = construct(preorder, root.val);
        root.right = construct(preorder, bound);
        return root;
    }

    public static void main(String...args){

        int[] nums = {8,5,1,7,10,12};
        A1008先序遍历构造二叉树 a = new A1008先序遍历构造二叉树();

        TreeNode root = a.bstFromPreorder(nums);

        System.out.println("end");

    }
}
