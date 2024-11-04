import java.util.Random;

/**
 * Wooloo card.
 * Has 60 base health. A colorless energy card, has two attacks: Defense Curl and Headbutt.
 */
public class Wooloo extends Pokemon{
    private int energy;


    /**
     * Instantiates a new Wooloo for deck usage.
     */
    public Wooloo() {
        setHP(60);
        energy = 1;

    }

    /**
     * Defense Curl.
     * Uses one energy, returns true if the coin flip is heads, meaning damage is blocked for the opponent's next turn.
     *
     * @return the boolean
     */
    public boolean defenseCurl() {
        if (energy >= 1) {
            energy--;
            System.out.println("Wooloo used Defense Curl in hopes of preventing damage!");
            Random rng = new Random();
            int coin = rng.nextInt(2);

            if(coin == 1) {
                System.out.println("Defense Curl was successful! Damage will be prevented!");
                return true;
            }
        }
        return false;
    }

    /**
     * Headbutt.
     * Uses two energy, damages the Pokemon for 20 damage.
     *
     * @param anyPoke The Pokemon receiving damage.
     */
    public void headbutt(Pokemon anyPoke) {
        if (energy >= 2) {
            energy -= 2;

            int newHP = anyPoke.getHP() - 20;
            anyPoke.setHP(newHP);
        }
    }
}
