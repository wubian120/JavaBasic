package cn.brady.datastructure;


/**
 * 二叉查找树  Binary Search Tree
 * http://www.cnblogs.com/skywang12345/p/3576452.html
 * @param <T>
 */
public class BinarySearchTreeZero <T extends Comparable<T>> {

    private static class Node<T>{
        private T data;
        private Node<T> left;
        private Node<T> right;
        private Node<T> parent;

        public Node(T data){

            this(data,null, null, null);
        }

        public Node(T data,Node<T> left, Node<T> right, Node<T> parent){
            this.data = data;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

    }

    private Node<T> root;

    /**
     * 查找树中 t 是否包含 value 递归
     * @param value
     * @param t
     * @return
     */
    private boolean contains(T value, Node<T> t){

        if(null == t){
            return false;
        }
        int result = value.compareTo(t.data);

        if(result < 0){
            return contains(value,t.left);
        }else if(result > 0){
            return contains(value, t.right);
        }else {
            return true;
        }

    }
    /**
     * 前序遍历，先中，左，后右
     */
    private void preOrder(Node<T> tree){
        if(tree != null){
            System.out.println(tree.data.toString() + " ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public void preOrder(){
        preOrder(root);
    }

    /**
     * 中序遍历  先左，中，后右
     * @param t
     */
    private void inOrder(Node<T> t){
        if(t != null){
            inOrder(t.left);
            System.out.println(t.data.toString() + " ");
            inOrder(t.right);
        }
    }

    public void inOrder(){
        inOrder(root);
    }

    private void postOrder(Node<T> t){
        if(t != null){
            postOrder(t.left);
            postOrder(t.right);
            System.out.println(t.data.toString() + " ");

        }
    }

    public void postOrder(){
        postOrder(root);
    }

    private Node<T> searchNonIterative(Node<T> t, T key){
        while( t != null){

            int result = key.compareTo(t.data);

            if(result < 0){
                t = t.left;
            }else if(result > 0){
                t = t.right;
            }else {
                return t;
            }
        }

        return t;
    }


    public Node<T> search(T key){
        return searchNonIterative(root,key);
    }

    private Node<T> max(Node<T> tree){
        if(tree == null){
            return null;
        }
        while(tree.right != null){
            tree = tree.right;
        }
        return tree;
    }

    public T max(){
        Node<T> node = max(root);
        if(node != null){
            return node.data;
        }
        return null;
    }

    private Node<T> min(Node<T> tree){

        if(tree == null){
            return null;
        }
        if(tree.left != null){
            tree = tree.left;
        }
        return tree;
    }

    public T min(){
        Node<T> node = min(root);
        if(node != null){
            return node.data;
        }
        return null;
    }

    /**
     * 节点的前驱， 指 左子树中 最大的节点。
     * 即小于 该节点值，的 最大节点
     * @param node
     * @return
     */
    public Node<T> predecessor(Node<T> node){
        //如果存在左子树，则找到左子树中最大的节点
        if(node.left != null){
            return max(node);
        }
        //如果node没有左子节点，分为两种情况
        //1.node为右节点，则其前驱为其父节点
        //2.node为左节点，则寻找其最低的父节点，最低父节点即为其前驱
        Node<T> pre = node.parent;
        //父结点不为空，且 当前结点为左子结点
        while((pre!=null) && (pre.left == node)){
            node = pre;
            pre = pre.parent;
        }
        return pre;
    }

    /**
     * 后继节点， 即查找，树中 大于该节点值的最小 节点
     * @param node
     * @return
     */
    public Node<T> successor(Node<T> node){
        //如果 右结点不为空，则查找右结点下最小结点
        if(node.right != null){
            return min(node.right);
        }
        //如果有结点为空，则有以下
        Node<T> t = node.parent;
        //父结点不为空，且 当前结点为右子结点
        while((t != null) && node == t.right){
            node = t;
            t = t.parent;
        }
        return t;

    }

    /**
     * 个人实现，加深理解
     * @param tree
     * @param node
     */
    private void insertWB(BinarySearchTreeZero<T> tree, Node<T> node){

        Node<T> signNode = null;
        Node<T> tempNode = tree.root;

        while(tempNode != null){
            signNode = tempNode;
            int r = node.data.compareTo(tree.root.data);

            if(r > 0){
                tempNode = tempNode.right;
            }else {
                tempNode = tempNode.left;
            }
        }

        node.parent = signNode;

        // tree.root == null; 空树
        if(signNode == null){
            tree.root = node;
            //不为空，则判断是放左还是右子 节点
        }else {
            int r = node.data.compareTo(signNode.data);
            if(r > 0){
                signNode.right = node;
            }else {
                signNode.left = node;
            }
        }
    }


    /**
     * 这个插入算法 来自以下连接，为理解，感觉写的不对
     * http://www.cnblogs.com/skywang12345/p/3576452.html
     * @param tree
     * @param n
     */
    private void insert(BinarySearchTreeZero<T> tree, Node<T> n){

        int result;
        Node<T> node = null;
        Node<T> root = tree.root;

        while(root != null){
            node = root;
            result = n.data.compareTo(root.data);
            if(result > 0){
                root = root.right;
            }else {
                root = root.left;
            }
        }

        n.parent = node;
        /**
         * why？
         */
        if(node == null){
            tree.root = n;
        }else{
            result = n.data.compareTo(node.data);
            if(result<0){
                node.left = n;
            }else {
                node.right = n;
            }
        }
    }


    private void removeWb(Node<T> node){
        Node<T> temp = null;

        //该结点为 叶结点
        if(node.left == null && node.right == null){
            node = null;
        }else if(node.left == null && node.right != null){
            //左为空，右不为空
            temp = node;
            node = node.right;
            free(temp);
        }else if(node.right == null && node.left != null){
            temp = node;
            node = node.left;
            free(temp);
        }else {
            //当前结点 的 左右 都不为空
            //找到前驱和后继结点 target
            //
        }

    }

    private void free(Node<T> node){

        node.data = null;
        node.right = null;
        node.left = null;
        node.parent = null;
        node = null;
    }

    /**
     * 未理解整个思路
     * 思考： 删除一个结点，需要找到该结点的位置，并重新规划整个子树
     * 判断该结点是否有 左右 子结点
     *
     * @param tree
     * @param 删除 node
     * @return
     */
    private Node<T> remove(BinarySearchTreeZero<T> tree, Node<T> node){

        Node<T> temp = null;
        Node<T> sign = null;

        //有一侧子结点 为空
        if((node.right == null) || (node.left == null)){
            sign = node;
        }else {

            sign = successor(node);
        }

        if(node.left != null){
            temp = sign.left;
        }else {
            temp = sign.right;
        }

        if(temp != null){
            temp.parent = sign.parent;
        }


        if(sign.parent == null){
            tree.root = temp;
        }else if(sign == sign.parent.left){
            sign.parent.left = temp;
        }else {
            sign.parent.right = temp;
        }

        if(sign != node){
            node.data = sign.data;
        }

        return sign;
    }


    public void insert(T key){
        Node<T> newNode = new Node<T>(key);
        if(newNode != null){
            insert(this,newNode);
        }
    }


    public BinarySearchTreeZero(){ root = null; }

    public void makeEmpty(){ root = null; }

    public boolean isEmpty(){ return root == null; }


    private static final int arr[] = {1,5,4,3,2,6};

    public static void main(String[] args){

        BinarySearchTreeZero treeZero = new BinarySearchTreeZero();

        for(int i : arr){
            treeZero.insert(i);
        }

        System.out.println("PreOrder....");

        treeZero.preOrder();




    }


}
