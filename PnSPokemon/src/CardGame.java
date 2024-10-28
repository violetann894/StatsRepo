import java.util.ArrayList;
import java.util.Random;

public class CardGame {

    private ArrayList<Card> deck;
    private ArrayList<Card> hand;

    public CardGame() {
        deck  = new ArrayList<>();
        hand = new ArrayList<>();
    }
    public void fillDeck(int pkmAdd) {

        for(int i = 0; i < pkmAdd; i++) {
            deck.add(new Pokemon());
        }
        for(int i = 0; i < 60 - pkmAdd; i++) {
            deck.add(new Energy());
        }


    }

    public void drawHand() {
        Random rng = new Random();
        for(int i = 0; i < 7; i++) {
            int cardToTakeIndex = rng.nextInt(deck.size());
            hand.add(deck.get(cardToTakeIndex));
            deck.remove(cardToTakeIndex);
        }
    }

    public boolean hasPokemon() {
        //Loop through hand, if one card is a Pokémon, return true, else return false.
        for(Card singleCard : hand) {
            if(singleCard instanceof Pokemon) {
                return true;
            }
        }
        return false;
    }
    public void run() {
        drawHand();
        hasPokemon();
        /*

         */
    }

    public void printer() {
        float count = 0;

        for(int i = 0; i < 60; i++) {
            for(int x = 0; x < 100000; x++) {
                fillDeck(i);
                run();

                if(hasPokemon()) {
                    count++;
                }
                deck.clear();
                hand.clear();

            }
            System.out.println("Probability of Pokemon: " + (count / 100000));
            count = 0;

        }

    }

}
