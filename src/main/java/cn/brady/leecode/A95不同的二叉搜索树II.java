package cn.brady.leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 95 不同的二叉搜索树II
 * <p>
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/submissions/
 * <p>
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * <p>
 * 示例:
 * 输入: 3
 * 输出:
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * @auther: bian.wu
 * @date: 2019/4/1 11:08
 */
public class A95不同的二叉搜索树II {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * @ref https://blog.csdn.net/weixin_38823568/article/details/82872770
     * @beat 67.78%
     */
    public static List<TreeNode> generateTrees(int n) {
        if (0 == n) {
            return new ArrayList<>();
        }
        return generateTrees(0, n);
    }

    private static List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> res = new LinkedList<>();
        if (start == end) {
            res.add(null);
            return res;
        }

        //只有一个
        if (start + 1 == end) {
            res.add(new TreeNode(start + 1));
        } else if (start + 2 == end) {
            //二个节点
            TreeNode start1 = new TreeNode(start + 1);
            TreeNode end1 = new TreeNode(start + 2);
            start1.right = end1;
            res.add(start1);

            TreeNode start2 = new TreeNode(start + 1);
            TreeNode end2 = new TreeNode(start + 2);
            end2.left = start2;
            res.add(end2);
        } else {
            for (int i = start; i < end; i++) {

                List<TreeNode> left = generateTrees(start, i);

                List<TreeNode> right = generateTrees(i + 1, end);

                for (int m = 0; m < left.size(); m++) {
                    for (int n = 0; n < right.size(); n++) {
                        TreeNode root = new TreeNode(i + 1);
                        root.left = left.get(m);
                        root.right = right.get(n);
                        res.add(root);
                    }
                }
            }
        }

        return res;
    }

    public static void main(String... args) {

        List<TreeNode> tree = A95不同的二叉搜索树II.generateTrees(3);


        for (TreeNode node : tree) {
            System.out.println(node.val);
        }

    }

    public static List<TreeNode> generateTrees_self_one(int start, int end) {

        List<TreeNode> trees = new LinkedList<>();
        if (start == end) {
            trees.add(null);
            return trees;
        }

        if (start + 1 == end) {
            TreeNode one = new TreeNode(start + 1);
            trees.add(one);
        } else if (start + 2 == end) {
            TreeNode fstOne = new TreeNode(start + 1);
            TreeNode fstOnePlus = new TreeNode(start + 2);
            fstOne.right = fstOnePlus;
            trees.add(fstOne);

            TreeNode sndOne = new TreeNode(start + 1);
            TreeNode sndOnePlus = new TreeNode(start + 2);
            sndOnePlus.left = sndOne;
            trees.add(sndOnePlus);

        } else {

            for (int i = start; i < end; i++) {
                List<TreeNode> leftSubTree = generateTrees_self_one(start, i);
                List<TreeNode> rightSubTree = generateTrees_self_one(i + 1, end);

                int leftSize = leftSubTree.size();
                int rightSize = rightSubTree.size();

                for (int l = 0; l < leftSize; l++) {
                    for (int r = 0; r < rightSize; r++) {
                        TreeNode root = new TreeNode(i + 1);
                        root.left = leftSubTree.get(l);
                        root.right = rightSubTree.get(r);
                        trees.add(root);
                    }
                }
            }
        }
        return trees;

    }

}
