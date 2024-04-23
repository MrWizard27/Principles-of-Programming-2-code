import java.util.Scanner;
public class Haiku{
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String FirstLine;
    String SecondLine;
    String ThirdLine;
    System.out.println("What is the First line of your haiku?");
    FirstLine = input.nextLine();
    System.out.println("What is the Second line of your haiku?");
    SecondLine = input.nextLine();
    System.out.println("What is the Third line of your haiku?");
    ThirdLine = input.nextLine();
    System.out.println("\nYour Haiku is\n");
    System.out.println("------------------------");
    System.out.println(FirstLine);
    System.out.println(SecondLine);
    System.out.println(ThirdLine);
    System.out.print("------------------------\n");
  }
}
