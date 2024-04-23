//this code was made by Michael Plafcan in Section 01 on 3/26/2023
import java.util.Random;
public class Deck{
    //creates random object
    private static Random random = new Random();
    //creates cards object
    private Card[] cards;
    
    public Deck(int n){
        //creates a deck with the amount of cards you want
        this.cards = new Card[n];
    }

    public Deck() {
        //creates a standard 52 card deck
        this.cards = new Card[52];
        //goes through each card in the deck and assigns a value to each one
        int index = 0;
        //goes through each suit assigning them to all 13 ranks
        for(int suit = 0; suit <= 3; suit++) {
            //goes through every rank
            for(int rank = 1; rank <= 13; rank++) {
                //assigns the card at index with the rank and suit the nested for loop is on
                this.cards[index] = new Card(rank, suit);
                //adds 1 to index
                index++;
            }
        }
    }

    public void print() {
        //prints every card in cards
        for (Card card : this.cards){
            System.out.println(card);
        }
    }

    public void printCard(int x){
        //prints a specified card in the deck
        System.out.print(this.cards[x]);
    }

    public static int seqSearch(Card[] cards, Card target){
        // for loop that goes through the deck
        for (int x = 0;x<cards.length;x++){
            //if the card it's on is the same as the target then it returns its place in the deck
            if (cards[x].equals(target)){
                return x;
            }
        }
        //returns -1 if it can't find the target
        return -1;
    }

    public static int BinSearch(Card[] cards, Card target){
        //Lowest point being searched
        int low = 0;
        //Highest point being searched
        int high = cards.length - 1;
        //Middle point of the area being searched
        int mid = 0;
        //loop continues until area has been fully searched
        while (low <= high){
            //changes the middle of the search area after every loop to median of the high and low point
            mid = (low + high) / 2;
            //checks to see if the mid point is behind, in front of, or at the position of the target Card
            int posit = cards[mid].compareTo(target);
            //if mid position is where the target is, then posit will be 0 and this will return the place of the card
            if (posit==0){
                return mid;
                //if mid position is behind the target card, it eliminates the search area lower than current mid as posit has proved the target cannot be there
            }else if (posit < 0){
                //sets low to the current mid point
                low = mid + 1;
            }else{
                //if the position is higher than the current mid point than it eliminates the higher area and sets high to the current mid point
                //the -1 stops the loop from getting stuck
                high = mid - 1;
            }
        }
        return 0;
    }

    public void shuffle(){
        //goes through each card in the deck
        for (int i = 0; i < cards.length; i++){
            //picks a random card
            int Randsum = randomInt(i,cards.length - 1);
            //swaps the card it's on and the random card in the deck
            swapCards(i, Randsum);
        }

    }
    private static int randomInt(int low, int high) {
        //picks a random number between a low point(the card shuffle method is on) and a high point(end of the deck)
        int randNum = random.nextInt(high - low + 1) + low;
        //returns the random number to whatever method called this method
        return randNum;

    }
    private void swapCards(int i, int j) {
        //creates a temporary holding card that holds the card at i
        Card temp = cards[i];
        //gives card i, the value of card j
        cards [i] = cards[j];
        //uses the temp holder to give j the value of i
        cards[j] = temp;

    }
    public void SelectionSort(){
        int min;

        for (int i = 0; i < cards.length-1;i++){
            min = i;

            for (int x = i + 1; x <cards.length;x++){
                if (cards[x].compareTo(cards[min])<0){
                    min = x;
                }
                swapCards(i,min);
            }
        }
    }

}