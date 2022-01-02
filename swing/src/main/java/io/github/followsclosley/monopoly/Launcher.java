package io.github.followsclosley.monopoly;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Launcher {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.getContentPane().add(new MonopolyPanel());
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);



    }
}
