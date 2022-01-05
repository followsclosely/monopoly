package io.github.followsclosley.monopoly.card;

import io.github.followsclosley.monopoly.Card;
import io.github.followsclosley.monopoly.Player;

public class MoneyTransferCard extends Card {

     private final int amount;
    public MoneyTransferCard(String description, int amount) {
        super(description);
        this.amount = amount;
    }

    @Override
    public void preformAction(Player player) {
        System.out.println("paying " + player.getName() + " : " + amount);
        player.incrementSavings(amount);
    }
}
