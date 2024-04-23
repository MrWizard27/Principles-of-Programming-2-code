import java.util.Scanner;
public class StringsLab{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.println("Please enter a word");
    String str1 = input.nextLine();
    System.out.println(" ");
    System.out.println("You said " + str1);
    System.out.println(str1 + " has " + str1.length() + " letters in it");
    for (int i = 0; i < str1.length(); i++) {
    char letters = str1.charAt(i);
    System.out.println((i) + " " + letters);
  }
    System.out.println("Please enter a second word and see if it matches the first");
    String str2 = input.nextLine();
    System.out.println(" ");
    System.out.println("You said " + str2);
    if (str2.equals(str1)){
      System.out.println("The Strings Match");
    }else {
      System.out.println("The Strings Do Not Match");
    }
  }
}
