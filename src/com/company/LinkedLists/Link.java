package com.company.LinkedLists;

public class Link {
    public String bookName;
    public int millionsSold;

    public Link next; //stores reference for the previous link in list.

    public Link(String bookName, int millionsSold){
        this.bookName = bookName;
        this.millionsSold = millionsSold;
    }

    public void display(){
        System.out.println(bookName + ": " + millionsSold + ",000,000");
    }

    public String toString(){
        return bookName;
    }

}

class LinkList {
    public Link firstLink;

    LinkList(){
        firstLink = null;
    }

    public boolean isEmpty(){
        return(firstLink == null); //notice  "==" is a conditional. return true only if first link == null
    }

    public void insertFirstLink(String bookName, int millionsSold){

        Link newLink = new Link(bookName, millionsSold);

        newLink.next= firstLink;

        firstLink = newLink;
    }

    //removed the most recent link in list, or first link
    public Link removeFirst(){
        Link linkReference = firstLink;

        //if first link is empty, we have nothing to do...
        if(!isEmpty()){
            firstLink = firstLink.next; //first link . next is the previous link.
        } else {
            System.out.println("Empty LinkedList");
        }
        return linkReference;

    }

    //find a book name
    public Link find(String bookName){
        Link theLink = firstLink;


        if (!isEmpty()){                          //if our list actually contains items...
            while(theLink.bookName != bookName){
                if (theLink.next == null){
                    return null;
                } else {
                    theLink = theLink.next;
                }
            }
        } else {
            System.out.println("Empty Linked Lists");
        }
        return theLink;
    }


    //remove a specific link in list...
    //cycle through links until we find our target
    //once we find our target, replace the index of the earlier reference to the reference of the latter link
    public Link removeLink(String bookName){
        Link currentLink = firstLink; //now, you need to store two links in our process, because to erase one link we need to use the--
        Link previousLink = firstLink;//--reference of the previous link

        //if this loop terminates, it means either the list is empty, and we exit the entire method with null,
        // -- or, it means we have found our reference, or bookName associated to it's link. currentLink.bookname == bookName
        while(currentLink.bookName != bookName){

            //if we have reached the end
            if(currentLink.next == null){
                return null;
            } else {

                previousLink = currentLink; //earlier link is set to next iteration

                currentLink = currentLink.next;  //current link is set to next link further back in our list
                //[],[],[c],[p],[] >>> [],[c],[p],[],[] >>> [c],[p],[],[],[]

            }

        }
        //if we get here,
        if (currentLink == firstLink){

            firstLink = firstLink.next;

        } else {
            //this one line of code completely erases the existence of the current link.
            previousLink.next = currentLink.next;
            //previous link no longer flows into current link, because we are deleting it.. Now it just adresses to the earlier link
            //[1],[c],[p],[2],[3] >>> [1],[p],[2],[3],

        }

        return currentLink; //return the link we deleted.

    }


    //Cycle through all links in list
    public void display(){
        Link theLink = firstLink;   //start on most recent link in list

        //keep calling link.next until we have reached null, or empty and than terminate
        while (theLink != null){

            theLink.display();

            System.out.println("Next Link: "+ theLink.next);

            theLink = theLink.next; //Setup nextLink for next iteration

            System.out.println();

        }
    }

    public static void main(String[] args){
        LinkList theLinkedList = new LinkList();

        theLinkedList.insertFirstLink("Don Quixote", 500);
        theLinkedList.insertFirstLink("Doors of Perception", 50);
        theLinkedList.insertFirstLink("Flow",200);
        theLinkedList.insertFirstLink("A mind for numbers", 100);
        theLinkedList.insertFirstLink("Biocentrism",300);
        theLinkedList.insertFirstLink("The Sports Gene",40);
        theLinkedList.insertFirstLink("Outliers",50);
        theLinkedList.insertFirstLink("Brave New World", 150);


        theLinkedList.display();





    }


}




