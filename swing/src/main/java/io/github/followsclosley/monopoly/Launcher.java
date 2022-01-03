package io.github.followsclosley.monopoly;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.IOException;

public class Launcher {

    public static void main(String[] args) throws IOException {

        JFrame frame = new JFrame("Monopoly");
        frame.getContentPane().add(new MonopolyPanel());
        frame.pack();


        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        frame.setVisible(true);
        frame.setResizable(true);




    }
}
