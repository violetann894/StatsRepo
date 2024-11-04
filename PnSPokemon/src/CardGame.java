import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * The type Card game. Contains all methods to run the game, and to set the deck up for play.
 * Contains every type of card, and initializes them for use.
 */
public class CardGame {


    public ArrayList<Card> deck;
    public ArrayList<Card> hand;
    public ArrayList<Card> bench;
    public Card activePokemon;
    public ArrayList<Card> discardPile;
    public ArrayList<Card> prizePool;
    public ArrayList<String> cardNames;
    Pokemon pokemon;
    Energy energy;
    Trainer trainer;
    Eevee eevee;
    HisuZoroarkV hisuZoroarkV;
    Minccino minccino;
    Wooloo wooloo;
    Cynthia cynthia;
    ProfResearch profResearch;


    /**
     * Instantiates a new Card game.
     * Initializes all cards in the deck for usage.
     */
    public CardGame() {
        deck  = new ArrayList<>();
        hand = new ArrayList<>();
        prizePool = new ArrayList<>();
        cardNames = new ArrayList<>();
        bench = new ArrayList<>();
        discardPile = new ArrayList<>();
        activePokemon = null;

        pokemon = new Pokemon();
        energy = new Energy();
        trainer = new Trainer();
        eevee = new Eevee(this);
        hisuZoroarkV = new HisuZoroarkV(this);
        minccino = new Minccino();
        wooloo = new Wooloo();
    }

    /**
     * Fill deck method. Creates a deck of 60 cards, with no more than 4 of the same Pokemon
     * and 5 of the same Trainer card.
     * Fills the rest of the deck with basic colorless energy for use.
     * Shuffles the deck after creation so card selection is random.
     */
    public void fillDeck() {
        System.out.println("CREATING DECK...");
        for(int i = 0; i < 6; i++) {
            try {
                Thread.sleep(500); //.5 second intervals
            } catch (InterruptedException _) {}
            System.out.println(".");
        } //Special effects



        for(int i = 0; i < 4; i++) { //16 total cards
            deck.add(new Eevee(this));
            deck.add(new HisuZoroarkV(this));
            deck.add(new Wooloo());
            deck.add(new Minccino());
        }
        for(int i = 0; i < 5; i++) { //36 total cards after add
            deck.add(new Tierno(this));
            deck.add(new Cynthia(this));
            deck.add(new ProfResearch(this));
            deck.add(new Potion());
        }
        for(int i = 0; i < 24; i++) { //60 total cards after add
            deck.add(new Energy());
        }
        System.out.println("Deck current size: " + deck.size()); //TESTER
        Collections.shuffle(deck);
        System.out.print("Current Deck ");
        cardArrayLister(deck); //TESTER
    }


    /**
     * Draw hand method. Draws a hand for 7 cards.
     */
    public void drawHand() {

        for(int i = 0; i < 7; i++) {
            hand.add(deck.get(i));
            deck.remove(i);
        }

        System.out.println("Hand current size: " + hand.size()); //TESTER
        cardArrayLister(hand); //TESTER
        System.out.println("\n");
        System.out.println("Deck current size: " + deck.size()); //TESTER
        cardArrayLister(deck); //TESTER
    }

    /**
     * Draw prize pool method. Sets the prize cards of the game after deck and hand creation.
     */
    public void drawPrizePool() {
        for(int i = 0; i < 6; i++) {
            prizePool.add(deck.get(i));
            deck.remove(i);
        }
        System.out.println("Hand current size: " + hand.size()); //TESTER
        cardArrayLister(hand); //TESTER
        System.out.println("Deck current size: " + deck.size()); //TESTER
        cardArrayLister(deck); //TESTER
        System.out.println("Prize Cards current size: " + prizePool.size()); //TESTER
        cardArrayLister(prizePool); //TESTER

    }

    /**
     * Has Pokemon boolean.
     * Checks to see if the hand contains a Pokemon.
     * (USED FOR MONTE CARLO SIMULATION)
     *
     * @return The boolean value whether a Pokemon was found.
     */
    public boolean hasPokemon() {
        //Loop through hand, if one card is a Pokémon, return true, else return false.
        for(Card singleCard : hand) {
            if(singleCard instanceof Pokemon) {
                return true;
            }
        }
        return false;
    }

    /**
     * Run method. Runs the fillDeck, drawHand, and drawPrizePool methods for testing.
     * Sets up the cards for play.
     */
    public void run() {
        fillDeck();
        drawHand();
        drawPrizePool();
    }

    /**
     * Helper method to list cards in a string array format.
     * Sifts through the deck to create a string array of the deck, hand, or prize pool for printing.
     *
     * @param array The given array to replicate.
     */
    public void cardArrayLister(ArrayList<Card> array) {
        cardNames.clear();
        for(int i = 0; i < array.size(); i++) {
            if(array.get(i) instanceof Eevee) {
                cardNames.add("Eevee");
            }else if(array.get(i) instanceof HisuZoroarkV) {
                cardNames.add("Hisuian Zoroark V");
            }else if(array.get(i) instanceof Wooloo) {
                cardNames.add("Wooloo");
            }else if(array.get(i) instanceof Minccino) {
                cardNames.add("Minccino");
            }else if(array.get(i) instanceof Energy) {
                cardNames.add("Energy");
            }else if(array.get(i) instanceof Cynthia) {
                cardNames.add("Cynthia");
            }else if(array.get(i) instanceof ProfResearch) {
                cardNames.add("Professor's Research");
            }else if(array.get(i) instanceof Potion) {
                cardNames.add("Potion");
            }else if(array.get(i) instanceof Tierno) {
                cardNames.add("Tierno");
            }
        }
        System.out.print("Cards: ");
        System.out.println(cardNames);
    }


}

