package com.blackforestcastle;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;

public class TextBox extends JPanel {

    private final JTextArea textField;

    public TextBox() {
        textField = new JTextArea();
        setLayout(new BorderLayout());
        add(new JScrollPane(textField), BorderLayout.CENTER);
        DefaultCaret car = (DefaultCaret)textField.getCaret();
        car.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
    }

    public void append(String text) {
        textField.append(text);
    }

    public String getText() {
        return textField.getText();
    }
}

/*
Created a text-field to place the text for the game in.
 */