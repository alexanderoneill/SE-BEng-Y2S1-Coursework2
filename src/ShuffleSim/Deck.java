/**
 * @author B00758943
 */

 package ShuffleSim;

import java.util.Random;

public final class Deck implements DeckInterface {

    /**
     * Number of cards in a standard playing card deck, excluding Jokers
     */
    private final int DECK_SIZE = 52;

    /**
     * String array containing card suits (or their initials at least)
     */
    private final String[] SUITS = {"H", "D", "C", "S"};

    /**
     * String array containing card numbers (or ranks, if you're a purist)
     */
    private final String[] NUMBERS = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    /**
     * Flag to check if deck has been initialised
     */
    private boolean deckInitialised = false;

    /**
     * String array containing a deck of cards including the card number
     * and suit in the format NS where N=number and S=suit.
     * Decided to use StringArray as it provides all the
     * functionality and flexibility I'd need for this project, and is simple enough to implement, it also allows
     * for easily readable output, considering the amount of times this is printed in a single run of the CardForce,
     * readability was a valid concern
     */
    private String[] cards = new String[DECK_SIZE];

    /**
     * Constructor, populates deck with card strings
     * Cards are in HDCS, ascending numerical order
     * (i.e. Ace of Hearts, Two of Diamonds, Three of Clubs... etc.
     * Generating the card strings this way, while arguably haphazard, is just easier to implement than
     * an ordered generation, I could sort the deck with a separate algo, but the deck doesn't need to be sorted
     * in the first place
     */
    public Deck() {

        int s = 0;
        int n = 0;

        for (int i = 0; i < DECK_SIZE; i++) {

            if (s == 4) {

                s = 0;

            }

            if (n == 13) {

                n = 0;

            }

            cards[i] = NUMBERS[n] + SUITS[s];

            s++;
            n++;

        }

        deckInitialised = true;

    }

    public String show() {

        String strResult = ("[");

        for (int i = 0; i < DECK_SIZE; i++) {

            strResult += cards[i];
            strResult += (", ");

        }

        strResult += ("]");

        return strResult;

    }

    public String reveal() {

        return (cards[0]);

    }

    public int find(String cardtofind) {

        for (int i = 0; i < DECK_SIZE; i++) {

            if (cards[i].equals(cardtofind)) {

                return (i + 1);

            }

        }

        return (-1);

    }

    public void cardforce(int position) {

        String binarypos = Integer.toBinaryString(position - 1);

        for (int i = 0; i < binarypos.length(); i++) {

            if (binarypos.charAt(i) == '0') {

                outshuffle();

            } else {

                inshuffle();

            }

        }

    }

    public void shuffle() {

        Random r = new Random();
        int randitem;
        String temp;

        /** This isn't a perfect shuffle, meaning it's perfectly
         * plausible that a card may not move at all, or that a card
         * will be moved twice, luckily, that's how shuffles work
         */
        for (int i = 0; i < DECK_SIZE; i++) {

            randitem = r.nextInt(DECK_SIZE - 1);
            temp = cards[randitem];
            cards[randitem] = cards[i];
            cards[i] = temp;

        }

    }

    private void inshuffle() {

        String[] deckhalf1 = new String[DECK_SIZE / 2];
        String[] deckhalf2 = new String[DECK_SIZE / 2];

        for (int i = 0; i < DECK_SIZE / 2; i++) {

            deckhalf1[i] = cards[i];
            deckhalf2[i] = cards[i + (DECK_SIZE / 2)];

        }

        for (int i = 0; i < DECK_SIZE; i++) {

            if (i % 2 == 0) {

                cards[i] = deckhalf2[i / 2];

            } else {

                cards[i] = deckhalf1[Math.floorDiv(i, 2)];

            }

        }

    }

    private void outshuffle() {

        /** I wanted to make the method of generating and populating two half-decks its own
         * function, but that would require returning two values, which required use of an
         * ArrayList, which was disallowed for this assignment
         */
        String[] deckhalf1 = new String[DECK_SIZE / 2];
        String[] deckhalf2 = new String[DECK_SIZE / 2];

        for (int i = 0; i < DECK_SIZE / 2; i++) {

            deckhalf1[i] = cards[i];
            deckhalf2[i] = cards[i + (DECK_SIZE / 2)];

        }

        for (int i = 0; i < DECK_SIZE; i++) {

            if (i % 2 == 0) {

                cards[i] = deckhalf1[i / 2];

            } else {

                cards[i] = deckhalf2[Math.floorDiv(i, 2)];

            }

        }

    }

}
