package cn.brady.leecode;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/3 19:52
 */
public class A100相同的树 {

    TreeNode root;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public void buildTree(int[] nums){
        root =  build(nums,0);
    }

    /***
     * 构建二叉树
     * @param nums
     * @param index
     * @return
     */
    private TreeNode build(int[] nums, int index){
        TreeNode node = null;
        int len = nums.length;
        if(index<len){
            node = new TreeNode(nums[index]);
            if(node.val == 0){
                index++;
            }
            node.left = build(nums,2*index+1);
            node.right = build(nums,2*index+2);
        }
        return node;
    }

    /**
     * @beat 100%
     * @param p
     * @param q
     * @return
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p!=null && q!=null){
            if(p.val == q.val){
                return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
            }else{
                return false;
            }

        }else if(p==null && q!= null ){
            return false;
        }else if(p!=null && q == null){
            return false;
        }else{
            return true;
        }
    }

    public static void main(String...args){
        int[] num = {1,2,3};

        A100相同的树 a100 = new A100相同的树();
        a100.buildTree(num);

        A100相同的树 a101 = new A100相同的树();
        a101.buildTree(num);

        boolean result = A100相同的树.isSameTree(a100.root,a101.root);

        System.out.println(result);


    }
}
