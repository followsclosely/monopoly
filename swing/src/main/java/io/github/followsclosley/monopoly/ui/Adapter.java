package io.github.followsclosley.monopoly.ui;

import io.github.followsclosley.monopoly.*;

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
        System.out.println("YOUR ROLL DUMMY!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    @Override
    public void afterRoll(MutableGame game, Street landed, Dice dice) {
        System.out.println("dice = " + dice);
    }
}
