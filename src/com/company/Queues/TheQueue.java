package com.company.Queues;
import java.util.Arrays;

public class TheQueue {

    private String[] queueArray;    //the daddy item.
    private int queueSize;
    private int front, rear, numberOfItems = 0; //all [index] variables initially set to zero.

    //constructor
    TheQueue(int size){
        queueSize = size;

        queueArray = new String[size];

        Arrays.fill(queueArray, "-1");
        
    }

    public void insert(String input){

        //if does not exceed available size
        if (numberOfItems + 1 <= queueSize){
            queueArray[rear] = input;
            rear++;
            numberOfItems++;

            System.out.println("INSERT "+ input + " Was Added to Queue\n");

        } else {
            System.out.println("Queue's full yo!! ");
        }
    }

    public void remove(){
        if(numberOfItems > 0){

            System.out.println("REMOVE "+ queueArray[front] + " Was Removed ");

            queueArray[front] = "-1";

            front++;

            numberOfItems--;
        } else {
            System.out.println("Queue's full yo!! ");
        }
    }

    public void peek(){
        System.out.println("The first Element is " + queueArray);
    }

    //add numbers from high to low as inputted....
    public void priorityInsert(String input){

        int i;

        if (numberOfItems == 0){
            insert(input);
        } else {
            for (i = numberOfItems-1; i >= 0; i--) {
                //if passed input is greater than current iteration in array,
                if (Integer.parseInt(input) > Integer.parseInt(queueArray[i])){
                    queueArray[i+1] = queueArray[i];
                } else break;
            }
            queueArray[i+1] = input;
            rear++;
            numberOfItems++;
        }
    }


    public void displayTheStack(){
        for(int n = 0; n < 61; n++)System.out.print("-");

        System.out.println();

        for(int n = 0; n < queueSize; n++){

            System.out.format("| %2s "+ " ", n);

        }

        System.out.println("|");

        for(int n = 0; n < 61; n++)System.out.print("-");

        System.out.println();

        for(int n = 0; n < queueArray.length; n++){



            if(queueArray[n].equals("-1"))System.out.print("|     ");

            else System.out.print(String.format("| %2s "+ " ", queueArray[n]));

        }

        System.out.println("|");

        for(int n = 0; n < 61; n++)System.out.print("-");

        System.out.println();

    }



}












