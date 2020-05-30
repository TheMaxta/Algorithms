package com.company.BinaryTree;
public class Main {
    public static void main(String[] args) {

        BinaryTree theTree = new BinaryTree();

        theTree.addNode(50,"Boss");
        theTree.addNode(25,"Vice Pres");
        theTree.addNode(15,"Office Manager");
        theTree.addNode(30,"Secretary");
        theTree.addNode(75,"Sales Manager");
        theTree.addNode(85,"Salesman 1");

       // theTree.inOrderTraverseTree(theTree.root);

        //theTree.preOrderTraverseTree(theTree.root);


        theTree.postOrderTraverseTree(theTree.root);






    }
}
