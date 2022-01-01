package io.github.followsclosley.monopoly;

/**
 * This interface is all you need to create your own AI.
 *
 */
public interface ArtificialIntelligence {

    /**
     * This method is called by the Engine when it is "your" turn to play.
     * It should return the column to drop the piece down.
     *
     * @param board The current state of the game.
     * @return The column (x) to drop the piece.
     */
    int yourTurn(Board board);

}
