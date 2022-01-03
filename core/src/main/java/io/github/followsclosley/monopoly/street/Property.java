package io.github.followsclosley.monopoly.street;

public class Property extends RealEstate {

    private int priceOfHouse;
    private int houseCount = 0;
    private final int[] rentTable;

    public Property(String name, int price, int priceOfHouse, Color color, int... rentTable) {
        super(name, price);
        this.rentTable = rentTable;
        this.priceOfHouse = priceOfHouse;
    }

    public int getHouseCount() {
        return houseCount;
    }

    public void setHouseCount(int houseCount) {
        this.houseCount = houseCount;
    }

    public int getPriceOfHouse() {
        return priceOfHouse;
    }

    @Override
    public int getRent() {
        return rentTable[houseCount];
    }
}