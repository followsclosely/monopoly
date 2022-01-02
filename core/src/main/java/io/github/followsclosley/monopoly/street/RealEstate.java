package io.github.followsclosley.monopoly.street;

import io.github.followsclosley.monopoly.Purchase;
import io.github.followsclosley.monopoly.Street;

/**
 * Real Estate is a street that can be purchased.
 */
public abstract class RealEstate extends Street {

    private int price;
    private Purchase currentOwner;

    private int rent;

    private int mortgage;
    private boolean mortgaged = false;

    public RealEstate(String name, int price) {
        super(name);
        this.price = price;
        this.mortgage = price / 2;
    }

    public int getPrice() {
        return price;
    }

    public Purchase getOwner() {
        return currentOwner;
    }

    public void setCurrentOwner(Purchase currentOwner) {
        this.currentOwner = currentOwner;
    }

    public abstract int getRent();

    public int getMortgage() {
        return mortgage;
    }

    public boolean isOwned(){
        return currentOwner != null;
    }
    public boolean isMortgaged() {
        return mortgaged;
    }

    public void setMortgaged(boolean mortgaged) {
        this.mortgaged = mortgaged;
    }
}
