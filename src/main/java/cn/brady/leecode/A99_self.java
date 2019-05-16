package cn.brady.leecode;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/10 23:51
 */
public class A99_self {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }


    public void recoverTree(TreeNode root) {
        if (root == null) return;
        preELement = new TreeNode(Integer.MIN_VALUE);
        traverse(root);
        swap(fstEle, sndEle);
    }
    TreeNode preELement = null, fstEle = null, sndEle = null;
    //中序遍历
    private void traverse(TreeNode current) {
        if (current == null) return;
        traverse(current.left);
        //如果第一个节点为空， 发现前一个节点>当前节点 ,记录
        if (fstEle == null && preELement.val > current.val) {
            fstEle = preELement;
        }
        //如果第一个已经找到 又发现了一个
        if (fstEle != null && preELement.val > current.val) {
            sndEle = current;
        }
        preELement = current;
        traverse(current.right);
    }

    private void swap(TreeNode t1, TreeNode t2) {
        int temp = t1.val;
        t1.val = t2.val;
        t2.val = temp;
    }

    public static void main(String...args){

    }


}
