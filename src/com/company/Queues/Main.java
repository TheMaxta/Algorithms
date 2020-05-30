package com.company.Queues;

public class Main {

    public static void main(String[] args) {

        TheQueue pileOfPancakes = new TheQueue(10);

        pileOfPancakes.insert("10");
        pileOfPancakes.insert("15");
        pileOfPancakes.insert("11");
        pileOfPancakes.insert("12");

        pileOfPancakes.displayTheStack();



    }
}