package io.github.followsclosley.monopoly;

public abstract class Street {
    private String name;

    public Street(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}