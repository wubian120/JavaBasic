package cn.brady.leecode;

/**
 * @description: 99 恢复二叉搜素树
 * https://leetcode-cn.com/problems/recover-binary-search-tree/submissions/
 *
 * 二叉搜索树中的两个节点被错误地交换。
 *
 * 请在不改变其结构的情况下，恢复这棵树。
 *
 * 示例 1:
 *
 * 输入: [1,3,null,null,2]
 *
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * 输出: [3,1,null,null,2]
 *
 *    3
 *   /
 *  1
 *   \
 *    2
 * 示例 2:
 *
 * 输入: [3,1,4,null,null,2]
 *
 *   3
 *  / \
 * 1   4
 *    /
 *   2
 *
 * 输出: [2,1,4,null,null,3]
 *
 *   2
 *  / \
 * 1   4
 *    /
 *   3
 * 进阶:
 *
 * 使用 O(n) 空间复杂度的解法很容易实现。
 * 你能想出一个只使用常数空间的解决方案吗？
 * @auther: bian.wu
 * @date: 2019/3/31 17:49
 */
public class A99恢复二叉搜索树 {

     class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * @beat 100%
     * @ref https://blog.csdn.net/shelly_Chestnut/article/details/85234702
     * @思路： 中序遍历特点， 有序， 比较， 转换。
     */
    TreeNode preElement = null;
    TreeNode firstElement = null;
    TreeNode secondElement = null;

    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        preElement = new TreeNode(Integer.MIN_VALUE);
        traverse(root);
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }

    private void traverse(TreeNode root) {
        if (root == null)
            return;
        traverse(root.left);
        // 如果first节点未找到，且前一节点值大于当前节点值，说明找到第一个破坏规则的节点位置，即preElement
        if (firstElement == null && preElement.val > root.val) {
            firstElement = preElement;
        }
        // first节点已找到，且前一节点值大于当前节点值，找到第二个破坏规则的节点位置，即root
        if (firstElement != null && preElement.val > root.val) {
            secondElement = root;
        }
        // 更新上一访问节点
        preElement = root;
        traverse(root.right);
    }



    public static void main(String...args){

//     int[] nums =         {1,3,null,null,2};

        System.out.println("end");

    }



}
