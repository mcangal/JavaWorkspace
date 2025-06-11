package org.example;

import java.util.ArrayList;
import java.util.List;

public class WordModel {
    private WordDataBaseService dataBaseService;

    public WordModel() {
        dataBaseService = new WordDataBaseService();
    }

    private List<String> wordList = new ArrayList<>();
    public void addWord(String word){
//        wordList.add(word);
        dataBaseService.addWord(word);
    }
    public List<String> getWords(){
//        return new ArrayList<>(wordList);
        return dataBaseService.getAllWords();
    }
    public void deleteWord(int id){
//        wordList.remove(word);
//        List<String> words = dataBaseService.getAllWords();
        dataBaseService.deleteWord(id);

    }

}