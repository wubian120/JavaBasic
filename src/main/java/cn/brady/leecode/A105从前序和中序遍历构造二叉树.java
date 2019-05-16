package cn.brady.leecode;

/**
 * @description:
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * @思路:
 *      前序 第一个 是根节点，
 *      在 中序遍历 数据中 找 根节点 位置，左侧 为 左子树， 右侧为 右子树
 *      然后 分 左右 找，
 *      左子树 元素中， 第一个在前序列表中出现的  左子树的根节点
 *      右子树 元素中， 第一个在前序列表中出现的  右子树的根节点
 * @auther: bian.wu
 * @date: 2019/4/29 13:42
 */
public class A105从前序和中序遍历构造二叉树 {

    /***
     * @beat 98%
     *
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    int index = 0;

    /***
     * 入口
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length == 0) {
            return null;
        }
        return build(preorder, inorder, 0, inorder.length - 1);
    }

    //在中序列表中 查找 data 元素的位置,
    public int serach(int[] inorder, int str, int end, int data) {
        //inorder 列表中 从后往前找
        for (int i = end; i >= str; i--) {
            if (inorder[i] == data) {
                return i;
            }
        }
        return -1;
    }
    // left, right 都是 inorder中的 位置。
    private TreeNode build(int[] preorder, int[] inorder, int left, int right) {
        if (left > right || index >= preorder.length) {
            return null;
        }
        //j 表示根节点的 在inorder 中的索引
        int j = serach(inorder, left, right, preorder[index]);
        TreeNode node = new TreeNode(preorder[index]);
        //index 往下走 ，
        index++;
        node.left = build(preorder, inorder, left, j - 1);

        node.right = build(preorder, inorder, j + 1, right);
        return node;
    }

    public static void main(String...args){

        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        A105从前序和中序遍历构造二叉树 a = new A105从前序和中序遍历构造二叉树();
        TreeNode root = a.buildTree(pre,in);




    }
}
