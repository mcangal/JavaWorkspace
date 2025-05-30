package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordController {

    private WordModel model;
    private WordView view;

    public WordController(WordModel model,WordView view){

        this.model = model;
        this.view = view;

        view.setAddButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String word= view.getWord();
                if(!word.isEmpty()) {
                    model.addWord(word);
                    view.addWordToList(word);

                }
            }
        });
       view.setDeleteButtonListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               String selectedWord= view.selectedWord();
               if(selectedWord!= null){
                   model.deleteWord(selectedWord);
                   view.deleteWordFromList(selectedWord);
               }
           }
       });


    }

    public static void main(String[] args) {
        WordModel model =new WordModel();
        WordView view = new WordView();
        new WordController(model,view);
    }
}