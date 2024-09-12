package io.github.followsclosley.monopoly.ui;

import io.github.followsclosley.monopoly.DummyAI;
import io.github.followsclosley.monopoly.Engine;
import io.github.followsclosley.monopoly.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Launcher {

    public static void main(String[] args) throws IOException {

        Engine engine = new Engine();
        engine
                .addPlayer(new Player("Jaron", new Adapter()))
                .addPlayer(new Player("Player 1", new DummyAI()));

        ControlPanel controlPanel = new ControlPanel();
        controlPanel.setBackground(Color.lightGray);

        JFrame frame = new JFrame("Monopoly");
        JButton rollButton = new JButton("Roll Dice");
        controlPanel.add(rollButton, BorderLayout.CENTER);
        JButton buyButton = new JButton("Buy");
        controlPanel.add(buyButton, BorderLayout.CENTER);

        JButton sellButton = new JButton("Sell");
        controlPanel.add(sellButton, BorderLayout.CENTER);

        JButton endTurn = new JButton("End turn");
        controlPanel.add(endTurn);

        MonopolyPanel monopolyPanel = new MonopolyPanel();
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(monopolyPanel, BorderLayout.CENTER);
        frame.getContentPane().add(controlPanel, BorderLayout.EAST);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);


        monopolyPanel.setGame(engine.getGame());

        engine
          .addListener(e -> {
              SwingUtilities.invokeLater(monopolyPanel::repaint);
          });

        monopolyPanel.addMouseListener(new MouseAdapter() {// provides empty implementation of all
            // MouseListener`s methods, allowing us to
            // override only those which interests us
            @Override //I override only one method for presentation
            public void mousePressed(MouseEvent e) {
                System.out.println(e.getX() + "," + e.getY());
            }
        });


        new Thread(engine::startGame).start();
    }
}
