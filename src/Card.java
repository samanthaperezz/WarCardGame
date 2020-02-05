/**
 * Each Card object models a single cards of the deck.
 */
public class Card {
    /** string represents the suit of the card */
    private String suit;
     /** represents the rank of the card */
    private int rank;

    /**
     * Default constructor.
     */
    public Card(){
        suit = "";
        rank = 0 ;

    }

    /**
     * Overloaded constructor- initializes the suit and rank
     * @param s the cards suit.
     * @param r the cards rank.
     */
    public Card(String s, int r){
        suit = s;
        rank = r;
    }

    /**
     * This function returns back the proper string of the card.
     * @return a string that describes the card.
     */
    public String toString(){
        if( rank == 11){
            return "card is Jack of " + suit ;
        }
        else if( rank == 12){
            return "card is Queen of " + suit ;
        }
        else if( rank == 13){
            return "card is King of " + suit ;
        }
        else if( rank == 14){
            return "card is Ace of " + suit ;
        }
        else{
            return "card is " + rank + " of "+ suit ;
        }
    }

    /**
     * This function gets the rank of the card/
     * @return the rank of the card.
     */
    public int getRank(){
        return rank;
    }



}
