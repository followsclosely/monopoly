package io.github.followsclosley.monopoly.card;

import io.github.followsclosley.monopoly.Card;
import io.github.followsclosley.monopoly.Player;
import io.github.followsclosley.monopoly.Street;

public class AdvanceToCard extends Card {
    private final boolean collectGoBonus;

    private final Street street;

    public AdvanceToCard(String description, Street street) {
        this(description, street, true);
    }
    public AdvanceToCard(String description, Street street, boolean collectGoBonus) {
        super(description);
        this.street = street;
        this.collectGoBonus = collectGoBonus;
    }

    @Override
    public void preformAction(Player player) {
        if (player.getPosition() > street.getPosition()){
            player.incrementSavings(200);
        }

        player.setPosition(street.getPosition());
    }
}
