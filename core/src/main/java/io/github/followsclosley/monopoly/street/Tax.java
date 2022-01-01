package io.github.followsclosley.monopoly.street;

import io.github.followsclosley.monopoly.Street;

public class Tax extends Street {
    private int fee;

    public Tax(String name, int fee) {
        super(name);
        this.fee = fee;
    }
}
