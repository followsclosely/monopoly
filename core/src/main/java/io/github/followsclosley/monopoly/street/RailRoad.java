package io.github.followsclosley.monopoly.street;

public class RailRoad extends RealEstate {
    public RailRoad(String name, int price) {
        super(name, price);
    }

    @Override
    public int getRent() {
        return 25;
    }
}
