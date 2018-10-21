package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoopStation {

    public LoopStation() {
        recordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                record();
            }
        });
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addRecording();
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private void record(){

    }
    private void addRecording(){

    }


    private JPanel mainPanel;
    private JTextArea FKLOOPSTATIONTextArea;
    private JButton recordButton;
    private JButton stopButton;
}
