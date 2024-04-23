//This code was made by Michael Plafcan(Section 01) on 4/12/23
public class WarDrv{
    public static void main(String[] args){
        //Creates a new deck object called deck
        Deck deck = new Deck();
        //shuffles deck object
        deck.shuffle();
        //creates a new Pile object called p1
        Pile p1 = new Pile();
        //gives half the deck to the first pile
        p1.addDeck(deck.subdeck(0,25));
        //creates a second pile called p2
        Pile p2 = new Pile();
        //gives the other half of the deck to the second pile
        p2.addDeck(deck.subdeck(26,51));

        //creates a pile called tiehold for later use in a tie
        Pile tiehold = new Pile();
        //creates an integer variable for later use in the tie loop
        int continloop = 0;

        //creates 2 card variables to hold the cards in play
        Card c1;
        Card c2;
        //loop that runs until one of the piles is empty (or a command ends it like system.exit(0))
        while (!p1.isEmpty() && !p2.isEmpty()) {
            //tells you how many cards are in each players piles
            System.out.println("Player 1 has " + p1.length() + " cards");
            System.out.println("Player 2 has " + p2.length() + " cards");
            //sets the card variables and removed the top card in a players pile
            c1 = p1.popCard();
            c2 = p2.popCard();
            //tells you what cards the players are playing
            System.out.println("Player 1 plays: " + c1);
            System.out.println("Player 2 plays: " + c2);
            //checks which card has a higher rank
            int diff = c1.getRank() - c2.getRank();
        //if player 1 card is higher
        if (diff > 0) {
            //adds both cards that were in play into player 1's pile
            p1.addCard(c1);
            p1.addCard(c2);
            //lets you know who had the highest card
            System.out.println("Player 1 Has the higher card");
        //if player 1 card is lower
        } else if (diff < 0) {
            //adds both cards that were in play into player 2's pile
            p2.addCard(c1);
            p2.addCard(c2);
            //lets you know who had the highest card
            System.out.println("Player 2 Has the higher card");
        } else {
            while(continloop == 0){
                //says tie breaker
            System.out.println("TieBreaker!") ; 
            //sets continloop to 1 so the loop ends unless there is a tie in the tie  
            continloop = 1;
            //if one the piles doesn't have a minimum of 4 cards then the other player wins and the game ends
        if (p2.length() <= 4){
            System.out.println("Player 1 wins!");
            System.exit(0);
        }
        if (p1.length() <= 4){
            System.out.println("Player 2 wins!");
            System.exit(0);
        }
        //loop that adds 3 cards from each player pile(runs for 3 loops)
        for (int x = 0; x < 4; x++){
            //adds the top card from both player piles to tiehold
            tiehold.addCard(p1.popCard());
            tiehold.addCard(p2.popCard());
        }
            //adds the current tie cards to the tiehold pile
            tiehold.addCard(c1);
            tiehold.addCard(c2);
            //gets the cards in play
            c1 = p1.popCard();
            c2 = p2.popCard();

        //gets which card rank is higher
        diff = c1.getRank() - c2.getRank();
        //tells you how many cards each player has and what cards are in play
        System.out.println("Player 1 has " + p1.length() + " cards");
        System.out.println("Player 2 has " + p2.length() + " cards");
        System.out.println("Player 1 plays: " + c1);
        System.out.println("Player 2 plays: " + c2);
        //if player 1 has a higher card
        if (diff > 0) {
            //adds the cards in play to player 1's pile
            p1.addCard(c1);
            p1.addCard(c2);
            //adds the other 8 cards in tiehold to player 1's pile
            for (int n = 0; n <= 8; n++){
                p1.addCard(tiehold.popCard());
            }
            //tells you player 1 had the higher card
            System.out.println("Player 1 Has the higher card");
        //if player 2 has a higher card
        } else if (diff < 0) {
            //adds the cards in play to player 2's pile
            p2.addCard(c1);
            p2.addCard(c2);
            //adds the other 8 cards in tiehold to player 2's pile
            for (int n = 0; n <= 8; n++){
                p2.addCard(tiehold.popCard());
            }
            //tells you player 2 had the higher card
            System.out.println("Player 2 Has the higher card");
        } else {
            //if neither card is higher than there is another tie and it sets this variable to 0 which starts the loop again
            continloop = 0;
        }
    }
            }
            
        }
        //checks if either pile is empty and if so, it says the other player wins
        if (p2.isEmpty()) {
            System.out.println("Player 1 wins!");
        } else {
            System.out.println("Player 2 wins!");
        }
        
    }
}