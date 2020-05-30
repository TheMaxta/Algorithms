package com.company.Heap;

public class Heap2 {

    private Data3[] theHeap;

    private int itemsInArray = 0;

    private int maxSize;

    public Heap2(int maxSize){

        this.maxSize = maxSize;


        theHeap = new Data3[maxSize];



    }

    public void incrementTheArray(){
        itemsInArray++;
    }

    public Data3 pop(){
        if ((itemsInArray != 0)){
            Data3 root = theHeap[0];
            theHeap[0] = theHeap[--itemsInArray];
            //move everything greater root in bottom upwards.
            heapTheArray(0);

            return root;
        }
        return null;
    }


    //set index for new root, and systematically traverse array determining which child values should transplant root/index for the heap to be in proper order
    public void heapTheArray(int index){
        int largestChild;

        Data3 root = theHeap[index];

        //i think we divide by two to negate bottom row.
        while(index < itemsInArray / 2){

            int leftChild = 2 * index + 1;

            int rightChild = leftChild + 1;

            if (rightChild < itemsInArray && theHeap[leftChild].key < theHeap[rightChild].key){
                largestChild = rightChild;

            } else {
                largestChild = leftChild;
            }

            if (root.key >= theHeap[largestChild].key)
                break;

            theHeap[index] = theHeap[largestChild];

            index = largestChild;

        }
        theHeap[index] = root;

    }
}


class Data3 {

    public int key;

    public Data3(int key){
        this.key = key;
    }

    public String toString(){
        return Integer.toString(key);
    }
}
