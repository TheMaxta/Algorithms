package com.company.Stacks;

import java.util.Arrays;

public class TheStack {

    private String[] stackArray;

    //This will help us monitor the size
    public int stackSize;

    //This will help us monitor the last in first out
    //-1 let's us know it is empty
    //this variable is used as an index to an array
    private int topOfStack = -1;

    //constructor
    TheStack(int size){

        stackSize = size;

        stackArray = new String[size];

        Arrays.fill(stackArray, "-1");

    }

    //place an item inside the stack
    public void push(String input){
        //ensure there is room in array
        if (topOfStack+1 < stackSize){

            topOfStack++; //we are adding a new item, so there will be a new index for the top

            stackArray[topOfStack] = input; //add our new input to our new index

        } else {System.out.println("Sorry But the Stack is Full");}

        System.out.println("Push " + input + " Was Added to the Stack");
    }

    //remove the item inside the top of stack
    public String pop(){
        if(topOfStack >= 0){
            displayTheStack();

            System.out.println("POP" + stackArray[topOfStack]+ " Was Removed From Stack.");

            stackArray[topOfStack] = "-1";

            return stackArray[topOfStack--]; //decrement the index to the stack, reverting to previous index
        } else {
            displayTheStack();
            System.out.println("The Stack is Empty, too bad, so sad... ");
            return "-1";
        }
    }

    //method excepts a sentence, and splits sentence into words and stores words in stack
    public void pushMany(String multipleValues){

        String[] tempString = multipleValues.split(" ");  //split method returns array.

        for (String i : tempString) {
            push(i);
        }

    }

    public String peek(){
        displayTheStack();
        System.out.println("PEEK" + stackArray[topOfStack] + " Is at the Top of the Stack");
        return stackArray[topOfStack];
    }

    public void clearStack(){
        Arrays.fill(stackArray,"-1");
    }

    public void doubleStackSize(){

        int doubleSize = stackArray.length *2;
        String[] newArray = new String[doubleSize];
        //need to push all elements of old array into new array
        for (int i = 0; i < stackArray.length; i++) {
            newArray[i] = stackArray[i];
        }
        stackArray = newArray; //replace old array with new longer array
        stackSize = doubleSize;
    }
    public void doubleByPrime(){
        int doubleSize = stackSize * 2;
        int primeSize = getNextPrime(doubleSize);
        String[] newArray = new String[primeSize];
        Arrays.fill(newArray,"-1");
        for (int i = 0; i < stackArray.length; i++) {
            newArray[i] = stackArray[i];
        }
        //replace old array with new prime array
        stackArray = newArray;
        stackSize = primeSize;
    }

    public boolean isPrime(int num){
        if(num % 2 == 0)    //num is even
        return false;
        for (int i = 3; i * i <= num; i += 2){
            if (num % i == 0 )
                return false;
        }
        return true;
    }

    public int getNextPrime(int minNumToCheck){
        for (int i = minNumToCheck; true ; i++) {
            if (isPrime(i)){ return i; };
        }
    }

    public void displayTheStack(){
        for(int n = 0; n < 61; n++)System.out.print("-");

        System.out.println();

        for(int n = 0; n < stackSize; n++){

            System.out.format("| %2s "+ " ", n);

        }

        System.out.println("|");

        for(int n = 0; n < 61; n++)System.out.print("-");

        System.out.println();

        for(int n = 0; n < stackArray.length; n++){



            if(stackArray[n].equals("-1"))System.out.print("|     ");

            else System.out.print(String.format("| %2s "+ " ", stackArray[n]));

        }

        System.out.println("|");

        for(int n = 0; n < 61; n++)System.out.print("-");

        System.out.println();

    }

    public static void Main(String[] args){

        TheStack stack = new TheStack(10);

        stack.displayTheStack();


    }

}












