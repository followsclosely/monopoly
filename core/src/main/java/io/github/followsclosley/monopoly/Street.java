package io.github.followsclosley.monopoly;

public abstract class Street {
    private static int sequence;

    private final int position;
    private final String name;

    public Street(String name) {
        this.name = name;
        this.position = sequence++;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void preformAction(Player player){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return position == ((Street) o).position;
    }

    @Override
    public int hashCode() {
        return position;
    }
}