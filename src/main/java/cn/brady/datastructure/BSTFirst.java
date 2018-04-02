package cn.brady.datastructure;

public class BSTFirst <T extends Comparable<T> > {


    private static class Node<T> {
        private T data;
        private Node<T> left;
        private Node<T> right;
        private Node<T> parent;

        public Node(T data){
            this(data,null,null, null);
        }
        public Node(T data, Node<T> left, Node<T> right, Node<T> parent){
            this.data = data;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        public T getData(){ return data;}
        public Node<T> getParent() {return parent;}
        public Node<T> getLeft() {return left;}
        public Node<T> getRight() {return right;}

    }

    public BSTFirst(Node<T> root){
        this.root = root;
    }

    public BSTFirst(){
        root = null;
    }

    private Node<T> root;


    public Node<T> search(T data){
        Node<T> node = root;
        while (node != null){
            int sign = node.getData().compareTo(data);
            if(sign > 0){
                node = node.getLeft();
            }else if(sign < 0){
                node = node.getRight();
            }else {
                return node;
            }
        }
        return null;
    }


    public void insert(T data){

        int sign = 0;
        //查找，看该数据是否已存在
        Node<T> node = search(data);
        if(node == null){
            node = new Node<T>(data);
            if(root == null){
                root = node;
            }else {
                Node<T> parent = root;
                Node<T> signNode = root;
                while(signNode != null){

                    sign = signNode.getData().compareTo(data);
                    if(sign > 0){
                        parent = signNode;
                        signNode = signNode.getLeft();
                    }else if(sign < 0){
                        parent = signNode;
                        signNode = signNode.getRight();
                    }
                }

                if(sign > 0){
                    parent.left = node;
                }else if(sign < 0){
                    parent.right = node;
                }
                node.parent = parent;
            }

        }else {
            System.out.println("the node is already in");
        }


    }

    private Node<T> findParentNode(Node<T> node){

        if(node == null){
            return null;
        }
        Node<T> findNode = search(node.getData());
        if(findNode != null){
            return findNode.getParent();
        }

        Node<T> parent = root;
        Node<T> child = root;
        while (child != null){

            int sign = child.getData().compareTo(node.getData());
            if(sign > 0){
                child = child.getLeft();
            }else if(sign < 0){
                parent = child;
                child = child.getRight();
            }
        }
        return parent;
    }

    private void insert(Node<T> node){

        Node<T> parent = findParentNode(node);
        node.parent = parent;

        int sign = parent.getData().compareTo(node.getData());
        if(sign > 0){
            parent.left = node;
        }else if(sign < 0){
            parent.right = node;
        }

    }

    private boolean isLeftChild(Node<T> node){

        if(node.parent != null){
            if(node.parent.left == node){
                return true;
            }
        }
        return false;
    }






    private Node<T> minNode(Node<T> root){

        if(root == null){
            return null;
        }
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    private Node<T> maxNode(Node<T> root){
        if(root == null){
            return null;
        }
        while (root.right != null){
            root = root.right;
        }
        return root;
    }

    //前驱 找到 node 的前驱结点，即比 node data小的最大值。
    private Node<T> predecessor(Node<T> node){
        Node preNode = null;
        //如果左子不为空， 则左子树 最大的即为前驱。
        if(node.getLeft() != null){
            return maxNode(node.left);
        }

        preNode = node.getParent();
        //左子树为空，则找其父，
        //如果为右结点，则其父为 前驱，
        //如果为左结点，则作为左子结点向上回溯 找到 最低 父结点，作为该父的右结点
        //则该 父即为 前驱
        while((preNode != null) && (preNode.getLeft() == node)){
            node = preNode;
            preNode = preNode.getParent();
        }
        return preNode;

    }

    //后继 找到node 后继结点，即比node data大的最小结点
    private Node<T> successor(Node<T> node){
        Node<T> sucNode;
        if(node.getRight() != null){
            return minNode(node.getRight());
        }

        sucNode = node.getParent();
        while((sucNode != null) && (sucNode.getRight() == node)){
            node = sucNode;
            sucNode = sucNode.getParent();
        }
        return sucNode;
    }

    // brady's version
    public void deleteVBrady(Node<T> node){
        if(node == null){
            System.out.println("deleting Node is null...");
            return;
        }

        Node<T> parent = node.getParent();
        if(root == null || root.getData() == node.getData()){
            root = null;
            return;
        }

        if(parent != null){

            if(node.getRight() == null && node.getLeft() == null){

                if(parent.getLeft() == node){
                    parent.left = null;
                }else {
                    parent.right = null;
                }
            }

            if(node.getLeft() == null || node.getRight() == null){

                if(node.getLeft() != null){
                    if(node == parent.getRight()){
                        parent.right = node.left;
                    }else {
                        parent.left = node.right;
                    }

                }else if(node.getRight() != null){

                }

            }


        }




        if(node.getLeft() != null && node.getRight() != null){

        }


    }


    //http://blog.csdn.net/u011240877/article/details/53242179
    //version
    public void delete(Node<T> node){

        if(root == null || root.data == node.data){
            root = null;
            return;
        }

        Node<T> parent = findParentNode(node);
        //父结点 为 null， 空树
        if(parent == null){
            return;
        }

        if(node.getRight() == null && node.getLeft() == null){

            if(parent.right == node && parent.right.data == node.data){
                parent.right = null;
            }else if(parent.left == node && parent.left.data == node.data){
                parent.left = null;
            }

        }else if(node.getLeft() != null && node.getRight() == null){
            //.删除结点的 左子树 不为空，把左子

            if(parent.left == node && parent.left.data == node.data){
                parent.left = node.left;
            }
            if(parent.right == node && parent.right.data == node.data){
                parent.right = node.left;
            }
            node = null;
        }else if(node.getRight() != null && node.getLeft() == null){
            //删除结点的 右子树 不为空
            if(parent.right == node && parent.right.data == node.data){
                parent.right = node.right;
            }
            if(parent.left == node && parent.left.data == node.data){
                parent.left = node.right;
            }
            node = null;
        }else {
            //双子结点都在
            Node<T> nextNode = null;
            if(node.right != null){
                nextNode = minNode(node.right);
            }

            if(nextNode != null){

                if(isLeftChild(node) && node.data == parent.left.data){
                   parent.left = nextNode;
                }else if(parent.right == node && parent.right.data == node.data){
                    parent.right = nextNode;
                }
            }
            node = null;
        }

    }




    public static void main(String[] args){

        BSTFirst<Integer> bstTest = new BSTFirst<>();
        bstTest.insert(8);
        bstTest.insert(3);
        bstTest.insert(1);
        bstTest.insert(6);
        bstTest.insert(4);
        bstTest.insert(7);
        bstTest.insert(10);
        bstTest.insert(13);
        bstTest.insert(14);

        System.out.println("....");








    }


}
