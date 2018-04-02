package cn.brady.datastructure.redblacktree;

import java.util.concurrent.atomic.AtomicLong;

public class RBTree <T extends Comparable<T> >{


    private final RBTreeNode<T> root;
    private AtomicLong size = new AtomicLong(0);

    // in overwrite mode  can't have same values
    private volatile boolean overwriteMode = true;

    public RBTree(){
        root = new RBTreeNode<>();
    }

    public RBTree(boolean isOverwrite){
        this();
        this.overwriteMode = isOverwrite;
    }

    public boolean isOverwriteMode(){
        return overwriteMode;
    }

    public void setOverwriteMode(boolean isOverWrite){
        this.overwriteMode = isOverWrite;
    }

    public long getSize(){
        return size.get();
    }

    private RBTreeNode<T> getRoot(){return root;}




    private T addNode(RBTreeNode<T> node){
        node.setLeftChild(null);
        node.setRightChild(null);
        node.setRed(true);
        setParent(node,null);


        return   node.getValue();

    }


    private void setParent(RBTreeNode<T> node, RBTreeNode<T> parent){
        if(node != null){
            if(parent != null){
                node.setParent(parent);
            }
            if(node == null){
                node.setParent(null);
            }
        }
    }

    private RBTreeNode<T> getSibling(RBTreeNode<T> node, RBTreeNode<T> parent){
        parent = node == null ? parent : node.getParent();

        if(node == null){
            return parent.getLeftChild() == null ? parent.getRightChild() : parent.getLeftChild();
        }

        if(node == parent.getLeftChild()){
            return parent.getRightChild();
        }else {
            return parent.getLeftChild();
        }
    }

    private boolean isBlack(RBTreeNode<T> node){
        return node == null || node.isBlack();
    }

    // 左旋， 输入结点的 右子结点 升为 父，输入结点降为 右子结点的 左；
    // 输入结点的 右子变为 右子结点的 左子
    private void rotateLeft(RBTreeNode<T> node){

        if(node != null){

            RBTreeNode<T> right = node.getRightChild();
            RBTreeNode<T> parent = node.getParent();
            if(right == null){
                throw new java.lang.IllegalStateException("right child node is null");
            }
            //右子的 左子 变为  输入结点的 右子
            node.setRightChild(right.getLeftChild());
            if(right.getLeftChild() != null){
                setParent(right.getLeftChild(),node);
            }

            //右子 结点  设为 输入结点的 父
            //输入结点 变为 右子的 左子结点
            right.setLeftChild(node);
            setParent(node,right);

            if(parent == null){
                root.setLeftChild(node);
                setParent(right,null);
            }else {
                if(parent.getLeftChild() == node){
                    parent.setLeftChild(right);
                }else {
                    parent.setRightChild(right);
                }
                setParent(right, parent);
            }
        }

    }

    private void rotateRight(RBTreeNode<T> node){

        if(node != null){
            RBTreeNode<T> left = node.getLeftChild();
            RBTreeNode<T> parent = node.getParent();

            if(left == null){
                throw new java.lang.IllegalStateException("left child node is null");
            }
            node.setLeftChild(left.getRightChild());
            if(left.getRightChild() != null){
                setParent(left.getRightChild(),node);
            }
            left.setRightChild(node);
            setParent(node,left);
            if(parent == null){
                root.setLeftChild(left);
                setParent(left,null);
            }else {

                if(parent.getRightChild() == node){
                    parent.setRightChild(left);
                }else {
                    parent.setLeftChild(left);
                }
                setParent(left,parent);

            }

        }
    }

}
