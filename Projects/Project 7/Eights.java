//This code was made by Michael Plafcan(Section 1) on 4/16/23 
import java.util.Scanner;
public class Eights {
    //instance variables
    private Deck deck;
    private Player one;
    private Player two;
    private Hand drawPile;
    private Hand discardPile;
    private Scanner in = new Scanner(System.in);

    //constructor
    public Eights(){
        //declares the deck object
        this.deck = new Deck("Deck");
        //shuffles the deck
        deck.shuffle();
        //asks player one what they want their name to be
        System.out.println("Player one, what is your name?");
        this.one = new Player(in.nextLine());
        //asks player two what they want their name to be
        System.out.println("Player two, what is your name?");
        this.two = new Player(in.nextLine());
        //adds 5 cards from the deck to each players hand
        for (int x = 0; x < 5; x++){
            one.getHand().addCard(deck.popCard());
            two.getHand().addCard(deck.popCard());
        }
        //declares the drawpile hand
        this.drawPile = new Hand("Draw Pile");
        //declares the discardpile hand
        this.discardPile = new Hand("Discard Pile");

        //transfers the rest of the deck to the drawpile
        while(deck.size()!=0){
            drawPile.addCard(deck.popCard());
        }
        //adds a card to the discard pile (this is the card in play)
        this.discardPile.addCard(drawPile.popCard());
    }

    //checks if either hand is empty
    public boolean isDone(){
        return one.getHand().isEmpty() || two.getHand().isEmpty();
    }

    //if them drawpile is empty, this puts all cards not in play in the discard pile, back into the drawpile, then shuffles it
    public void reshuffle(){
        //separates the card in play
        Card prev = discardPile.popCard();
        //moves all cards in the discard pile to the draw pile
        discardPile.dealAll(drawPile);
        //adds the card in play back to the discard pile
        discardPile.addCard(prev);
        //shuffles the draw pile
        drawPile.shuffle();
    }

    //draws a card
    public Card drawCard(){
        //checks if drawpile is empty
        if (drawPile.isEmpty()){ 
            //if drawpile is empty it reshuffles 
            reshuffle();
        }
        //takes a card from drawpile and returns it
        return drawPile.popCard();
    }

    //changes to the next player  
    public Player nextPlayer(Player current){
        //checks if the current player is the first player
        if (current == one){
            //if yes then it changes to player 2
            return two;
            //if not player 1
        } else { 
            //then changes to player 1
            return one;
        }
    }
    //displays the state of the game
    public void displayState(){
        //displays player 1
        one.display();
        //displays player 2
        two.display();
        //displays the discard pile
        discardPile.display();
        //prints "draw pile"
        System.out.println("Draw pile:");
        //prints out the number of cards left in the draw pile
        System.out.println(drawPile.size() + " cards");
        //*** change this out of comment and others marked with 3 stars if you want to play the game in a less interactable version
       // in.nextLine(); 
    }
    //takes a players turn
    public void takeTurn(Player player){
        //gets the last card in the discard pile (this is the card in play)
        Card prev = discardPile.lastCard();

        //** change this into a comment and others marked with 2 stars if you want to play the game in a less interactable version
        //starts the play and sets the value of next as what card they played
        Card next = player.playChoice(this, prev);

        //*** change this out of comment and others marked with 3 stars if you want to play the game in a less interactable version
        //Card next = player.play(this, prev);

        discardPile.addCard(next);
        
        //says which card the player played
        System.out.println(player.getName() + " plays " + next);
        //new line
        System.out.println();
    }

    //plays the game
    public void playGame(){
        //starts with player 1
        Player player = this.one;
        
        //goes through the game until one of the player's hand is empty
        while(!isDone()){
            //displays the state of the game
            displayState();
            //takes the players turn
            takeTurn(player);
            //switches to the next player
            player = nextPlayer(player);
        }
        //displays the amount of cards player one had
        one.displayScore();
        //displays the amount of cards player two had
        two.displayScore();
    }
}
