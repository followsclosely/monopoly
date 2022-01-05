package io.github.followsclosley.monopoly;

public abstract class Card {

//    (Name, PayAmount, ReceiveAmount, ToAllPlayers, MovesTo)
    private String description;

    public Card(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public abstract void preformAction(Player player);
}