package cn.brady.leecode;

import java.util.*;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/12 10:21
 */
public class A145_self {

    // 非递归实现
    public static List<Integer> postorderTraversal(TreeTools.TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root==null) return Collections.EMPTY_LIST;

        Stack<TreeTools.TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);

        while (!nodeStack.empty()){
            TreeTools.TreeNode current = nodeStack.pop();
            res.add(0,current.val);
            if(current.left!=null){
                nodeStack.push(current.left);
            }
            if(current.right!=null){
                nodeStack.push(current.right);
            }
        }
        return res;
    }

    public static List<Integer> postorderTraversal_one(TreeTools.TreeNode root){
        List<Integer> valuelist = new ArrayList<>();
        if(root==null) return valuelist;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        valuelist.add(root.val);
        return valuelist;
    }



}
