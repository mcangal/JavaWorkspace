package org.example;

import javax.swing.*;

public class TestWordStarter {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WordView();
            }
        });
    }
}
