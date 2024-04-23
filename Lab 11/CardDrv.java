import java.util.Random;
public class CardDrv{
    public static int seqSearch(Card[] deck, Card target){
        // for loop that goes through the deck
        for (int x = 0;x<deck.length;x++){
            //if the card it's on is the same as the target then it returns its place in the deck
            if (deck[x].equals(target)){
                return x;
            }
        }
        //returns -1 if it can't find the target
        return -1;
    }
    public static int BinSearch(Card[] deck, Card target){
        //Lowest point being searched
        int low = 0;
        //Highest point being searched
        int high = deck.length - 1;
        //Middle point of the area being searched
        int mid = 0;
        //loop continues until area has been fully searched
        while (low <= high){
            //changes the middle of the search area after every loop to median of the high and low point
            mid = (low + high) / 2;
            //checks to see if the mid point is behind, in front of, or at the position of the target Card
            int posit = deck[mid].compareTo(target);
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
    public static void printDeck(Card[] deck){
        //for loop that goes through the deck, printing every card
        for (int x = 0; x<deck.length;x++){
            System.out.println(deck[x]);
        }
    }
    public static Card[] makeDeck(){
            //creates a new card array called deck holding 52 card objects

        Card[] deck = new Card[52];
    //Suit Number
    int Snumber = 0;
    //Rank Number
    int Rnumber = 1;
    //goes through the deck
    for (int x = 0;x<deck.length;x++){
        //initializes the card it is on in deck with R nubmer and Snumber
        deck[x] = new Card(Rnumber,Snumber);
        //if its gone through all the ranks, it moves on to the next suit and sets rank back to 0
        if (Rnumber == 13){
            Snumber++;
            Rnumber = 0;
        }
        //this is a failsafe, if suit goes higher than 3, the loop ends cause there is only suit 0,1,2, and 3
        if (Snumber > 3){
            break;
        }
        //after it does all those checks it moves on to the next rank
        Rnumber++;
    }
    return deck;
    }
    public static void main(String[] args){
    //creates a new random object
    Random randomNumber = new Random();
    //
    Card[] deck = makeDeck();
    //creates 2 random numbers
    int RNumber1 = randomNumber.nextInt(52);
    int RNumber2 = randomNumber.nextInt(52);
    //prints out the deck
     printDeck(deck);
    //finds those cards at random number in deck
    System.out.println("\n" + deck[RNumber1] + "\n" + deck[RNumber2]);
    //compares the two random cards
    System.out.println(deck[RNumber1].compareTo(deck[RNumber2]));
    //Searches the deck for the place of the first random card
    System.out.println("Deck Place: " + seqSearch(deck, deck[RNumber1]));
    //Searches the deck for the place of the Second random card
    System.out.println("Deck Place: " + BinSearch(deck, deck[RNumber2]));
    } 
}

