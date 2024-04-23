public class CardPractice2{
    public static void main(String[] args){
        Deck deck = new Deck();
        
        deck.shuffle();

        deck.print();

        Deck HandTheta = deck.subdeck(0,4);
        Deck HandOmega = deck.subdeck(5,9);

        

        System.out.println("\nTheta Hand \u0398");
        System.out.println("Value: " + handsum(HandTheta));
        System.out.println("-------------");
        HandTheta.print();
        System.out.println("\nOmega Hand \u03A9:");
        System.out.println("Value: " + handsum(HandOmega));
        System.out.println("-------------");  
        HandOmega.print();

        if (handsum(HandTheta) > handsum(HandOmega)){
            System.out.println("\nTheta Hand \u0398 has a higher value than Omega Hand \u03A9");
        }else if (handsum(HandTheta) < handsum(HandOmega)){
            System.out.println("\nOmega Hand \u03A9 has a higher value than Theta Hand \u0398");
        }

    }
    public static int handsum(Deck cards){
        int sum = 0;
        for (int x = 0; x < cards.length(); x++){
            sum += cards.getCard(0).getRank();
        }
        return sum;
    }
}
