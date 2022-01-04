package io.github.followsclosley.monopoly;

import io.github.followsclosley.monopoly.event.GameChangedEvent;
import io.github.followsclosley.monopoly.event.GameEventListener;
import io.github.followsclosley.monopoly.event.MoveEvent;
import io.github.followsclosley.monopoly.street.Property;
import io.github.followsclosley.monopoly.street.RealEstate;
import io.github.followsclosley.monopoly.street.Tax;

import java.util.ArrayList;
import java.util.List;

public class Engine implements GameManager {

    private final Dice dice = new Dice(6);

    private List<Player> players = new ArrayList<>();

    private MutableGame game;

    private List<GameEventListener> listeners = new ArrayList<>();

    public static void main(String[] args) {
        Engine engine = new Engine();
        engine.addPlayer(new Player("Player 1", new DummyAI()));
        engine.addPlayer(new Player("Player 2", new DummyAI()));
        engine.startGame();
    }

    @Override
    public MutableGame getGame() {
        if( game == null ){
            this.game = new MutableGame(new BoardBuilder().build(), players);
        }
        return this.game;
    }

    public Engine addListener(GameEventListener l){
        listeners.add(l);
        return this;
    }
    private void fireEvent(GameChangedEvent e){
        for(GameEventListener l : listeners){
            l.onEvent(e);
        }
    }

    public Engine addPlayer(Player player) {
        this.players.add(player);
        return this;
    }

    public void startGame() {

        getGame();

        for (Player player : players) {
            player.getArtificialIntelligence().init(this, player);
        }

        int i = 0;
        int turns = 0;

        do {
            Player player = players.get(i % 2);

            game.setCurrentPlayer(player);
            player.getArtificialIntelligence().beforeRoll(game);

            int total = dice.roll().getTotal();
            //todo: Implement third double
            int position = player.getPosition() + total;
            if (position >= 40) {
                //Just passed GO!
                position = position - 40;
            }

            //Move the player
            player.setPosition(position);
            Street street = game.getBoard().getStreet(position);
            if (street instanceof Tax t) {
                t.getFee();
            }

            fireEvent(new MoveEvent(player));

            player.getArtificialIntelligence().afterRoll(game, street, dice);

            //if (!dice.isDoubles())
            {
                i++;
            }

            try {Thread.sleep(1000);}catch (InterruptedException ignore) {}

            if (i >= 100) return;
        } while (true);
    }

    public MutableGame purchaseRealEstate(RealEstate re) {
        if (re.isOwned()) {
            //todo: Design error handling
        } else {
            re.setCurrentOwner(new Purchase(game.getCurrentPlayer(), re.getPrice()));
            game.getCurrentPlayer().addRealEstate(re);
        }
        return game;
    }

    public MutableGame purchaseHouse(Property re) {
        //You must own the property to purchase houses
        if (!re.isOwned() || !re.getOwner().equals(game.getCurrentPlayer())) {
            //todo:
        } else {
            //todo: Check if you have a monopoly
            //todo: Check if the houses are evenly distributed
            re.setHouseCount(re.getHouseCount() + 1);

        }

        return game;
    }
}
