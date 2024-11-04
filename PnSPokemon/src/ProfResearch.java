/**
 * Professor's Research Card.
 * Discards your current hand, and draws seven new cards.
 */
public class ProfResearch extends Supporter{

    CardGame cg;

    /**
     * Instantiates a new Professor's Research for the deck.
     * Sets the card game usage to the current instance.
     *
     * @param cg The card game instance for usage.
     */
    public ProfResearch(CardGame cg) {
        this.cg = cg;
    }

    /**
     * Professor's Research ability.
     * Discard your current hand, and draw 7 new cards.
     */
    public void profResAbility() {
        cg.discardPile.addAll(cg.hand);
        for(int i = 0; i < 7; i++) {
            cg.hand.add(cg.deck.get(i));
        }

    }
}
