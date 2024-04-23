//This code was made by Michael Plafcan(Section 1) on 4/16/23 
import java.util.Scanner;
public class Player{
    //instance variables 
    private String name;
    private Hand hand;
    private Scanner in = new Scanner(System.in);

    //constructor
    public Player(String name){
        //decares name variable
        this.name = name;
        //declares hand variable
        this.hand = new Hand(name);
    }

    //returns the name of the player
    public String getName(){
        return this.name;
    }

    //returns the hand of the player
    public Hand getHand(){
        return this.hand;
    }

    //displays the hand
    public void display(){
        this.hand.display();

    }

    //displays the hand but numbered to help the player choose a card
    public void numberedisplay(){
        this.hand.numberedisplay();
    }

    //displays the score of the player
    public void displayScore(){
        //prints out the name of the player and how many cards they had
        System.out.println(this.name + "'s Score: " + this.hand.size());
    }
    //plays the game automatically
    public Card play(Eights eights, Card prev){
        //searches for a match and sets card to the matching card
        Card card = searchForMatch(prev);
        //if there is not matching card it draws for a match and sets card to that
    if (card == null) {
        card = drawForMatch(eights, prev);
    }
    //returns the matching card
    return card;
    }
     
    //lets the player have choice in whether they draw or play
    public Card playChoice(Eights eights, Card prev){
        //prints out the player's name
        System.out.println("\nPlayer " + this.name);
        //asks them if they want to draw or play
        System.out.println("Draw until you get a card or Play?");

        //sets card to search the deck for a match, if there is no match it sets card to null
        Card card = searchForMatch(prev);

        //sets a loop variable to true
        Boolean loop = true;
        //while loop that runs if loop is true
        while(loop == true){
        //sets loop to false so it only runs once unless an if statement wants it to run again
        loop = false;

          //sets action variable to the input the player types
          String action = in.nextLine();
            
            //checks if action = draw (capitalized and uncapitilized)
            if (action.equals("Draw") || action.equals("draw")){
                //if it does then it draws for match and sets card to the matching card
                card = drawForMatch(eights, prev);
            //checks if action = play (capitalized and uncapitalized)
            }else if (action.equals("Play") || action.equals("play")){

                if (card == null){
                    //if card is null that means there are not matching cards, so it prints out that there are no cards that can be played
                    System.out.println("You don't have any cards you can Play, choose to draw");
                    //sets loop to true so it loops one more time
                    loop = true;
                    //runs if there is a card you can play
                }else {
                    //start of new loop that only loops if an if statement is set off
                    Boolean loop2 = true;
                    while(loop2 == true){
                        loop2 = false;
                        //prints out deck:
                        System.out.println("Deck:");
                        //prints out the players hand numbered
                        numberedisplay();
                        //prints out the top card
                        System.out.println("Top Card: " + "\n" + prev);
                        //asks you to input which card you want to play
                        System.out.println("\nPlease input the number of the card you want to play");
                        //gets whatever you type (minus 1 because of the numbered list is + 1 so there is no 0)
                        int cardplayed = in.nextInt()-1;
                        //makes card = the card you picked
                        card = this.hand.getCard(cardplayed);
                        //checks if it matches
                        if (cardMatches(card, prev)){
                            //if it matches that the end of the method and it removes and returns the card you played
                            return hand.popCard(cardplayed);
                            //if it doesn't match
                        }else{
                            //says that it doesn't match
                            System.out.println("That card does not match the center card, Please Pick a different Card");
                            //gets it to loop one more time
                            loop2 = true;
                        }
                    }
                }
            //if action does not equal play or draw this makes it loop one more time
            }else {
                loop = true;
            }
        }
        
        //returns card (used for drawing)
        return card; 
    }

    //searches for a match
    public Card searchForMatch(Card prev){
        //goes through your hand
        for (int i = 0; i< hand.size(); i++){
            //sets card to current card in hand
            Card card = hand.getCard(i);
            //checks if the card matches the card in play
            if (cardMatches(card, prev)){
                //if it matches it returns the card
                //** change this to a comment if you want to change to a less interactive version of the game
                return hand.getCard(i);
                //*** uncomment this if you want to change to a less interactive version of the game
                //return hand.popCard(i);
            }
        }
        //returns null if there's no match
        return null;
    }

    //draws until it find a match
    public Card drawForMatch(Eights eights, Card prev){
        //loop that runs until the program is ended
        while (true){
            //draws a card and sets card as it
            Card card = eights.drawCard();
            //prints out that the current player draws that card
            System.out.println(name + " draws " + card);
            //if the card matches it returns that card and ends this method
            if (cardMatches(card, prev)){
                return card;
            }
            //if not it adds it to the players hand and starts the loop over
            hand.addCard(card);
        }
    }
    //checks if the card matches
    public static boolean cardMatches(Card card1, Card card2){
        //returns true if the suits match or the ranks match or if card 1 is an 8 as 8's are wild
        return card1.getSuit() == card2.getSuit() || card1.getRank() == card2.getRank() || card1.getRank() == 8;
    }
}