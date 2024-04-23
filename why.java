//adds scanner utility
import java.util.Scanner;
            //Name of file
public class why{

public static void main(String[] args) {

      Scanner input = new Scanner(System.in);
              // V this is the first message
      System.out.println("Wattup Son!");
      // V str is the variable name but you can make it whatever you want
      String str = input.nextLine();
                    //nextline makes the scanner scan the string, nextint would be scanning int data values
      if (str.equals("Hello There")) {
        System.out.println("Kenobi?");
      }
// these are just other ways to respond to text, else if is to add more if statements
      else if (str.equals("Nothin Much")) {
        System.out.println("Thats Boring");
      }    //Bottom statement is the response while top statement is what you have to say to get that response
      else if (str.equals("Execute Order 66")) {
        System.out.println("Death to the Jedi!");
      }
      else if (str.equals("What is the meaning of life")) {
        System.out.println("I dont know bro, I just work  here");
      }
      else if (str.equals("Up Up Down Down Left Right Left Right B A Start")) {
        System.out.println("Hwhat");
      }
      else if (str.equals("The Sky")) {
        System.out.println("No dib Sherlock");
      }
      else if (str.equals("Threat Level Midnight")) {
        System.out.println("I don't watch The Office");
      }
      else if (str.equals("Dukes up")) {
        System.out.println("Bonks with crown");
      }
      else if (str.equals("Dad?!")) {
        System.out.println("Yes son");
      }
      else if (str.equals("Blows up pancakes with mind")) {
        System.out.println("My fudgin panca-");
      }
        //this is the response you get if you say something other than one of the if / else if top statements
      else {
        System.out.println("I don't do english too well partner so im just gonna nod my head");

      }

      input.close();


  }
}
