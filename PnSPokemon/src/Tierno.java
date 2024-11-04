/**
 * Tierno Card.
 * Adds three cards to your hand when played.
 */
public class Tierno extends Supporter{

    CardGame cg;

    /**
     * Instantiates a new Tierno card.
     * Sets the card game to the current instance.
     *
     * @param cg The instance of the card game to use.
     */
    public Tierno(CardGame cg) {
        this.cg = cg;
    }

    /**
     * Tierno ability.
     * Draws three cards for the hand to use.
     */
    public void tiernoAbility() {
        for(int i = 0; i < 3; i++) {
            cg.hand.add(cg.deck.get(i));
        }
    }

}
