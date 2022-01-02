package io.github.followsclosley.monopoly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Engine {

    private final Dice dice = new Dice(6);

    public static void main(String[] args) {
        Engine engine = new Engine();
        engine.startGame();
    }

    public void startGame() {

        List<Player> players = Arrays.asList(
                new Player("Player 1", new DummyAI()),
                new Player("Player 2", new DummyAI())
        );

        MutableGame game = new MutableGame(new BoardBuilder().build(), players);

        for (Player player : players) {
            player.getArtificialIntelligence().init(player);
        }

        for (int i = 0; true ;) {
            Player player = players.get(i%2);

            game.setCurrentPlayer(player);
            player.getArtificialIntelligence().beforeRoll(game);

            int total = dice.roll().getTotal();
            //todo: Implement third double
            int position = player.getPosition() + total;
            if( position >=40){
                //Just passed GO!
                position = position - 40;
            }

            //Move the player
            player.setPosition(position);
            Street street = game.getBoard().getStreet(position);

            player.getArtificialIntelligence().afterRoll(game, street, dice);

            if( !dice.isDoubles() ){
                i++;
            }

            if( i >= 10 ) return;
        }
    }
}
