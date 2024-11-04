import java.util.Collections;
import java.util.Random;

/**
 * Eevee Card.
 * Has base 50 health. A colorless energy card that has two attacks: Find a Friend, and Smash Kick.
 */
public class Eevee extends Pokemon{

    private int energy;
    CardGame cg;

    /**
     * Instantiates a new Eevee.
     * Sets Find a Friend's usage to the game's deck.
     *
     * @param cg The Card Game object that the deck comes from.
     */
    public Eevee(CardGame cg) {
        setHP(50);
        energy = 1;
        this.cg = cg;
    }


    /**
     * Find a Friend. Searches through the deck and adds the first Pokemon if the coin flip is a heads.
     * Uses 1 energy.
     */
    public void findAFriend() {
        if(energy >= 1) { //Need one basic energy to use this move

            System.out.println("Eevee used Find a Friend!");
            energy--;

            Random rng = new Random();
            int coin = rng.nextInt(2); //Flip a coin to decide if you use this move

            if(coin == 1) {
                for(int i = 0; i < cg.deck.size(); i++) { //Search through the deck for a Pokemon
                    if(cg.deck.get(i) instanceof Pokemon) { //If found
                        System.out.println("Gotcha! Pokemon found!");//Card found text
                        fafHelper(cg.deck.get(i));
                        cg.hand.add(cg.deck.get(i)); //Add the card to your hand
                        cg.deck.remove(i); //Remove it from the deck
                        break; //End the loop
                    }
                }
                System.out.println("Card has now been added to your hand.");
                cg.cardArrayLister(cg.hand);
                Collections.shuffle(cg.deck); //After adding the card, shuffle the deck.
            }
            else {
                System.out.println("Aw man! Coin landed on tails, better luck next time!");
            }
        }
    }

    /**
     * Smash Kick. Damages a Pokemon for 20 damage.
     * Uses 2 energy.
     *
     * @param anyPoke The given Pokemon that takes the damage.
     */
    public void smashKick(Pokemon anyPoke) {
        if (energy >= 2) {
            energy -= 2;

            int newHP = anyPoke.getHP() - 20;
            anyPoke.setHP(newHP);
        }
    }


    /**
     * Find a Friend helper method. returns the text of the found pokemon given the current instance.
     *
     * @param card The current card that's in the search queue.
     */
    public void fafHelper(Card card) {
        if(card instanceof Eevee) {
            System.out.println("You found an Eevee!");
        }else if(card instanceof HisuZoroarkV) {
            System.out.println("You found a Hisuian Zoroark V!");
        }else if(card instanceof Minccino) {
            System.out.println("You found a Minccino!");
        }
    }
}
