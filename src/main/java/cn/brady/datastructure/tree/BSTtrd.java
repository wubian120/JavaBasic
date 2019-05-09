/**
 * Copyright (C), 2015-2018, ele me
 * FileName: BSTtrd
 * Author:   bian.wu
 * Date:     2018/7/7 18:06
 * Description: ${DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 */
package cn.brady.datastructure.tree;

import java.awt.*;

/**
 * Binary Search Tree
 * https://www.cnblogs.com/Michaelwjw/p/6384428.html
 *
 * @author bian.wu
 * @create 2018/7/7
 * @since 1.0.0
 */
public class BSTtrd {


    class Node {
        int key;
        int value;
        Node left;
        Node right;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public void displayNode() {

        }
    }

    private Node root;

    public Node find(int key) {
        Node current = root;

        while (current != null && current.key != key) {
            if (key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return current;
    }

    public void insert(int key, int value) {

        if (root == null) {
            root = new Node(key, value);
            return;
        }
        Node current = root;
        Node parent = root;
        boolean isleft = true;
        while (current != null) {
            parent = current;
            if (key < current.key) {
                current = current.left;
                isleft = true;
            } else {
                current = current.right;
                isleft = false;
            }
        }

        Node newNode = new Node(key, value);
        if (isleft) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }

    public boolean delete(int key) {

        Node current = root;
        Node parent = root;
        boolean isLeft = true;

        while (current != null && current.key != key){
            parent = current;
            if(key < current.key){
                current = current.left;
                isLeft =true;
            }else {
                current = current.right;
                isLeft = false;
            }
        }

        if(current == null){
            return false;
        }
        if(current.left == null && current.right == null){
            /**叶节点 */
            if(current == root){
                root = null;
            }else if(isLeft){
                parent.left = null;
            }else {
                parent.right = null;
            }

        }else if(current.left == null){
            /**左为空， 有右子节点*/
            if(current == root){
                root = current.right;
            }else if(isLeft){
                parent.left = current.right;
            }else {
                parent.right = current.right;
            }

        }else if(current.right == null){
            if(current == root){
                root = current.left;
            }else if(isLeft){
                parent.left = current.left;
            }else {
                parent.right = current.left;
            }
        }else {
            /**既有左也有右子节点*/
            Node directPost = getDirectPostNode(current);
            current.key = directPost.key;
            current.value = directPost.value;
        }

        return true;
    }

    /***
     * 获得 删除节点 等直接后继节点
     * @param delNode
     * @return
     */
    private Node getDirectPostNode(Node delNode) {

        Node parent = delNode;
        Node directPost = delNode;
        Node current = delNode.right;

        while (current != null) {
            parent = directPost;
            directPost = current;
            current = current.left;
        }

        if (directPost != delNode.right) {
            parent.left = directPost.right;
            directPost.right = null;
        }

        return directPost;
    }

    /**
     * 前序
     */
    public void preOrder(Node root) {
        if (root != null) {
            System.out.println("key: " + root.key + " value : " + root.value);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    /**
     * 中序
     */
    public void inOrder(Node root) {
        if(root != null){
            inOrder(root.left);
            System.out.println("key: " + root.key+" value: " +root.value);
            inOrder(root.right);
        }
    }

    /**
     * 后序
     */
    public void postOrder(Node root) {
        if(root != null){
            preOrder(root.left);
            preOrder(root.right);
            System.out.println("key: " + root.key+" value: "+root.value);
        }
    }


    public void destroy(Node tree){

    }

    /**
     *
     *
     * */
    public static void main(String... args){
        BSTtrd tree = new BSTtrd();

        tree.insert(6,6);
        tree.insert(3,3);
        tree.insert(14,14);
        tree.insert(16,16);
        tree.insert(10,10);
        tree.insert(9,9);
        tree.insert(13,13);
        tree.insert(11,11);
        tree.insert(12,12);
        tree.insert(2,2);
        tree.insert(1,1);
        tree.inOrder(tree.root);

        System.out.println(".....     .....     .....");




    }


}