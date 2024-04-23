public class Card{
    private int Suit;
    private int Rank;

    public Card(int Rank, int Suit){
        this.Suit = Suit;
        this.Rank = Rank;

    }

    public String toString(){
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {null, "Ace", "2","3","4","5","6","7","8","9","10","Jack","Queen","King",};
        return "Your card is the " + ranks[this.Rank] + " of " + suits[this.Suit];
    }


}