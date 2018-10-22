package com.company;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;
import java.io.File;
import java.util.Scanner;

public class LoopStation extends JFrame{

    public LoopStation() {
        rec = new Recorder();
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
       rec.startRecording();

    }
    private void addRecording(){
        rec.stopRecording();
        success.setVisible(true);
    }
    private Recorder rec;
    private TargetDataLine targetLine;
    private Thread thread;
    private JPanel mainPanel;
    private JTextArea FKLOOPSTATIONTextArea;
    private JButton recordButton;
    private JButton stopButton;
    private JLabel success;
}
