package com.company.Hash;

import java.util.ArrayList;
import java.util.Arrays;

//the purpose is to index our array of People, with key's associated to them by name
//in constant or linear time
public class HashTable {


    //theArray is the primary hash Array
    String[] theArray;
    int arraySize;
    int itemsInArray = 0;


    public HashTable(int size){
        arraySize = size;
        theArray = new String[size];
        Arrays.fill(theArray, "-1");
    }

    public String findKey(String key){
        // we need to run the same calculation (key % 29 to get the original val)
        int arrayIndexHash = Integer.parseInt(key)%arraySize;  //convert to int and get modulo of 29, the same calculatio from setting the index
        //important to note, we also used linear probing to place our vals, so we can use it again here. This will effect computational time, as linear probing is O(n)
        while (theArray[arrayIndexHash] != "-1"){
            if (theArray[arrayIndexHash] == key){
                System.out.println(key+ " was found! at index " + arrayIndexHash);
                return theArray[arrayIndexHash];
            }

            ++arrayIndexHash;
            arrayIndexHash %= arraySize;//reset to 0 .... 30%30 = 0, 1%30 = 1, 5 % 30 = 5,

        }
        return null;//key not found
    }
    public String findKeyDblHashed(String key){
        // we need to run the same calculation (key % 29 to get the original val)
        int arrayIndexHash = Integer.parseInt(key)%arraySize;  //convert to int and get modulo of 29, the same calculatio from setting the index
        //important to note, we also used linear probing to place our vals, so we can use it again here. This will effect computational time, as linear probing is O(n)

        int stepDistance = 5 - Integer.parseInt(key) % 5; //step 1-7


        while (theArray[arrayIndexHash] != "-1"){
            if (theArray[arrayIndexHash] == key){
                System.out.println(key+ " was found! at index " + arrayIndexHash);
                return theArray[arrayIndexHash];
            }

            arrayIndexHash += stepDistance;
            arrayIndexHash %= arraySize;//reset to 0 .... 30%30 = 0, 1%30 = 1, 5 % 30 = 5,

        }
        return null;//key not found
    }


    public void hashFunction1(String[] stringsForArray, String[] theArray){


        //we are not looping through an entire array, instead we are only indexing into the specific vals we need in our
        //stack
        for (int n = 0; n < stringsForArray.length; n++) {

            String newElementVal = stringsForArray[n];

            //the simple parseInt just takes it from a string to an integer, this is how we find our association between index and key
            theArray[Integer.parseInt(newElementVal)] = newElementVal;

        }


    }
    public void hashFunction2(String[] stringsForArray, String[] theArray){

        for (int n = 0; n < stringsForArray.length; n++) {
            String newElementVal = stringsForArray[n];

            int arrayIndex = Integer.parseInt(newElementVal) % arraySize;


            System.out.println("Modulus Index = "+ arrayIndex + " for value " + newElementVal);

            while(theArray[arrayIndex] != "-1"){

                //collision has occured!
                ++arrayIndex;

                System.out.println("Collision Try " + arrayIndex + " Instead");

                arrayIndex %= arraySize;//resets index to beginning of array
            }

            theArray[arrayIndex] = newElementVal;

        }


    }

    public void doubleHashFunction(String[] stringsForArray, String[] theArray){

        for (int n = 0; n < stringsForArray.length; n++) {
            String newElementVal = stringsForArray[n];

            int arrayIndex = Integer.parseInt(newElementVal) % arraySize;

            int stepDistance = 5 - Integer.parseInt(newElementVal) % 5; //step 1-7

            System.out.println("Modulus Index = "+ arrayIndex + " for value " + newElementVal);

            while(theArray[arrayIndex] != "-1"){

                //collision has occured!
                //instead of just linear probing by 1, we are stepping by a larger value 7-elementval%7
                arrayIndex += stepDistance;

                System.out.println("Collision Try " + arrayIndex + " Instead");

                arrayIndex %= arraySize;//resets index to beginning of array
            }

            theArray[arrayIndex] = newElementVal;

        }


    }



    boolean isPrime(int n){
        if (n % 2 == 0){return false;}
        for (int i = 3; i * i <= n; i+=2) {
            if (n % i == 0){
                return false;
            }
        }
        //the for loop will terminate if it has not found a multiple, and it has surpassed all of the possible multiples, and return true
        return true;
    }


    int getNextPrime(int minNumToCheck){
        for (int i = minNumToCheck; true; i++) {
            if (isPrime(i)){return i;}
        }
    }

    public void increaseArraySize(int minSize){
        //get new array
        int newArraySize = getNextPrime(minSize);   //get next prime number to reduce collision cases
        moveOldArray(newArraySize);                 //merges old data into new array with a larger prime number
    }

    public void moveOldArray(int newArraySize){
        String[] cleanArray = removeEmptySpaces(theArray); //clear out empty spaces of old array
        theArray = new String[newArraySize];    //create new array with new prime number we got earlier
        arraySize = newArraySize;               //reset arraySize variable
        fillArrayWithNeg1();            //fill empty spaces with -1;
        hashFunction2(cleanArray, theArray);
    }


    public String[] removeEmptySpaces(String[] arrayToClean){
        //initialize list
        ArrayList<String> list = new ArrayList<String>();

        for (String i: arrayToClean) {
            if (!(i.equals("-1")) && !(i.equals(""))){
                list.add(i);
            }
        }
        //probe older array, if we don't run into a -1 or an empty space, add this to the list
        return list.toArray(new String[list.size()]);
        //transform arraylist to String[] and return array
    }

    public void fillArrayWithNeg1(){
        Arrays.fill(theArray, "-1");
    }

    public void displayStack(){
        for (int i = 0; i < theArray.length; i++) {
            System.out.println(theArray[i]);
        }
    }

}