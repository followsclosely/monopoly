package io.github.followsclosley.monopoly;

import java.time.Instant;

public class Purchase {

    private final int price;
    private final Player owner;
    private final Instant purchaseTime;
    private final TransactionType type;

    public Purchase(Player owner, int price) {
        this(owner, price, TransactionType.Purchase);
    }

    public Purchase(Player owner, int price, TransactionType type) {
        this.price = price;
        this.owner = owner;
        this.purchaseTime = Instant.now();
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public Player getOwner() {
        return owner;
    }

    public Instant getPurchaseTime() {
        return purchaseTime;
    }

    public TransactionType getType() {
        return type;
    }

    public static enum TransactionType {
        Purchase,
        Auction,
        Trade,
        Forfeit
    }
}