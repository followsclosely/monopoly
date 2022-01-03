package io.github.followsclosley.monopoly;

/**
 * This interface is all you need to create your own AI.
 */
public interface ArtificialIntelligence {

    void init(GameManager gameManager, Player player);

    void beforeRoll(MutableGame game);

    void afterRoll(MutableGame game, Street landed, Dice dice);
}
