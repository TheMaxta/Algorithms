package com.company.Hash;


class Word {
    public String theWord;
    public String definition;

    public int key;

    public HashFunction3.Word next;

    public Word(String theWord, String definition){
        this.theWord = theWord;
        this.definition = definition;
    }

    //automatically produces word: definition output when you try to sys.out a word.
    public String toString(){
        return theWord + " : " + definition;
    }
}