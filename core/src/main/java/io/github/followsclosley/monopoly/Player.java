package io.github.followsclosley.monopoly;

import io.github.followsclosley.monopoly.street.RealEstate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player {

    private final String name;
    private final ArtificialIntelligence ai;

    private int position;
    private int savings;

    private List<RealEstate> streets = new ArrayList<>();

    public Player(String name, ArtificialIntelligence ai) {
        this.name = name;
        this.ai = ai;
    }

    public int getSavings() {
        return savings;
    }

    public void addRealEstate(RealEstate re) {
        streets.add(re);
    }

    public List<RealEstate> getRealEstate() {
        return streets;
    }

    public ArtificialIntelligence getArtificialIntelligence() {
        return ai;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
