import java.util.Scanner;
public class Sandwhich{
  public static Double price(String Ingredient){
    //This method is a switch statement that sets the ingredient price to whatever ingredient is given in the parameter
double IngPrice ;
  switch(Ingredient){
    case "Turkey":
    case "turkey":
    IngPrice = 1.55 ;
    break;
    case "Lettuce":
    case "lettuce":
    IngPrice = .55 ;
    break;
    case "Avocado":
    case "avocado":
    IngPrice = 1.25 ;
    break;
    case "Tuna":
    case "tuna":
    IngPrice = 1.78 ;
    break;
    case "Peppers":
    case "peppers":
    IngPrice = .50 ;
    break;
    case "Ham":
    case "ham":
    IngPrice = 1.45 ;
    break;
    case "Mayo":
    case "mayo":
    IngPrice = .25 ;
    break;
    case "Pickles":
    case "pickles":
    IngPrice = .50 ;
    break;
    case "Sprouts":
    case "sprouts":
    IngPrice = .45 ;
    break;
    case "Cucumber":
    case "cucumber":
    IngPrice = .50 ;
    break;
    default:
    IngPrice = 0.00 ;
    break;
}
//this returns whichever ingredient price was chosen
    return IngPrice ;
}
  public static void main(String[] args){
    //declares scanner
Scanner input = new Scanner(System.in);
    System.out.println("Ingredient List:\nBase Price - 2.00\nTurkey - 1.55\nLettuce - .55\nAvocado - 1.25\nTuna - 1.78\nPeppers - .50\nHam - 1.45\nMayo - .25\nPickles - .50\nSprouts - .45\nCucumber - .50");
    //creates a variable that holds the ingredients you choose then creates a variable to hold the price
    System.out.println("What is the First ingredient you want for your Sandwhich(please make sure your spelling is correct)");
    String Ingredient1 = input.nextLine();
    double price1 = price(Ingredient1);
    System.out.println("What is the Second ingredient you want for your Sandwhich(please make sure your spelling is correct)");
    String Ingredient2 = input.nextLine();
    double price2 = price(Ingredient2);
    System.out.println("What is the Third ingredient you want for your Sandwhich(please make sure your spelling is correct)");
    String Ingredient3 = input.nextLine();
    double price3 = price(Ingredient3);
    System.out.println("What is the Fourth ingredient you want for your Sandwhich(please make sure your spelling is correct)");
    String Ingredient4 = input.nextLine();
    double price4 = price(Ingredient4);
    //prints the ingredients you chose
    System.out.println("\n");
    System.out.println("You chose\n");
    System.out.println(Ingredient1);
    System.out.println(Ingredient2);
    System.out.println(Ingredient3);
    System.out.println(Ingredient4);
    System.out.println("");
    System.out.println("Your Price is");
    //this is separate from the equation for price cause then it turns the equation into concatenation of strings and the output ends up being something like 0.250.501.00
    System.out.print("$");
    //this equation has a bug where sometimes if you add 3 of the same ingredients that have more than 1 decimal place ie 2.55 not 2.50 it buggs out an gives the wrong total, so 3 ham and 1 sprouts gives a total of $6.800000000000001 instead of 6.80
    double BuggedTotal = 2.00 + price1 + price2 + price3 + price4;
    //this multiplies the price by 100 so it doesn't remove cents and just removes the .00000001, then divides it by 100 to bring it back to the normal price but with the glitch removed
    double FixedTotal = Math.round(BuggedTotal*100.00)/100.00;
    System.out.println(FixedTotal);
  }
}
