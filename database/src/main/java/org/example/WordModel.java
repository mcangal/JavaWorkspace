package org.example;

import java.util.ArrayList;
import java.util.List;

public class WordModel {

    private List<String> wordList = new ArrayList<>();
    public void addWord(String word){
        wordList.add(word);
    }
    public List<String> getWords(){
        return new ArrayList<>(wordList);
    }

    public void deleteWord(String word){
        wordList.remove(word);
    }
}