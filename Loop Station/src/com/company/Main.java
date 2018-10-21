package com.company;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame	=	new	JFrame("Loop Station");
        frame.setPreferredSize(new Dimension(800, 800));
        frame.setContentPane(new LoopStation().getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        frame.setVisible(true);
    }
}
