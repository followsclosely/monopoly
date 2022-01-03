package io.github.followsclosley.monopoly;

public class Board {
    private final Street[] streets;

    public Board(Street... streets) {
        this.streets = streets;
    }

    public Street getStreet(int position) {
        return streets[position];
    }
}
