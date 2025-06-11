package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class WordView extends JFrame {
    private JTextField wordField = new JTextField(15);
    private JButton addButton = new JButton("Ekle");
    private JButton deleteButton = new JButton("Sil");
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> wordList = new JList<>(listModel);
    private WordController controller;
    public WordView(){
        setTitle("Kelime Listesi ");
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(new JLabel("Kelime"));
        add(wordField);
        add(addButton);
        add(deleteButton);
        add(new JScrollPane(wordList));
        setVisible(true);
        controller = new WordController(this);
    }

    public JTextField getWordField() {
        return wordField;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public DefaultListModel<String> getListModel() {
        return listModel;
    }

    public JList<String> getWordList() {
        return wordList;
    }

    public WordController getController() {
        return controller;
    }

    //    public String getWord(){
//        return wordField.getText();
//    }
//    public void addWordToList(String word){
//        listModel.addElement(word);
//    }
//    public void setAddButtonListener(ActionListener listener){
//        addButton.addActionListener(listener);
//    }
//    public String selectedWord(){
//        return wordList.getSelectedValue();
//    }
//    public void deleteWordFromList(String word){
//        listModel.removeElement(word);
//    }
//    public void setDeleteButtonListener(ActionListener listener){
//        deleteButton.addActionListener(listener);
//    }
//    public void clearWordInput() {
//        wordField.setText(" ");
//    }
//
//    public void setWordInputListener(ActionListener listener) {
//        wordField.addActionListener(listener);
//    }
//
//    public void triggerAddButton() {
//        addButton.doClick();
//    }
//    public void setWordInputKeyListener(KeyListener listener){
//        wordField.addKeyListener(listener);
//    }
}