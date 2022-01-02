package io.github.followsclosley.monopoly;

public abstract class Street {
    private static int sequence;

    private final int index;
    private final String name;

    public Street(String name) {
        this.name = name;
        this.index = sequence++;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return index == ((Street) o).index;
    }

    @Override
    public int hashCode() {
        return index;
    }
}