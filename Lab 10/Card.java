public class Card{
    //class variables
    public static final String[] RANKS = {null, "Ace", "2","3","4","5","6","7","8","9","10","Jack","Queen","King",};
    public static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
    //instance variables
    private int Suit;
    private int Rank;
    //value constructor
    public Card(int Rank, int Suit){
        this.Suit = Suit;
        this.Rank = Rank;

    }
    //uses the class variables to return a string
    public String toString(){
        return "Your card is the " + RANKS[this.Rank] + " of " + SUITS[this.Suit];
    }
    //compares suits then if the suits are the same, compares the ranks
    public int compareTo(Card that){
        if (this.Suit < that.Suit){
            return -1;
        }
        if (this.Suit > that.Suit){
            return 1;
        }
        if (this.Rank < that.Rank){
            return -1;
        }
        if (this.Rank > that.Rank){
            return 1;
        }
        return 0;
    }

}