package io.github.followsclosley.monopoly;

import java.time.Instant;

public class Purchase {

    private int price;
    private Player owner;
    private Instant purchaseTime;
    private TransactionType type;

    public static enum TransactionType {
        Purchase,
        Auction,
        Trade,
        Forfeit
    }
}