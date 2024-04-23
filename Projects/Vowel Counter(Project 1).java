//This code was made by Michael Plafcan on 1/24/23
import java.util.Scanner;
public class VowelProject{
  public static void main(String[] args){

    Scanner input = new Scanner(System.in);
    String str = "";

  System.out.println("Welcome to Vowel Counter, Give me a Sentence and I'll tell you how many vowels are in it!");

  while (true){

    System.out.println("Please input a Sentence (If you want to quite, type \"Quit\")");
    str = input.nextLine();
    String Vowels = "";
    int VowelCount = 0;
    if (str.equalsIgnoreCase("quit")){
      System.exit(0);
    }

    for (int x = 0; x<str.length(); x++){
      if (str.charAt(x)=='a' || str.charAt(x)=='e' || str.charAt(x)=='i' || str.charAt(x)=='o' || str.charAt(x)=='u'){
        VowelCount++;
        Vowels += str.charAt(x);
      }

    }

    System.out.println("You entered \"" + str + "\"");
    System.out.println("This sentence has " + VowelCount + " Vowels");
    System.out.println("The Vowels in this sentence are \"" + Vowels + "\"");

    }
  }
}
