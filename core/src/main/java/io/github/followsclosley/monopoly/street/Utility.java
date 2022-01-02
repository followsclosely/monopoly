package io.github.followsclosley.monopoly.street;

public class Utility extends RealEstate {
    public Utility(String name, int price) {
        super(name, price);
    }

    @Override
    public int getRent() {
        return 0;
    }
}
