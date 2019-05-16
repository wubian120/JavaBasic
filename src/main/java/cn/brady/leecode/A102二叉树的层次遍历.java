package cn.brady.leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/11 14:23
 */
public class A102二叉树的层次遍历 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }


    /***
     * @beat   95%
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder_three(TreeNode root) {
        List<List<Integer>> resArray = new ArrayList<>();
        handleLevelOrder(root,resArray,0);
        return resArray;
    }

    private void handleLevelOrder(TreeNode root, List<List<Integer>> resArray,int depth) {
        if (root == null) return;
        if (depth >= resArray.size())
            resArray.add(new ArrayList<Integer>());

        resArray.get(depth).add(root.val);

        if (root.left != null)
            handleLevelOrder(root.left,resArray,depth + 1);

        if (root.right != null)
            handleLevelOrder(root.right,resArray,depth + 1);
    }




    /***
     * @beat   78%
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> orderList = new ArrayList<>();
        if (root == null) return orderList;
        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);

        while (nodeList.size() > 0) {
            List<TreeNode> childNodeList = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nodeList.size(); i++) {
                TreeNode node = nodeList.get(i);
                if (node != null) {
                    list.add(node.val);
                    if (node.left != null) {
                        childNodeList.add(node.left);
                    }
                    if (node.right != null) {
                        childNodeList.add(node.right);
                    }
                }
            }
            orderList.add(list);
            nodeList = childNodeList;
        }
        return orderList;
    }

    public List<List<Integer>> levelOrder_two(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        if (root == null) {
            return res;
        }

        que.offer(root);
        while (!que.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int count = que.size();
            while (count > 0) {
                TreeNode node = que.poll();
                list.add(node.val);
                count--;
                if (node.left != null) {
                    que.add(node.left);
                }
                if (node.right != null) {
                    que.add(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }





    public static TreeNode createTree(int[] nums) {
        List<TreeNode> nodes = new LinkedList<>();
        for (int i : nums) {
            nodes.add(new TreeNode(i));
        }
        int len = nums.length;

        for (int i = 0; i < len / 2 - 1; i++) {
            nodes.get(i).left = nodes.get(2 * i + 1);
            nodes.get(i).right = nodes.get(2 * i + 2);
        }
        int lastParentIndex = len / 2 - 1;
        TreeNode lastParent = nodes.get(lastParentIndex);
        lastParent.left = nodes.get(2 * lastParentIndex + 1);
        if (len % 2 == 1) {
            lastParent.right = nodes.get(2 * lastParentIndex + 2);
        }
        return nodes.get(0);
    }


    public static void main(String... args) {
        int[] nums = {3, 9, 20, 0, 0, 15, 7};

        TreeNode root = A102二叉树的层次遍历.createTree(nums);

        A102二叉树的层次遍历 a102 = new A102二叉树的层次遍历();

        List<List<Integer>> results = a102.levelOrder(root);

        System.out.println("end");
    }


}
