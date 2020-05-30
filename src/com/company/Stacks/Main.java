package com.company.Stacks;

public class Main {
    public static void main(String[] args) {

        TheStack stack = new TheStack(10);


        stack.push("The");
        stack.push("Cake");
        stack.push("Is");
        stack.push("A Lie");
        stack.push("Hello");
        stack.push("World");
        stack.displayTheStack();
        stack.pop();
        stack.doubleByPrime();
        System.out.println(stack.stackSize);

        stack.pushMany("12 42 69 420 1337 1234");

        stack.displayTheStack();



    }
}
