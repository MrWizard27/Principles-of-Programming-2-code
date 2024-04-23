//This lab was made on 2/2/23 by Michael Plafcan with the help of my group 
import java.util.Scanner;
public class Histogram{
    public static void main(String[] args){
        //initializes scanner
    Scanner input = new Scanner(System.in);
    //creates an array that holds the amount of a letter in the sentence
    int numarray[] = new int[26];
    //this string is used to tell where the number for a char should be stored in the previous array
    String Alphabet = "abcdefghijklmnopqrstuvwxyz";
    System.out.println("Please input a sentence");
    //asks for sentence
    String str = input.nextLine();
    //Changes sentence to lowercase 
           str = str.toLowerCase();
           //goes through the sentence and adds 1 to each corresponding place to count the letters
    for (int x = 0;x<str.length();x++){
        //checks if it's a letter or not
        if (Character.isLetter(str.charAt(x))){
            //adds one to the count for that letter in the array
        numarray[Alphabet.indexOf(str.charAt(x))]++;
        }
    }
    //this for loop prints those letters vertically in alphabet order to make it look like a histogram
    for (int i = 0;i<numarray.length;i++){
        int ogcount = numarray[i];
        if (numarray[i]==0){

        }else{
            //uncomment this and make the entire while loop into a comment if you want to to tell you how many of each letter instead of outputing each letter to make something that looks like a bar graph
        //System.out.print(Alphabet.charAt(i) + " " + ogcount);
        while (numarray[i]!=0){
            System.out.print(Alphabet.charAt(i));
            numarray[i]--;
        }
        System.out.println("");
        }
    }
    }
}