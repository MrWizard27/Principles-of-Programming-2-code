//this code was made by Michael plafcan in section 04 on 10/25/22 
import java.util.Scanner;
public class doubloon{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    int CharCount = 0;
    String doubloon = input.nextLine();
    for(char c = 'a'; c <= 'z' ; c++){
      CharCount = 0;
      for(int count=0; count<doubloon.length();count++){
        if (c == doubloon.charAt(count)){
          CharCount++;
        }else{
      }
      }
      if (CharCount==2){
        //if you want to show it checking the word get rid of the slashes before this code
      System.out.println("There are " + CharCount + " " + c + "'s in " + doubloon);
    }else if (CharCount==0){

    }else{
      System.out.println("There are " + CharCount + " " + c + "'s in " + doubloon + ", Which means it is not a doubloon\n");
      System.out.print(doubloon + " is not a doubloon");
      System.exit(0);
  }
}
//if the program doesn't end it means its a doubloon so it says this
    System.out.println(doubloon + " is a doubloon");
  }
}
