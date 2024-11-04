/**
 * Potion Card.
 * An item card that heals the Pokemon for 30 health.
 */
public class Potion extends Item{

    /**
     * Potion ability.
     * Heals the Pokemon for 30 health when used.
     *
     * @param anyPoke The given Pokemon to heal.
     */
    public void potionAbility(Pokemon anyPoke) {
        anyPoke.setHP(anyPoke.getHP() + 30);
    }


}
