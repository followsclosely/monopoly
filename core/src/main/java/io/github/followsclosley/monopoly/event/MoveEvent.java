package io.github.followsclosley.monopoly.event;

import io.github.followsclosley.monopoly.Player;

public class MoveEvent extends GameChangedEvent {
    private Player player;

    public MoveEvent(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
