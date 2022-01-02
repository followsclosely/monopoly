package io.github.followsclosley.monopoly;

import java.util.Random;

public class Dice {
    private final Random random = new Random();

    private int total;
    private int dice1, dice2;
    private final int numberOfSides;

    protected Dice(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }

    public Dice roll() {
        dice1 = random.nextInt(numberOfSides) + 1;
        dice2 = random.nextInt(numberOfSides) + 1;
        return this;
    }

    public int getTotal() {
        return dice1 + dice2;
    }

    public boolean isDoubles() {
        return dice1 == dice2;
    }

    @Override
    public String toString() {
        return "[" + dice1 + ","+ dice2 + "]";
    }
}
