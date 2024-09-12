package io.github.followsclosley.monopoly;

import io.github.followsclosley.monopoly.street.Property;
import io.github.followsclosley.monopoly.street.RealEstate;

public interface GameManager {
    MutableGame getGame();
    MutableGame purchaseRealEstate(RealEstate re);
    MutableGame purchaseHouse(Property re);
}