package io.github.followsclosley.monopoly.ui;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Launcher {

    public static void main(String[] args) throws IOException {

        ControlPanel controlPanel = new ControlPanel();
        controlPanel.setBackground(Color.lightGray);

        JFrame frame = new JFrame("Monopoly");
        JButton rollButton = new JButton("Roll Dice");
        rollButton.addActionListener(e -> {

        });
        controlPanel.add(rollButton, BorderLayout.CENTER);
        JButton buyButton = new JButton("Buy");
        controlPanel.add(buyButton, BorderLayout.CENTER);

        JButton sellButton = new JButton("Sell");
        controlPanel.add(sellButton, BorderLayout.CENTER);

        JButton endTurn = new JButton("End turn");
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
