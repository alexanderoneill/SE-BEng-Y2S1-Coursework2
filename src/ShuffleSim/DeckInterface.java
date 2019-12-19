/**
 * @author B00758943
 */

package ShuffleSim;

public interface DeckInterface {

    /** Show
     * @return String of array contents */ 
    public String show();

    /** Reveal
     * @return String containing card number and suit */
    public String reveal();

    /** Find
     * @param cardtofind containing card number and suit, in the format NS
     * @return int of position of specified card */
    public int find(String cardtofind);

    /** Card Force
     * @param position desired final position of top card after Card Force */
    public void cardforce(int position);

    /** Shuffle */
    public void shuffle();

}
