//this code was made by Michael Plafcan on 2/7/23
import java.util.Scanner;
public class Labtest1{
    public static void main(String[] args){
        //Declares scanner object
        Scanner input = new Scanner(System.in);

        //asks user for string to reverse
        System.out.println("Give me a string to reverse");
        String str = input.nextLine();

            //prints the string on char at a time in reverse order
        for (int x = str.length()-1; x>=0; x--){

            System.out.print(str.charAt(x));

        }
    }
}