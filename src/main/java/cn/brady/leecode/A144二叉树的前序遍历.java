package cn.brady.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/12 11:23
 */
public class A144二叉树的前序遍历 {
    List<Integer> valueList = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeTools.TreeNode root) {

        if(root == null)return valueList;

        valueList.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);


        return valueList;
    }
}
