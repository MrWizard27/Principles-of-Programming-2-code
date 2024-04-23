import java.util.Random;
public class CardDrv{
    public static void main(String[] args){
    //creates a new random object
    Random randomNumber = new Random();
    //creates a new card array called deck holding 52 card objects
    Card[] Deck = new Card[52];
    //Suit Number
    int Snumber = 0;
    //Rank Number
    int Rnumber = 1;
    //goes through the deck
    for (int x = 0;x<Deck.length;x++){
        //initializes the card it is on in deck with R nubmer and Snumber
        Deck[x] = new Card(Rnumber,Snumber);
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
    //creates 2 random numbers
    int RNumber1 = randomNumber.nextInt(52);
    int RNumber2 = randomNumber.nextInt(52);
    //finds those cards at random number in deck
    System.out.println(Deck[RNumber1] + "\n" + Deck[RNumber2]);
    //compares the two random cards
    System.out.println(Deck[RNumber1].compareTo(Deck[RNumber2]));
    
    } 
}
