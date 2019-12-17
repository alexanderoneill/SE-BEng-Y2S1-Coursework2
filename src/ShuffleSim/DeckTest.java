/**
 * @author B00758943
 */

package ShuffleSim;

import java.util.Scanner;

public class DeckTest {

    public static void main(String[] args) {

        // Things regarding input
        Scanner input;
        input = new Scanner(System.in);
        boolean valid = false;
        String position = new String();

        String topcard;

        System.out.println("-----SHUFFLE SIM TEST-----");

        // Create deck instance
        Deck testdeck = new Deck();
        if (testdeck != null) { // Check to see if instantiation was successful

            System.out.println("\n\nDeck instance successfully created.");

        }

        // Show initial state of deck
        System.out.println("\nInitial state of deck:");
        System.out.println(testdeck.show());

        // Randomly shuffle deck
        testdeck.shuffle();
        
        // Show state of deck after shuffle
        System.out.println("\nDeck after first shuffle:");
        System.out.println(testdeck.show());

        // Reveal top card
        System.out.println("\nTop card of deck:");
        topcard = testdeck.reveal();
        System.out.println(topcard);

        // Card Force
        /** Seeing as how this is the only instance of user input in DeckTest, it's also the only instance of
         * input validation, just checks if character user enters is numerical or not. Could have used
         * Apache Commons' StringUtils or NumberUtils, but 3rd party libraries were disallowed*/
        while (valid == false) {

            System.out.println("\nEnter desired final position for Card Force: ");
            position = input.nextLine();

            if (Character.isDigit(position.charAt(0))) {

                valid = true;

            }

        }

        testdeck.cardforce(Integer.parseInt(position));


        // Show deck after Card Force
        System.out.println("\nDeck after Card Force.");
        System.out.println(testdeck.show());

        // Find previous top card
        System.out.println("Top card is now in position " + testdeck.find(topcard));

    }

}