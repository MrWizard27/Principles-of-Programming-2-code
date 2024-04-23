//This code was made by Michael Plafcan(Section 1) on 4/16/23
public class Deck extends CardCollection{
    //Deck constructor
    public Deck(String label){
        //give the deck class all the methods from card collection
        super(label);
        //goes through all the suits
        for (int suit = 0; suit <= 3; suit++){
            //goes through all the ranks for each suit
            for (int rank = 1; rank <= 13; rank++){
                //adds the card with the rank and suit it's on to the deck
                addCard(new Card(rank, suit));
            }
        }
    }
}