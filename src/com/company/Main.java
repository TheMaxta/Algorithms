package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        if(false) {
            Scanner input = new Scanner(System.in);

            HashFunction3 theFunc = new HashFunction3(11);

            String wordLookUp = "a";
            while (!wordLookUp.equalsIgnoreCase("x")) {
                System.out.println(": ");

                wordLookUp = input.nextLine();

                System.out.println(theFunc.find(wordLookUp));
            }
            theFunc.displayTheArray();
        }





    }
}
