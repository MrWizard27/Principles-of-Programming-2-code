//this code was made by Michael Plafcan(Section 1) on 4/4/2023
public class CardPractice3{
    public static void main(String[] args){
        //creates two new deck objects
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();

        //shuffles the two deck objects
        deck1.shuffle();
        deck2.shuffle();

        //prints the first deck
        System.out.println("\nDeck 1:");
        deck1.print();
        //prints the second deck
        System.out.println("\nDeck 2:");
        deck2.print();
        System.out.println();

        //creates two subdecks using the first 5 cards in each deck
        Deck Hand1 = deck1.subdeck(0,4);
        Deck Hand2 = deck2.subdeck(0,4);

        //Prints the subdecks
        System.out.println("Hand 1:");
        Hand1.print();
        System.out.println("\nHand 2:");
        Hand2.print();

        //creates current card objects
        System.out.println();
        Card Hand1Current;
        Card Hand2Current;

        //takes the first card from the first subdeck and compares it to every card in the second subdeck, then moves on to the next card trying to find matches
        
        //goes through the first subdeck
        for (int count = 0; count < Hand1.length(); count++){
            //gives current hand 1 card the card the first for loop is on
            Hand1Current = Hand1.getCard(count);
            //goes through the second subdeck
            for (int count2 = 0; count2 < Hand2.length(); count2++){
                //gives hand 2 card the card the second loop is on
                Hand2Current = Hand2.getCard(count2);
                //compares the current first hand card and the current second hand card
                if (Hand1Current.compareTo(Hand2Current) == 0){
                    //if they are the same card, it says match and tell you where the cards are and what their suit and rank is
                    System.out.println("Match!");
                    System.out.println("Match found at index: " + count + " in Hand 1 and index: " + count2 + " in Hand 2");
                    System.out.println("The Matching Cards are the " + Hand2Current);
                }
            }
        }

    }
}