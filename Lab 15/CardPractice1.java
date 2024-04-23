//This code was made by Michael Plafan(Section 1) on 4/4/2023
//imports random object
import java.util.Random;
public class CardPractice1{
    public static void main(String[] args){
        //creates random object
        Random random = new Random();
        //creates deck object
        Deck deck = new Deck();
        //shuffles deck
        deck.shuffle();
        //prints deck
        deck.print();
        //adds space
        System.out.println();
        //picks 2 random cards from the deck
        Card firstrand = deck.getCard(random.nextInt(52));
        Card secondrand = deck.getCard(random.nextInt(52));
        //prints out both random cards
        System.out.println("Card One: " + firstrand + "\n");
        System.out.println("Card Two: " + secondrand + "\n");
        //if the first card compared to the second is greater, then it prints out that the first card is the highest card
        if (firstrand.compareTo(secondrand) > 0){
            System.out.println(firstrand + " is the higher card\n");
            //if the first card compared to the second is lesser, then it prints out that the second card is the highest card
        }else if (firstrand.compareTo(secondrand) < 0){
            System.out.println(secondrand + " is the higher card\n");
            //if the compareTo methods gives a 0 then it prints out both cards are the same
        }else{
            System.out.println("Both cards are the same");
        }

    }
}