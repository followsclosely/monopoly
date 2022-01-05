package io.github.followsclosley.monopoly;

import io.github.followsclosley.monopoly.card.AdvanceToCard;
import io.github.followsclosley.monopoly.card.MoneyTransferCard;
import io.github.followsclosley.monopoly.street.*;

import java.sql.Array;
import java.util.Arrays;

public class BoardBuilder {

    public Board build() {
        Jail jail = new Jail("Jail");
        Property illinoisAve = new Property("Illinois Avenue", 240, 150, Color.RED, 20, 100, 300, 750, 925, 1100);
        Chance chance = new Chance("Chance", Arrays.asList(
                new MoneyTransferCard("Bank pays you dividend of $50", 50),
                new MoneyTransferCard("Speeding fine $15", -15),
                new AdvanceToCard("Advance to Illinois Avenue. If you pass Go, collect $200", illinoisAve),
                new AdvanceToCard("Go to Jail. Go directly to Jail, do not pass Go, do not collect $200", jail, false)
        ));

        return new Board(
                new Go("Go"),
                new Property("Mediterranean Avenue", 60, 50, Color.BROWN, 2, 10, 30, 90, 160, 250),
                new CommunityChest("Community Chest"),
                new Property("Baltic Avenue", 60, 50, Color.BROWN, 4, 20, 60, 180, 320, 450),
                new Tax("Income Tax", 200),
                new RailRoad("Reading Railroad", 200),
                new Property("Oriental Avenue", 100, 50, Color.AQUA, 6, 30, 90, 270, 400, 550),
                chance,
                new Property("Vermont Avenue", 100, 50, Color.AQUA, 6, 30, 90, 270, 400, 550),
                new Property("Connecticut Avenue", 120, 50, Color.AQUA, 8, 40, 100, 300, 450, 600),

                jail,
                new Property("St. Charles Place", 140, 100, Color.PURPLE, 10, 50, 150, 450, 625, 750),
                new Utility("Electric Company", 150),
                new Property("States Avenue", 140, 100, Color.PURPLE, 10, 50, 150, 450, 625, 750),
                new Property("Virginia Avenue", 160, 100, Color.PURPLE, 12, 60, 180, 500, 700, 900),
                new RailRoad("Pennsylvania Railroad", 200),
                new Property("St James Place", 140, 100, Color.ORANGE, 14, 70, 200, 550, 750, 950),
                new CommunityChest("Community Chest"),
                new Property("Tennessee Avenue", 140, 100, Color.ORANGE, 14, 70, 200, 550, 750, 950),
                new Property("New York Avenue", 160, 100, Color.ORANGE, 16, 80, 220, 600, 800, 1000),

                new FreeParking("Free Parking"),
                new Property("Kentucky Avenue", 220, 150, Color.RED, 18, 90, 250, 700, 875, 1050),
                chance,
                new Property("Indiana Avenue", 220, 150, Color.RED, 18, 90, 250, 700, 875, 1050),
                illinoisAve,
                new RailRoad("B. & O. Railroad", 200),
                new Property("Atlantic Avenue", 260, 150, Color.YELLOW, 22, 110, 330, 800, 975, 1150),
                new Utility("Water Works", 150),
                new Property("Ventnor Avenue", 260, 150, Color.YELLOW, 22, 110, 330, 800, 975, 1150),
                new Property("Marvin Gardens", 280, 150, Color.YELLOW, 24, 120, 360, 850, 1025, 1200),

                new GoToJail("Go To Jail"),
                new Property("Pacific Avenue", 300, 200, Color.GREEN, 26, 130, 390, 900, 1100, 1275),
                new Property("North Carolina Avenue", 300, 200, Color.GREEN, 26, 130, 390, 900, 1100, 1275),
                new CommunityChest("Community Chest"),
                new Property("Pennsylvania Avenue", 320, 200, Color.GREEN, 28, 150, 450, 1000, 1200, 1400),
                new RailRoad("Short Line", 200),
                chance,
                new Property("Park Place", 350, 200, Color.BLUE, 35, 175, 500, 1100, 1300, 1500),
                new Tax("Luxury Tax", 100),
                new Property("Board Walk", 400, 200, Color.BLUE, 50, 200, 600, 1400, 1700, 2000)
        );
    }
}
