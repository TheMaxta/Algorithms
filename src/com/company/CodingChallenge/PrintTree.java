package com.company.CodingChallenge;

public class PrintTree {

    public void printTree(int rows){

        int spaces = 0;

        int iteration = 1;

        while(iteration < rows){

            int indent = (int) Math.abs(((Math.pow(-2, iteration)) * (-16 + Math.pow(2,iteration))));

            int indexToPrint = (int) (.5 * (-1 + (Math.pow(2,iteration))));

            int itemsPerRow = (int) Math.pow(2, iteration - 1);

            int maxIndexToPrint = indexToPrint + itemsPerRow;

            for (int j = 0; j < indent; j++){
                System.out.println(" ");
            }

            for (int l = indexToPrint; l < maxIndexToPrint; l++){
                //System.out.print(theKey[l].key);
            }

            spaces = indent;

            iteration++;

            System.out.println();


        }

    }

}
