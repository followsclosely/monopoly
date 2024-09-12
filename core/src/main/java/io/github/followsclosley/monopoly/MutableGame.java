package io.github.followsclosley.monopoly;

import java.util.ArrayList;
import java.util.List;

public class MutableGame {

    private final Board board;

    private final List<Player> players = new ArrayList<>();
    private Player currentPlayer;

    public MutableGame(Board board, List<Player> players) {
        this.board = board;
        this.players.addAll(players);
        this.currentPlayer = players.get(0);
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
