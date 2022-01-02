package io.github.followsclosley.monopoly;

import io.github.followsclosley.monopoly.street.RealEstate;

import java.util.ArrayList;
import java.util.List;

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

    public void addRealEstate(RealEstate re){
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
}
