//This code was made by Michael Plafcan(Section 1) on 4/13/23 
//imports java utils
import java.util.ArrayList;
import java.util.Random;
//creates Card Collection Class
public class CardCollection {
    //instance variables
    private String label;
    private ArrayList<Card> cards;
    //constructor - gets values for label and declares the arraylist object
    public CardCollection(String label){
        this.label = label;
        this.cards = new ArrayList<Card>();
    }
    //adds the card specifies to the arraylist object
    public void addCard(Card card){
        cards.add(card);
    }
    //removes the card from the arraylist and returns the card it removed
    public Card popCard(int i) {
        return cards.remove(i);
    } 
    //removes and returns the bottom card in cards
    public Card popCard(){
        int i = cards.size() - 1;
        return popCard(0);
    }
    //checks if cards is empty
    public boolean isEmpty(){
        return cards.isEmpty();
    } 
    //gets the size of the cards arraylist
    public int size(){
        return cards.size();
    } 
    //get the card at i in cards
    public Card getCard(int i){
        return cards.get(i);
    }
    //returns the name of the Card collection
    public String getLabel(){
        return label;
    }
    //return the bottom card and doesn't remove it
    public Card lastCard(){
        int i = cards.size() - 1;
        return cards.get(i);
    }
    //swaps card i and j
    public void swapCards(int i, int j){
        //save the value of card i 
        Card temp = cards.get(i);
        //sets the value of card i at card j
        cards.set(i, cards.get(j));
        //sets the value of card jay at the save value of i
        cards.set(j, temp);
    }
    //shuffles the deck
    public void shuffle(){
        Random random = new Random();
        //goes through each card in the deck
        for (int i = cards.size() - 1; i > 0; i--){
            //picks a random card
            int Randsum = random.nextInt(i + 1);
            //swaps the card it's on and the random card in the deck
            swapCards(i, Randsum);
        }

    }
    //deals out cards
    public void deal(CardCollection that, int n){
        //loops for n looops
        for (int i = 0; i < n; i++){
            //removes a card from this collection and adds it to that collection
            Card card = popCard();
            that.addCard(card);
        }
    }
    //deals all cards
    public void dealAll(CardCollection that){
        //gets the size of the array list
        int n = cards.size();
        //adds every card in the array list to that collection
        deal(that,n);
    }
}