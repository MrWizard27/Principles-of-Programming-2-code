import java.util.Scanner;
public class Test{
  public static boolean truefalse(int UserInput){
    //this divides the user input by 2 and if it can't be cleanly divided by 2 it returns false which means it's odd
    if (UserInput % 2 == 0){
      return true;
    }else{
      return false;
    }
  }
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);

    int[] EvenArray = {11,17,2,0,3,7,4,22,5,0};
    int[] OddArray = {4,1,4,2,0,3,0,4,13,5};
    String FinalAnswer = "";

    System.out.println("Please give a whole number");
    int UserInput = input.nextInt();
    boolean TrueOrFalse = truefalse(UserInput);
    //true or false is a boolean so if it is false, this if statement won't run
    if (TrueOrFalse){
      for (int e = 0; e < EvenArray.length; e++){

          if (e < EvenArray.length - 1){
          FinalAnswer += EvenArray[e]*UserInput + ",";
          }else{
          FinalAnswer += EvenArray[e]*UserInput;
  }
}
}else{
  for (int o = 0; o < OddArray.length; o++){

      if (o < OddArray.length -1){
      FinalAnswer += OddArray[o]*UserInput + ",";
      }else{
      FinalAnswer += OddArray[o]*UserInput;
}
  }
    }
      System.out.println("\nYour input was " + UserInput);
      System.out.println("Your output was " + FinalAnswer);
    }
}
