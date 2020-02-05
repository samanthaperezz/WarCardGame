/**
 * This is a card game of war for two players. The game consist of card games and decks.
 * @author Samantha Perez and Rey Suarez.
 * Due: February 4, 2020.
 */

import java.util.Scanner;

public class Game {

    public static void main( String[] args ){

        Scanner in = new Scanner(System.in);
        /** creating needed decks for the game */
        Deck playerOne = new Deck();
        Deck playerTwo = new Deck();
        Deck  pile = new Deck();
        Deck deckOfCards = new Deck("Hearts", "Diamonds", "Spades","Clubs");
        deckOfCards.shuffle();

        /** adding an even amount of cards to each players deck */
       for( int i = 0 ; i < 26 ; i++){
           playerOne.add(deckOfCards.dealTopCard());
           playerTwo.add(deckOfCards.dealTopCard());
       }

       /** game will continue until one of the players have an empty deck */
       while( playerOne.isEmpty() == false && playerTwo.isEmpty() == false){

            /** getting the rank of the first cards */
           int playerOneRank = playerOne.get().getRank();
           int playerTwoRank = playerTwo.get().getRank();
            /** adding card to table pile */
           pile.add(playerOne.get());
           pile.add(playerTwo.get());

           System.out.println("Player 1 plays " + playerOne.dealTopCard());
           System.out.println("Player 2 plays " + playerTwo.dealTopCard());

           /** if players draw the same card ranks they will go to war */
           while( playerOneRank == playerTwoRank && !pile.isEmpty()){

               /** before continuing with the war we must first see if each
                * player has enough cards for war. if not the one with the most
                * cards win. */
               if(playerOne.size() < 5 && playerOne.size()!=4){
                   System.out.println("Player one does not have enough cards for war.");
                   System.out.println("Player two has won the game!\nGAME OVER");
                   System.exit(1);
               }
               else if( playerTwo.size() < 5 && playerTwo.size()!=4 ){
                   System.out.println("Player two does not have enough cards for war.");
                   System.out.println("Player one has won the game\nGAME OVER!");
                   System.exit(1);
               }



               System.out.println("War!");
               /** adding three cards to the table pile*/
               for( int i = 0; i < 3; i++){
                   pile.add(playerOne.dealTopCard());
                   pile.add(playerTwo.dealTopCard());
               }

               /** updating player rank to see if they need to go to war again */

               playerOneRank = playerOne.get().getRank();
               playerTwoRank = playerTwo.get().getRank();

               pile.add(playerOne.get());
               pile.add(playerTwo.get());

               playerOneRank = playerOne.get().getRank();
               playerTwoRank = playerTwo.get().getRank();

               System.out.println("Player 1 plays " + playerOne.dealTopCard());
               System.out.println("Player 2 plays " + playerTwo.dealTopCard());


           }

            /** if player 1 has bigger rank they win the round, if not player 2 wins */
           if(playerOneRank > playerTwoRank){

               System.out.println("Player 1 wins the round " );


               /** adding to the winner pile*/
               int size = pile.size();
               for(int i = 0 ; i < size; i++){
                   playerOne.add(pile.dealTopCard());
               }
               System.out.println("player 1 deck size is now " + playerOne.size());
               System.out.println("player 2 deck size is now " + playerTwo.size());
               System.out.println();


           }
           else if(playerOneRank < playerTwoRank){

               System.out.println("Player 2 wins the round " );
               /** adding to the winner pile*/
               int size = pile.size();
               for(int i = 0 ; i < size; i++){
                   playerTwo.add(pile.dealTopCard());
               }
               System.out.println("player 1 deck size is now " + playerOne.size());
               System.out.println("player 2 deck size is now " + playerTwo.size());
               System.out.println();

           }

       }
       /** if either has an empty dec, they lose the game */
        if( playerOne.size() == 0 ){
            System.out.println("Player two has won the game!!\nGAME OVER");
        }
        else if ( playerTwo.size() == 0) {
            System.out.println("Player one has won the game!!\nGAME OVER");

        }
    }

}
