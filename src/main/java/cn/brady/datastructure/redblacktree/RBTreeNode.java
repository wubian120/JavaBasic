package cn.brady.datastructure.redblacktree;

public class RBTreeNode<T extends Comparable<T>> {

    private T value;
    private RBTreeNode<T> leftChild;
    private RBTreeNode<T> rightChild;
    private RBTreeNode<T> parent;

    private boolean red;

    public RBTreeNode() {}

    public RBTreeNode(T value) {this.value = value;}
    public RBTreeNode(T value,boolean r){
        this.value = value;
        this.red = r;
    }

    public T getValue(){return value;}
    void setValue(T value){this.value = value;}

    RBTreeNode<T> getLeftChild(){return leftChild;}
    void setLeftChild(RBTreeNode<T> left){
        this.leftChild = left;
    }

    RBTreeNode<T> getRightChild(){ return rightChild;}
    void setRightChild(RBTreeNode<T> rightChild){
        this.rightChild = rightChild;
    }

    RBTreeNode<T> getParent(){return parent;}
    void setParent(RBTreeNode<T> parent){
        this.parent = parent;
    }

    boolean isRed(){return red;}
    boolean isBlack(){return !red;}



    void setRed(boolean red){
        this.red = red;
    }

    void makeRed(){
        this.red = true;
    }

    void makeBlack(){
        this.red = false;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
