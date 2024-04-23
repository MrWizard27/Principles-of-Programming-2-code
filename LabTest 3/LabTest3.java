//This codes was made by Michael Plafcan(Section 1) on 4/6/2023
public class LabTest3{
    public static void main(String[] args){
        //creates new deck object
        Deck deck = new Deck();

        //prints the normal deck
        System.out.println("DECK:");
        deck.print();

        //shuffles the deck
        deck.shuffle();

        //prints out the shuffled deck
        System.out.println("\nSHUFFLED DECK:");
        deck.print();

        //creates two subdecks/hands
        //first five cards
        Deck Hand1 = deck.subdeck(0,4);
        //last five cards
        Deck Hand2 = deck.subdeck(47,51);
        
        //prints the first hand
        System.out.println("\nFIRST HAND:");
        Hand1.print();

        //prints the second hand
        System.out.println("\nSECOND HAND:");
        Hand2.print();

        //initializes variables that'll carry the sum value of the ranks in those hands
        int rankvalueh1 = 0;
        int rankvalueh2 = 0;

        //adds together the ranks in each hand to their corresponding sum holding variable
        for (int x = 0; x < 5; x++){
            //adds the rank value of the x card in hand to rankvalue
            rankvalueh1 += Hand1.getCard(x).getRank();
            rankvalueh2 += Hand2.getCard(x).getRank();
        }

        //Prints each hands rank sum
        System.out.println("\nFIRST HAND RANK VALUE:\n" + rankvalueh1);
        System.out.println("\nSECOND HAND RANK VALUE:\n" + rankvalueh2);

        //finds which hand has the highest rank sum value and prints it
        System.out.println("\nHIGHEST VALUE HAND:");
        if (rankvalueh1 > rankvalueh2){
            System.out.println("First Hand has a higher value");
        } else if(rankvalueh1 < rankvalueh2){
            System.out.println("Second Hand has a higher value");
        }else{
            System.out.println("Values are the same");
        }
        
        //checks for cards that have matching suits, says match found, then says what cards those are
        System.out.print("\nMATCHES:");
        //goes through the first hand
        for (int suit1 = 0; suit1 < 5; suit1++){
            //goes through the second hand
            for (int suit2 = 0; suit2 < 5; suit2++){
                //checks if the card it's on in the first hand has the same suit as the card it's on in the second hand
                if (Hand1.getCard(suit1).getSuit() == Hand2.getCard(suit2).getSuit()){
                    //if it's true then it says match found and prints which cards matched
                    System.out.println("\nMatch found!");
                    //adds one to suit so it doesn't say card 0-4 and instead says card 1-5 to make it easier to read
                    System.out.println("Card " + (suit1 + 1) + " in the First Hand has the same suit as Card " + (suit2 + 1) + " in the Second Hand");
                }
            }
        }
    }
}