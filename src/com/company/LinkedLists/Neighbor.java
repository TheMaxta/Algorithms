package com.company.LinkedLists;

public class Neighbor {
    public String homeOwnerName;
    public int houseNumber;

    public Neighbor next;
    public Neighbor previous;

    //constructor
    public Neighbor(String homeOwnerName, int houseNumber){
        this.homeOwnerName = homeOwnerName;
        this.houseNumber = houseNumber;
    }

    public void display(){
        System.out.println(homeOwnerName + ": "+ houseNumber + " Privet Drive");
    }

    //overrides toString method, so we can output what we want here
    public String toString(){
        return homeOwnerName;
    }
}


