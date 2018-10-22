package com.company;

import javax.sound.sampled.*;
import java.io.*;
import java.util.Scanner;

public class Recorder {

    public Recorder(){
        format = new AudioFormat(16000, 8,
                2, true,false);
    }

    public void startRecording(){
        try{
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
            targetLine = (TargetDataLine)AudioSystem.getLine(info);
            targetLine.open();
            targetLine.start();
            thread = new Thread()
            {
                @Override public void run()
                {
                    AudioInputStream audioStream = new AudioInputStream(targetLine);
                    File audioFile = new File(getFilename());
                    try{
                        AudioSystem.write(audioStream,AudioFileFormat.Type.WAVE,audioFile);
                    }catch(Exception ex){
                        System.out.print("Fail\n");
                    }
                }
            };
            thread.start();
        }catch(Exception ex){
            System.out.print("Fail\n");
        }
    }

    public void stopRecording(){
        targetLine.stop();
        targetLine.close();
        System.out.print("Successfully recorded");

    }

    private String getFilename(){
        Scanner scanner = new Scanner (System.in);
        System.out.print("Enter filename\n");
        String fileName = scanner.next()+".wav";
        return fileName;
    }

    private AudioFormat format;
    private TargetDataLine targetLine;
    private Thread thread;
}
