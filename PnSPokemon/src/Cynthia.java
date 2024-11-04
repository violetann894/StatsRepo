import java.util.Collections;

/**
 * Cynthia Card.
 * Adds all cards from the hand to the deck, then shuffles and draws 6 new cards.
 */
public class Cynthia extends Supporter{

    CardGame cg;

    /**
     * Instantiates a new Cynthia card.
     * Sets the card game use to the current instance.
     *
     * @param cg The card game instance to be used.
     */
    public Cynthia(CardGame cg) {
        this.cg = cg;
    }

    /**
     * Cyhtn ability.
     * Return hand cards to the deck, shuffle the deck and draw 6 new cards.
     */
    public void cyhtnAbility() {
        cg.deck.addAll(cg.hand);
        Collections.shuffle(cg.deck);
        for(int i = 0; i < 6; i++) {
            cg.hand.add(cg.deck.get(i));
        }
    }

}
