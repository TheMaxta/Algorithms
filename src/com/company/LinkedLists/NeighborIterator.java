package com.company.LinkedLists;
public class NeighborIterator {

    Neighbor currentNeighbor;
    Neighbor previousNeighbor;

    DoubleEndedLinkedList theNeighbors;

    NeighborIterator(DoubleEndedLinkedList theNeighbors){

        this.theNeighbors = theNeighbors;
        currentNeighbor = theNeighbors.firstLink;
        previousNeighbor = theNeighbors.lastLink;

    }

    //let's us know if we have reached the end of the list
    public boolean hasNext(){

        if (currentNeighbor.next != null){
            return true;
        }
        return false;
    }

    //this method just moves one node backwards through the list
    public Neighbor next(){
        if (hasNext()){
            previousNeighbor = currentNeighbor;
            currentNeighbor = currentNeighbor.next;
            return currentNeighbor;
        }
        return null;
    }

    public void remove(){
        //are we at the beginning of our list?
        if (previousNeighbor == null){
            theNeighbors.firstLink = currentNeighbor.next;
        } else {
            previousNeighbor.next = currentNeighbor.next;
            //if at the end of out list...
            if (currentNeighbor.next == null){
                currentNeighbor = theNeighbors.firstLink;
                previousNeighbor = null;
            } else {
                currentNeighbor = currentNeighbor.next;
            }
        }


    }
}
