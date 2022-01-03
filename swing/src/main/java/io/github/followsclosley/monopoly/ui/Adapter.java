package io.github.followsclosley.monopoly.ui;

import io.github.followsclosley.monopoly.*;
import io.github.followsclosley.monopoly.street.RealEstate;

import javax.swing.*;

public class Adapter implements ArtificialIntelligence {

    private Player player;
    private GameManager gameManager;

    @Override
    public void init(GameManager gameManager, Player player) {
        this.gameManager = gameManager;
        this.player = player;
    }

    @Override
    public void beforeRoll(MutableGame game) {
        System.out.println("Jaron: YOUR ROLL DUMMY!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        JOptionPane.showMessageDialog(null, "Roll Dice?");

    }

    @Override
    public void afterRoll(MutableGame game, Street landed, Dice dice) {
        System.out.println(player.getName() + " ("+player.getPosition()+"): afterRoll(" + landed.getName() + ", " + dice + ")");

        if (landed instanceof RealEstate re && !re.isOwned()) {
            System.out.println(player.getName() + " ("+player.getPosition()+") " + landed.getName() + " is not owned, I will buy it!");
            game = gameManager.purchaseRealEstate(re);
        }
    }
}
