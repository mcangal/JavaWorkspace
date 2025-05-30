package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class WordView extends JFrame {

    private JTextField wordField = new JTextField(15);
    private JButton addButton = new JButton("Ekle");
    private JButton deleteButton = new JButton("Sil");
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> wordList = new JList<>(listModel);

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
    }
    public String getWord(){
        return wordField.getText();
    }
    public void addWordToList(String word){
        listModel.addElement(word);
    }
    public void setAddButtonListener(ActionListener listener){
        addButton.addActionListener(listener);
    }
    public String selectedWord(){
        return wordList.getSelectedValue();
    }
    public void deleteWord(String word){
        listModel.removeElement(word);
    }
    public void setDeleteButtonListener(ActionListener listener){
        deleteButton.addActionListener(listener);
    }




}