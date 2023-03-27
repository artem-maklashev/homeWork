package ui.desktop;

import ui.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class AddNote {
    View view;

    public AddNote(View view) {
        this.view = view;
        JFrame editFrame = new JFrame("Add Note");
        editFrame.setSize(300, 200);
        editFrame.setLocationRelativeTo(null);
        JPanel editPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JLabel editLabel = new JLabel("Введите новую заметку");
        JTextArea textField = new JTextArea(5, 6);
        textField.setEditable(true);
        textField.setLocation(10, 20);

        JButton b1 = new JButton("OK");
        JButton b2 = new JButton("Cancel");
        b1.addActionListener(e -> {
            String newText = textField.getText().replace("\n"," ");
            if (newText != null) {
                view.setNote(newText);
                editFrame.dispatchEvent(new WindowEvent(editFrame, WindowEvent.WINDOW_CLOSING));
                view.print("Заметка добавлена");
            }
        });
        b2.addActionListener(e -> editFrame.dispatchEvent(new WindowEvent(editFrame, WindowEvent.WINDOW_CLOSING)));
        editLabel.setVisible(true);
        editPanel.add(editLabel);
        editPanel.add(textField, BorderLayout.CENTER);
        buttonPanel.add(b1, BorderLayout.SOUTH);
        buttonPanel.add(b2, BorderLayout.SOUTH);
        editPanel.setVisible(true);
        buttonPanel.setVisible(true);
        editFrame.add(editPanel, BorderLayout.NORTH);
        editFrame.add(buttonPanel, BorderLayout.SOUTH);
        editFrame.setVisible(true);

    }
}

