package cn.brady.datastructure.tree;

public class BSTSecond {

    private class Node<T extends Comparable<T>>{
        private T data;
        private Node<T> leftChild;
        private Node<T> rightChild;


        public Node(T data){
            this(data, null, null);
        }

        public Node(T data, Node left, Node right){
            this.data = data;
            this.leftChild = left;
            this.rightChild = right;
        }

        public T getData() {
            return data;
        }

        public Node<T> getLeftChild() {
            return leftChild;
        }

        public Node<T> getRightChild() {
            return rightChild;
        }

        public void setData(T data) {
            this.data = data;
        }

        public void setLeftChild(Node<T> leftChild) {
            this.leftChild = leftChild;
        }

        public void setRightChild(Node<T> rightChild) {
            this.rightChild = rightChild;
        }


    }

}
