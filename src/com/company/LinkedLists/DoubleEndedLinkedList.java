package com.company.LinkedLists;
public class DoubleEndedLinkedList {
    Neighbor firstLink;
    Neighbor lastLink;

    public void insertInFirstPosition(String homeOwnerName, int houseNumber){

        Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);

        //if our list is empty
        if(isEmpty()){
            lastLink = theNewLink;
        } else {
            firstLink.previous = theNewLink;
            theNewLink.previous = lastLink;
        }

        theNewLink.next = firstLink;
        firstLink = theNewLink;

    }

    public void insertInLastPosition(String homeOwnerName, int houseNumber){
        Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);
        if(isEmpty()){

            firstLink = theNewLink;

        } else {
            lastLink.next = theNewLink;
        }
        lastLink = theNewLink;

    }

    public boolean isEmpty(){
        return(firstLink == null);
    }


    public boolean insertAfterKey(String homeOwnerName, int houseNumber, int key){
        Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);

        //start search at first link, or newest link
        Neighbor currentNeighbor = firstLink;

        //while we haven't found our target Node yet,
        while(currentNeighbor.houseNumber != key){
            //increment to next node
            currentNeighbor = currentNeighbor.next;

            //if we reach the end of our list without finding anything return null;
            if (currentNeighbor == null)
                return false;

        }
        //if we have reached this point in the method, it means the while loop terminated
        //the while loop will only terminate when the current Nodes target matches the key we are searching for
        if (currentNeighbor == lastLink){
            theNewLink.next = null;
            lastLink = theNewLink;

        } else {

            //here we build a new node inside our list, by adressing the earlier node to our new node, and the older node to our new node
            theNewLink.next = currentNeighbor.next;//creates connection to newer(target) node// builds new
            currentNeighbor.next.previous= theNewLink;//creates older nodes connection

        }
        theNewLink.previous = currentNeighbor;
        currentNeighbor.next = theNewLink;
        return true;
    }


    public void insertInOrder(String homeOwnerName, int houseNumber){
        Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);

        //temporary node information
        Neighbor previousNeighbor = null;
        Neighbor currentNeighbor = firstLink;

        //while we haven't reached the end
        //should sort from first link = smallest to last link = largest house num
        while(currentNeighbor != null && houseNumber > currentNeighbor.houseNumber){

            previousNeighbor = currentNeighbor;
            currentNeighbor = currentNeighbor.next;

        }

        if (previousNeighbor == null){
            firstLink = theNewLink;
        } else {
            previousNeighbor.next = theNewLink;
        }
        theNewLink.next = currentNeighbor;
    }

    public void display(){
        Neighbor theLink = firstLink;

        //cycle through links until null
        while(theLink != null){
            theLink.display();
            System.out.println("Next Link: "+ theLink.next);
            theLink = theLink.next;

            System.out.println();
        }
    }



}
