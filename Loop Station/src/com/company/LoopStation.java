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
       try{
           AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,44100,16,2,4,44100,false);
           DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
           if(!AudioSystem.isLineSupported(info)) {
               System.out.print("Line is niet gesupport\n");
           }
           targetLine = (TargetDataLine)AudioSystem.getLine(info);
           targetLine.open();
           targetLine.start();

           thread = new Thread()
           {
               @Override public void run()
               {
                   AudioInputStream audioStream = new AudioInputStream(targetLine);


                   Scanner scanner = new Scanner (System.in);
                   System.out.print("Enter your filename\n");
                   String fileName = scanner.next()+".wav";
                   File audioFile = new File(fileName);
                   try{
                       AudioSystem.write(audioStream,AudioFileFormat.Type.WAVE,audioFile);
                   }catch(Exception ex){
                       System.out.print("Fail\n");
                   }

               }
           };
           thread.start();
           System.out.print("Recording has started ! \n");

       }catch(Exception ex){
           System.out.print("Fail\n");
       }

    }
    private void addRecording(){

        targetLine.stop();
        targetLine.close();
        System.out.print("Successfully recorded");

    }
    private TargetDataLine targetLine;
    private Thread thread;
    private JPanel mainPanel;
    private JTextArea FKLOOPSTATIONTextArea;
    private JButton recordButton;
    private JButton stopButton;
}
