package cn.brady.leecode;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: leecode 530 二叉搜索树的最小绝对差
 * @auther: bian.wu
 * @date: 2018/12/10 15:55
 */
public class MinimumAbsoluteDifferenceInBST1st {

    List<Integer> valuelist = new LinkedList<>();
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void midOrderTraverse(TreeNode root){
        if(root != null){
            midOrderTraverse(root.left);
//            System.out.println("node value: "+root.val);
            valuelist.add(root.val);
            midOrderTraverse(root.right);
        }
    }

    public TreeNode buildBST(Integer[] intArrays) {
        TreeNode root = null;

        if (intArrays.length > 0) {
            int i = 0;
            int len = intArrays.length;


            TreeNode tmpNode = new TreeNode(intArrays[i]);
            i++;
            root = tmpNode;
            while (i < len) {
                if (intArrays[i] != null) {
                    int val = intArrays[i];
                    TreeNode current = new TreeNode(val);
                    if (tmpNode.val > val) {
                        tmpNode.left = current;
                        tmpNode = current;
                    } else {
                        tmpNode.right = current;
                        tmpNode = current;
                    }
                }
                i++;
            }

        }
        return root;
    }

    public int getMinDifferences(TreeNode node) {


        int val = node.val;
        int left = 0;
        int right = 0;
        if (node.left != null) {
            left = node.left.val;
        }
        if (node.right != null) {
            right = node.right.val;
        }
        int dvl = Math.abs(val - left);
        int dvr = Math.abs(val - right);
        return dvl > dvr ? dvr : dvl;
    }

    public int getMinimumDifference(TreeNode root) {

        TreeNode curNode = root;

        midOrderTraverse(root);

        int tmp = valuelist.get(0);
        int len = valuelist.size();
        int minAbs = Math.abs(tmp - valuelist.get(len-1));
        for(int i=1;i<len;i++){
            int current = valuelist.get(i);
            int abs = Math.abs(tmp-current);
            if(abs<minAbs){
                minAbs = abs;
            }
            tmp = current;
        }


        return minAbs;
    }

    public static void main(String... args) {

        Integer[] tvals = new Integer[]{1, null, 3, 2};
        Integer[] tvals1 = new Integer[]{5, 4, 7};
        Integer[] tvals2 = new Integer[]{1, null, 5, 3};
        MinimumAbsoluteDifferenceInBST1st mad = new MinimumAbsoluteDifferenceInBST1st();
        TreeNode root = mad.buildBST(tvals2);

//        mad.midOrderTraverse(root);

        int result = mad.getMinimumDifference(root);


        System.out.println("end");
    }

}
