/**
 * Pokemon card type. Sets the health and gets the health during a fight.
 */
public class Pokemon extends Card {

    private int hp;

    /**
     * Gets hp of the current current Pokemon in battle.
     *
     * @return The HP of the current Pokemon.
     */
    public int getHP() {
        return hp;
    }

    /**
     * Sets hp for the current Pokemon. Either in battle or initialization.
     *
     * @param userInpHP The HP of the given Pokemon to set.
     */
    public void setHP(int userInpHP) {
        hp = userInpHP;
    }
}
