package com.company;

public class HashFunction3 {

    WordList[] theArray;

    int arraySize;

    public String[][] elementsToAdd = {
            { "ace", "Very good" },
            { "act", "Take action" },
            { "add", "Join (something) to something else" },
            { "age", "Grow old" },
            { "ago", "Before the present" },
            { "aid", "Help, assist, or support" },
            { "aim", "Point or direct" },
            { "air", "Invisible gaseous substance" },
            { "all", "Used to refer to the whole quantity" },
            { "amp",
                    "Unit of measure for the strength of an electrical current" },
            { "and", "Used to connect words" },
            { "ant", "A small insect" },
            { "any", "Used to refer to one or some of a thing" },
            { "ape", "A large primate" },
            { "apt", "Appropriate or suitable in the circumstances" },
            { "arc", "A part of the circumference of a curve" },
            { "are", "Unit of measure, equal to 100 square meters" },
            { "ark", "The ship built by Noah" },
            { "arm", "Two upper limbs of the human body" },
            { "art", "Expression or application of human creative skill" },
            { "ash", "Powdery residue left after the burning" },
            { "ask", "Say something in order to obtain information" },
            { "asp", "Small southern European viper" },
            { "ass", "Hoofed mammal" },
            { "ate", "To put (food) into the mouth and swallow it" },
            { "atm", "Unit of pressure" },
            { "awe", "A feeling of reverential respect" },
            { "axe", "Edge tool with a heavy bladed head" },
            { "aye", "An affirmative answer" } };


    //constructor sets size, and builds array of Linked WordLists
    public HashFunction3(int size){
        this.arraySize = size;

        theArray = new WordList[size]; //array of word lists

        for (int i = 0; i < arraySize; i++) {
            theArray[i] = new WordList();   //for each index, add a new Linked List (Word List)
        }
        addTheArray(elementsToAdd);     //add the elements to the array
    }

    public void insert(Word newWord){
        String wordToHash = newWord.theWord;
        int hashKey = stringHashFunction(wordToHash);

        theArray[hashKey].insert(newWord, hashKey);

    }

    public Word find(String wordToFind){
        int hashKey = stringHashFunction(wordToFind);

        Word theWord = theArray[hashKey].findWord(hashKey, wordToFind);

        return theWord;
    }

    public void displayTheArray(){
        for (int i = 0; i < arraySize; i++) {
            System.out.println("theArray Index " + i);
            theArray[i].displayWordList();
        }
    }

    //this is just the process of converting strings to ints for indexing in a hash table
    //returns the index for the int
    //this allows us to find a specified three letter word extremely quickly
    public int stringHashFunction(String wordToHash){
        int hashKeyValue = 0;

        for (int i = 0 ; i < wordToHash.length(); i++){

            int charCode = wordToHash.charAt(i) - 96;  // because a is 97, subtracting 96 gives us a charCode of 1 for a

            int hKVTemp = hashKeyValue; //this temp value is just for displaying output

            hashKeyValue = (hashKeyValue * 27 + charCode) % arraySize;

            //for development
            System.out.println("Hash Key Value: "+hKVTemp+ " * 27 + Character Code " + charCode + " % Array Size of "
                    + arraySize + "= current hash key value:"+hashKeyValue);

        }
        System.out.println();
        return hashKeyValue;
    }

    public void addTheArray(String[][] elementsToAdd){
        for (int i = 0; i < elementsToAdd.length; i++) {
            String word = elementsToAdd[i][0];
            String definition = elementsToAdd[i][1];
            Word newWord = new Word(word, definition);
            insert(newWord);
        }
    }

class Word {
    public String theWord;
    public String definition;

    public int key;

    public Word next;

    public Word(String theWord, String definition){
        this.theWord = theWord;
        this.definition = definition;
    }

    //automatically produces word: definition output when you try to sys.out a word.
    public String toString(){
        return theWord + " : " + definition;
    }
}

}
