package cn.brady.algorithm.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/2 11:23
 */
public class BinaryTreeOne {

    public TreeNode root;


    public void buildTree(int[] nums) {
        root = build(nums, 0);
    }

    /***
     * 构建二叉树
     * @param nums
     * @param index
     * @return
     */
    private TreeNode build(int[] nums, int index) {
        TreeNode node = null;
        int len = nums.length;
        if (index < len) {
            node = new TreeNode(nums[index]);
            if (node.value == 0) {
                index++;
            }
            node.left = build(nums, 2 * index + 1);
            node.right = build(nums, 2 * index + 2);
        }
        return node;
    }

    public void preOrderTraverse() {
        preOrderTraverseRec(root);
    }

    /***
     * 前序遍历  递归版本
     * @param node
     */
    private void preOrderTraverseRec(TreeNode node) {
        if (node != null) {
            System.out.println(node.value);
            preOrderTraverseRec(node.left);
            preOrderTraverseRec(node.right);
        }
    }


    public static TreeNode createTree(int[] nums) {
        int len = nums.length / 2 - 1;

        List<TreeNode> nodes = new LinkedList<>();
        for (int i : nums) {
            TreeNode node = new TreeNode(i);
            nodes.add(node);
        }
        int size = nodes.size();
        for (int i = 0; i < size / 2 - 1; i++) {
            nodes.get(i).left = nodes.get(i * 2 + 1);
            nodes.get(i).right = nodes.get(i * 2 + 2);
        }
        //最后一个 父节点
        int lastParentIndex = size / 2 - 1;
        nodes.get(lastParentIndex).left = nodes.get(lastParentIndex * 2 + 1);
        // 只有偶数个数据 才有 右子
        if (size % 2 == 1) {
            nodes.get(lastParentIndex).right = nodes.get(lastParentIndex * 2 + 2);
        }
        return nodes.get(0);
    }

    /***
     * 前序遍历 非递归
     * @param node
     */
    private void preOrderTraverse(TreeNode node) {
        if (node != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(node);

            TreeNode tmpNode = node;

            while (!stack.empty() || tmpNode != null) {
                if (tmpNode != null) {

                    System.out.println(tmpNode.value);
                    stack.push(tmpNode);
                    tmpNode = tmpNode.left;
                } else {
                    tmpNode = stack.pop();
                    tmpNode = tmpNode.right;
                }

            }
        }
    }

    /***
     * 中序遍历 递归版本
     * @param node
     */
    private void inOrderTraverseRec(TreeNode node) {
        if (node != null) {
            inOrderTraverseRec(node.left);
            System.out.println(node.value);
            inOrderTraverseRec(node.right);
        }
    }

    /***
     * 后序遍历 递归版
     * @param node
     */
    private void postOrderTraverseRec(TreeNode node) {
        if (node != null) {
            postOrderTraverseRec(node.left);
            postOrderTraverseRec(node.right);
            System.out.println(node.value);
        }
    }


    public static void main(String... args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};

//        BinaryTreeOne bto = new BinaryTreeOne();

//        bto.buildTree(nums);

//        bto.preOrderTraverseRec(bto.root);
//        bto.preOrderTraverse(bto.root);

        TreeNode root = BinaryTreeOne.createTree(nums);


        System.out.println("end");


    }


}
