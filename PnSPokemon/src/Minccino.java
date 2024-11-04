/**
 * Minccino Card.
 * Has base health 50. A colorless energy card that has two attacks: Gnaw and Tail Smack.
 */
public class Minccino extends Pokemon{

    private int energy;

    /**
     * Instantiates a new Minccino.
     */
    public Minccino() {
        setHP(50);
        energy = 1;
    }

    /**
     * Gnaw. Damages a Pokemon for 10 damage. Uses 1 energy.
     *
     * @param anyPoke The Pokemon being damaged.
     */
    public void gnaw(Pokemon anyPoke) {
        if (energy >= 1) {
            energy--;
            int newHP = anyPoke.getHP() - 10;
            anyPoke.setHP(newHP);
        }
    }

    /**
     * Tail Smack. Damages a Pokemon for 20 damage. Uses 2 energy.
     *
     * @param anyPoke The Pokemon being damaged.
     */
    public void tailSmack(Pokemon anyPoke) {
        if (energy >= 2) {
            energy -= 2;

            int newHP = anyPoke.getHP() - 20;
            anyPoke.setHP(newHP);
        }
    }
}
