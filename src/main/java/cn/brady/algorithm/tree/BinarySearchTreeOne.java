package cn.brady.algorithm.tree;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/2 13:42
 */
public class BinarySearchTreeOne {

    private TreeNode root;

    public void buildTree(int[] nums) {
        for (int i : nums) {
            insert(i);
        }
    }

    private void insert(int value) {

        if (root == null) {
            root = new TreeNode(value);
            return;
        }
        TreeNode tmp, node;
        tmp = node = root;
        while (node != null) {
            tmp = node;
            int val = node.value;
            if (val < value) {
                //往右走
                node = node.right;
            } else if (val > value) {
                //左走
                node = node.left;
            }
        }

        TreeNode aNode = new TreeNode(value);
        aNode.parent = tmp;
        if (tmp == null) {
            tmp = aNode;
        } else {
            if (tmp.value > value) {
                tmp.left = aNode;
            } else if (tmp.value < value) {
                tmp.right = aNode;
            } else if (tmp.value == value) {
                System.out.println("this value is already exist :" + value);
            }
        }

    }



    public static void main(String... args) {

        int[] nums = {7, 4, 9, 2, 6, 8, 10};

        BinarySearchTreeOne bsto = new BinarySearchTreeOne();
        bsto.buildTree(nums);

        System.out.println("end");

    }

}
