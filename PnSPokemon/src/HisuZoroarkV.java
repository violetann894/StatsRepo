

/**
 * Hisuian Zoroark V Card.
 * Has base health 210. A colorless energy card that has two attacks: Void Return and Shadow Cyclone.
 */
public class HisuZoroarkV extends Pokemon{

    private int energy;
    CardGame cg;

    /**
     * Instantiates a new Hisuian Zoroark V for usage.
     * Sets the card game usage to the current game instance.
     *
     * @param cg The card game for use.
     */
    public HisuZoroarkV(CardGame cg) {
        setHP(210);
        energy = 1;
        this.cg = cg;
    }

    /**
     * Void Return. Damages the Pokemon for 30, and returns this card to the bench in favor for another Pokemon.
     *
     * @param anyPoke The Pokemon being damaged.
     */
    public void voidReturn(Pokemon anyPoke) {

        int newHP = anyPoke.getHP() - 30;
        anyPoke.setHP(newHP);

        cg.bench.add(this);

    }

    /**
     * Shadow Cyclone. Damages the Pokemon for 130 damage, and moves an energy from this card to a benched Pokemon.
     *
     * @param anyPoke The Pokemon being damaged.
     */
    public void shadowCyclone(Pokemon anyPoke) {
        if (energy >= 3) {
            energy -= 3;

            int newHP = anyPoke.getHP() - 130;
            anyPoke.setHP(newHP);
        }
    }
}
