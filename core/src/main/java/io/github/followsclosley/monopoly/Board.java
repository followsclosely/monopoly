package io.github.followsclosley.monopoly;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Street> streets;

    public Board(Street... street){
        this.streets = new ArrayList<>(streets);
    }
}
