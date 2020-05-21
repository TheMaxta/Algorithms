package com.company;

class WordList {
    public HashFunction3.Word firstWord = null;

    public void insert(HashFunction3.Word newWord, int hashKey){
        HashFunction3.Word previous = null;
        HashFunction3.Word current = firstWord;

        newWord.key = hashKey;

        //while we haven't reached the end, and new word's key is still larger than the current key (this will sort it alphabetically)
        //building lists alphabetically will reduce linear probing runtime when finding a word in a long list.
        while(current != null && newWord.key > current.key){
            previous = current;
            current = current.next;
        }
        if (previous == null)
            firstWord = newWord;
        else
            previous.next = newWord;

        newWord.next = current;
    } //end of insert method

    //find a word in our list by it's hash key
    public HashFunction3.Word findWord(int hashKey, String wordToFind){
        HashFunction3.Word current = firstWord;

        while(current != null && current.key <= hashKey){
            if((current.theWord).equals(wordToFind))
                return current;
            current = current.next;
        }
        return null; //no match
    }


    public void displayWordList(){
        HashFunction3.Word current = firstWord;

        while(current != null){ //current will == null at end of List. So this means terminate at the end
            System.out.println(current);
            current = current.next; //move to the next word in list
        }

    }
}


