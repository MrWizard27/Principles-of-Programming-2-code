//This code was made by Michael Plafcan(Section 1) on 4/16/23 
public class Hand extends CardCollection{
    
    public Hand(String label){
        //gives all the method in CardCollection to Hand
        super(label);
    }

    //displays the Hand
    public void display(){
        //says who's hand it is
        System.out.println(getLabel() + ": ");
        //goes through the hand
        for (int i = 0; i < size(); i++){
            //prints the card
            System.out.println(getCard(i));
        }
        //new line
        System.out.println();
    }

    //displays the hand but numbered to help players choose a card
    public void numberedisplay(){
        //goes through the hand
        for (int i = 0; i < size(); i++){
            //prints the number of the card it's on (+1 so it doesn't start with 0) and then the card
            System.out.println((i + 1) + ". " + getCard(i));
        }
        //new line
        System.out.println();
    }

}