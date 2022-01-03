package io.github.followsclosley.monopoly;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.IOException;

public class Launcher {

    public static void main(String[] args) throws IOException {

        ControlPanel controlPanel = new ControlPanel();
        controlPanel.setBackground(Color.lightGray);

        JFrame frame = new JFrame("Monopoly");
        JToggleButton rollButton = new JToggleButton("Roll Dice");
        controlPanel.add(rollButton, BorderLayout.CENTER);
        JToggleButton buyButton = new JToggleButton("Buy");
        controlPanel.add(buyButton, BorderLayout.CENTER);
        JToggleButton sellButton = new JToggleButton("Sell");
        controlPanel.add(sellButton, BorderLayout.CENTER);
        JToggleButton endTurn = new JToggleButton("End turn");
        controlPanel.add(endTurn);




        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(new MonopolyPanel(), BorderLayout.CENTER);
        frame.getContentPane().add(controlPanel, BorderLayout.EAST);




        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);




    }
}
