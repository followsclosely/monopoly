package io.github.followsclosley.monopoly;

import io.github.followsclosley.monopoly.street.Property;
import io.github.followsclosley.monopoly.street.RealEstate;
import io.github.followsclosley.monopoly.street.Tax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Engine implements GameManager {

    private final Dice dice = new Dice(6);
    private MutableGame game;

    public void startGame() {

        List<Player> players = Arrays.asList(
                new Player("Player 1", new DummyAI()),
                new Player("Player 2", new DummyAI())
        );

        this.game = new MutableGame(new BoardBuilder().build(), players);

        for (Player player : players) {
            player.getArtificialIntelligence().init(this, player);
        }

        int i = 0;
        int turns=0;

        do {
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
            if (street instanceof Tax t){
                t.getFee();
            }

            player.getArtificialIntelligence().afterRoll(game, street, dice);

            if( !dice.isDoubles() ){
                i++;
            }

            if( i >= 10 ) return;
        } while (true);
    }

    public MutableGame purchaseRealEstate(RealEstate re){
        if( re.isOwned() ){
            //todo: Design error handling
        }
        else {
            re.setCurrentOwner(new Purchase(game.getCurrentPlayer(), re.getPrice()));
            game.getCurrentPlayer().addRealEstate(re);
        }
        return game;
    }

    public MutableGame purchaseHouse(Property re){
        //You must own the property to purchase houses
        if( !re.isOwned() || !re.getOwner().equals(game.getCurrentPlayer()) ){
            //todo:
        }
        else {
            //todo: Check if you have a monopoly
            //todo: Check if the houses are evenly distributed
            re.setHouseCount(re.getHouseCount() + 1);

        }

        return game;
    }

    public static void main(String[] args) {
        Engine engine = new Engine();
        engine.startGame();
    }
}
