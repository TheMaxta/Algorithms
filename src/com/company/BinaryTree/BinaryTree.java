package com.company.BinaryTree;

public class BinaryTree {
    Node root;//highest node

    public void addNode(int key, String name){
        Node newNode = new Node(key, name);

        //if tree is empty
        if(root == null){
            root = newNode;
        } else {
            Node focusNode = root; //start with root

            Node parent;

            while(true){
                parent = focusNode;

                //left side of binary tree is lesser than parent
                if (key < focusNode.key){
                    focusNode = focusNode.leftChild;
                    if (focusNode == null){
                        parent.leftChild = newNode;
                        return;
                    }
                //right side of binary tree is greater than parent
                } else {
                    focusNode = focusNode.rightChild;
                    if (focusNode == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public boolean remove(int key){
        Node focusNode = root;
        Node parent = root;
        boolean isItALeftChild = true;

        while(focusNode.key != key){
            //keep searching
            parent = focusNode;
            if(key < focusNode.key){

                isItALeftChild = true;
                focusNode = focusNode.leftChild;

            } else {
                isItALeftChild = false;
                focusNode = focusNode.rightChild;
            }
            if(focusNode == null){
                return false;
            }
        }

        //if there are no children
        if (focusNode.leftChild == null && focusNode.rightChild == null){

            //if the whole tree is empty, just erase root by setting it to null
            if (focusNode == root){
                root = null;
            //if the left child is a leaf(end point) node, just set it to null
            } else if(isItALeftChild){
                parent.leftChild = null;
            //if the right child is a leaf(end point) node, just set it null
            } else {
                parent.rightChild = null;
            }

        }
        else if(focusNode.rightChild == null){

            if(focusNode == root)
                root = focusNode.leftChild;

             else if (isItALeftChild)
                 parent.leftChild = focusNode.leftChild;

             else parent.rightChild = focusNode.leftChild;


        }
        else if (focusNode.leftChild == null){
            if (focusNode == root){
                root = focusNode.rightChild;
            }
            else if (isItALeftChild){
                parent.leftChild = focusNode.rightChild;
            }
            else{
                parent.rightChild = focusNode.leftChild;
            }
        }
        else {
            Node replacement = getReplacementNode(focusNode);
            if (focusNode == root){
                root = replacement;
            }
            else if (isItALeftChild){
                parent.leftChild = replacement;

            }
            else{
                parent.rightChild = replacement;
            }

            replacement.leftChild = focusNode.leftChild;
        }

        return true;

    }

    public Node getReplacementNode(Node replacedNode){
        Node replacementParent = replacedNode;
        Node replacement = replacedNode;

        Node focusNode = replacedNode.rightChild;
        while (focusNode != null){
            replacementParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.leftChild;
        }

        if (replacement != replacedNode.rightChild){

            replacementParent.leftChild = replacement.rightChild;
            replacement.rightChild = replacedNode.rightChild;
        }
        return replacement;
    }




    public Node findNode(int key){

        Node focusNode = root;

        //while we haven't found our specific key yet, continue traversing tree.
        while(focusNode.key != key){
            //this simple conditional helps us eliminate 1/2 of the linear search each time we call it... 1/2 + 1/4  + 1/8 + 1/16 ... = 2
            if (key < focusNode.key){
                focusNode = focusNode.leftChild;

            } else
                focusNode = focusNode.rightChild;


            if (focusNode == null)
                return null;

        }
        return focusNode;
    }

    public void inOrderTraverseTree(Node focusNode){
        if (focusNode != null){

            //recursive call
            inOrderTraverseTree(focusNode.leftChild);

            System.out.println(focusNode);

            inOrderTraverseTree(focusNode.rightChild);

        }
    }

    public void preOrderTraverseTree(Node focusNode){
        if (focusNode != null){

            System.out.println(focusNode);
            //1st recursive call
            inOrderTraverseTree(focusNode.leftChild);

            //2nd recursive call
            inOrderTraverseTree(focusNode.rightChild);

        }
    }
    public void postOrderTraverseTree(Node focusNode){
        if (focusNode != null){

            //1st recursive call
            inOrderTraverseTree(focusNode.leftChild);

            //2nd recursive call
            inOrderTraverseTree(focusNode.rightChild);

            System.out.println(focusNode);

        }
    }
}
