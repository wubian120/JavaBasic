package cn.brady.datastructure.tree;


import java.util.NoSuchElementException;

/***
 *
 *
 * https://algs4.cs.princeton.edu/32bst/BST.java.html
 *
 */


public class BinarySearchTreeZero<Key extends Comparable<Key>, Value> {

    private Node root;


    private class Node{

        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private int size;

        public Node(Key key, Value value, int size){
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    public BinarySearchTreeZero(){

    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public int size(){
        return size(root);
    }

    private int size(Node x){
        if(x == null){
            return 0;
        }else {
            return x.size;
        }
    }


    public Value get(Key key){
        return get(root, key);
    }

    private Value get(Node x, Key key){

        if(key == null) throw new IllegalArgumentException("call get() with null key");
        if(x == null) return null;

        int cmp = key.compareTo(x.key);
        if(cmp <0){
            return get(x.left, key);
        } else if(cmp > 0){
            return get(x.right, key);
        }
        else {
            return x.value;
        }
    }


    public void put(Key key, Value value){
        if(key == null){
            throw new IllegalArgumentException("calls put() with a null key");
        }
        if(value == null){
            //delete(key)
            return;
        }

    }


    private Node deleteMin(Node x){

        if(x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }


    private Node delete(Node x, Key key){
        if( x == null) return null;

        int cmp = key.compareTo(x.key);

        if(cmp < 0){
            x.left = delete(x.left,key);
        }else if(cmp > 0){
            x.right = delete(x.right,key);
        }else {

            if(x.right == null){
                return x.left;
            }
            if(x.left == null){
                return x.right;
            }

            Node t = x;
            /**右子树中 最小的 */
            x = min(t.right);


        }

        return null;
    }


    public Key min(){
        if(isEmpty())
            throw new NoSuchElementException("calls min() with empty symbol table");
        return min(root).key;
    }

    private Node min(Node x){
        if(x.left == null)
            return x;
        else
            return min(x.left);
    }

//    public Iterable<Key> keys(){
//
//    }


    private boolean check(){


        return false;

    }

    private boolean isBST(){
        return isBST(root, null, null);
    }

    private boolean isBST(Node x, Key min, Key max){
        if(x == null){
            return true;
        }

        if(min != null && x.key.compareTo(min) <= 0){
            return false;
        }

        if(max != null && x.key.compareTo(max) >= 0){
            return false;
        }

        return isBST(x.left, min, x.key) && isBST(x.right, max, x.key);
    }

    private boolean isSizeConsistent(){
        return isSizeConsistent(root);
    }

    private boolean isSizeConsistent(Node x){
        if(x == null) return true;

        if(x.size != size(x.left) + size(x.right) + 1)
            return false;

        return isSizeConsistent(x.left) && isSizeConsistent(x.right);
    }


    private boolean isRankConsistent(){

        for(int i=0;i<size();i++){
            if(i != rank(select(i))){
                return false;
            }
        }





        return false;
    }


    /***
     * return the Kth smallest key in the tree
     * @param k
     * @return
     */

    public Key select(int k){
        if(k < 0 || k > size()){
            throw new IllegalArgumentException("argument to select() is invalid: " + k);
        }
        Node x = select(root,k);
        return x.key;
    }

    private Node select(Node x, int k){
        if(x == null){
            return null;
        }

        int t = size(x.left);
        if(t > k){
            return select(x.left, k);
        }else if(t < k){
            return select(x.right, k - t - 1);
        }else {
            return x;
        }
    }


    /***
     * Return the number of keys which less than key
     * @param key
     * @return
     */
    public int rank(Key key){

        if(key == null) throw new IllegalArgumentException("argument to rank() is null");
        return rank(key,root);
    }

    private int rank(Key key, Node x){
        if(x == null) return 0;

        int cmp = key.compareTo(x.key);
        if(cmp < 0){
            return rank(key, x.left);
        }else if(cmp > 0){
            return 1 + size(x.left) + rank(key, x.right);
        }else {
            return size(x.left);
        }
    }








}
