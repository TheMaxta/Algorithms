package com.company.LinkedLists;

public class Main {

    public static void main(String[] args) {



        DoubleEndedLinkedList theList = new DoubleEndedLinkedList();


        theList.insertInOrder("Mark Evans", 10);
        theList.insertInOrder("Mr. Rogers", 100);
        theList.insertInOrder("Ed. Vanhalen", 420);
        theList.insertInOrder("F. Cryingoutloud", 20);
        theList.insertInOrder("Kaylee Kalko",5);

        theList.insertAfterKey("Max Mahikely", 25, 5);
        theList.display();

        NeighborIterator neighbors = new NeighborIterator(theList);

        neighbors.currentNeighbor.display();

        System.out.println(neighbors.hasNext());

        neighbors.next();

        neighbors.currentNeighbor.display();

        neighbors.remove();
    }


}
