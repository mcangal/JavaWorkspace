package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WordController {
    private WordView view;
    private WordModel model = new WordModel();

    public WordController(WordView view) {
        this.view = view;
        fillList();
        actions();
//        view.setAddButtonListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String word= view.getWord();
//                if(!word.isEmpty()) {
//                    model.addWord(word);
//                    view.addWordToList(word);
//                    view.clearWordInput();
//
//                }
//
//            }
//        });
//       view.setDeleteButtonListener(new ActionListener() {
//           @Override
//           public void actionPerformed(ActionEvent e) {
////               String selectedWord= view.selectedWord();
////               if(selectedWord!= null){
////                   model.deleteWord(selectedWord);
////                   view.deleteWordFromList(selectedWord);
////
////               }
////               int selectedIndex = view.get
//           }
//       });
//       view.setWordInputListener(new ActionListener() {
//           @Override
//           public void actionPerformed(ActionEvent e) {
//            view.triggerAddButton();
//           }
//       });
    }

    private void fillList() {
        refreshScreen();
    }

    private void actions() {
        /** Add Word*/
        view.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String word = view.getWordField().getText();
                if (!word.isEmpty()) {
                    model.addWord(word);
                    refreshScreen();
                }
            }
        });

        /** Delete word*/
        view.getDeleteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = view.getWordList().getSelectedIndex();
                if (selectedIndex != -1) {
                    model.deleteWord(selectedIndex + 1);
                    refreshScreen();
                }
            }
        });
    }

    public void refreshScreen() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addAll(model.getWords());
        view.getWordList().setModel(listModel);

        view.getWordField().setText("");
        view.getWordList().setSelectedIndex(-1);
    }
//    public static void main(String[] args) {
//        WordModel model =new WordModel();
//        WordView view = new WordView();
//        new WordController(model,view);
//    }
}