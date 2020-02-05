import java.util.ArrayList;
import java.util.Collections;

/**
 * Each Deck object models a deck of cards. Either the games deck, players deck etc.
 */
public class Deck {
    /** represents a deck of cards */
    private ArrayList<Card> deck ;
    /** default constructor creating an empty array */
    public Deck(){
        deck = new ArrayList<>();
    }

    /**
     * Method creates a deck of cards.
     * @param h heart suit of card.
     * @param d diamond suit of card.
     * @param s spade suit of card.
     * @param c club suit of card.
     */
    public Deck(String h, String d, String s, String c){
        deck = new ArrayList<>();

        for ( int i = 2; i < 15; i++){
            deck.add(new Card(h, i) );
            deck.add(new Card(d, i) );
            deck.add(new Card(s, i) );
            deck.add(new Card(c, i) );
        }
    }

    /**
     * Method shuffles the cards.
     */
    public void shuffle(){
        Collections.shuffle(deck);
    }

    /**
     * Method deals the top card while removing is from the deck.
     * @return returns back the top card if there is one, null if not.
     */
    public Card dealTopCard(){
        if(deck.isEmpty()){
            return null;
        }
        else{
            return deck.remove(0);
        }
    }

    /**
     * Method adds cards to the deck.
     * @param c the card being added to the deck.
     */
    public void add(Card c){
        deck.add(c);
    }

    /**
     * Method checks if the deck is empty.
     * @return true if it is empty, false if it isn't.
     */
    public Boolean isEmpty(){
        return deck.isEmpty();
    }

    /**
     * Method gets the size of the deck.
     * @return the size of the deck.
     */
    public int size(){
        return deck.size();
    }

    /**
     * This method gets the first card of the deck without removing.
     * @return returns the top card in the deck.
     */
    public Card get(){
        return deck.get(0);
    }

    /**
     * This method creates a string of the deck of cards.
     * @return string of the deck of cards with its rank and suit.
     */
    public String toString(){
        String deckString = "";
        for( Card c : deck ){
            deckString = deckString + c + ", ";
        }
        return "Deck: " + deckString;


    }

}
