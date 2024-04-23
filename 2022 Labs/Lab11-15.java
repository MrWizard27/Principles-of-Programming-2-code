import java.util.Scanner;
public class Lab11{
  public static boolean truefalse(int UserInput){
    //this finds out if the user input is even or odd)
    if (UserInput % 2 == 0){
      return true;
    }else{
      return false;
    }
  }
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    char[] EvenArray = {'#','m','^','o','k','%','4','*','5','z'};
    char[] OddArray = {'j','*','P','M','#','z','7','@','1','%'};
    int answer = 0;
    String answerfull = "";

    System.out.println("Please enter a Positive Integer");

    int UserInput = input.nextInt();
    boolean TrueorFalse = truefalse(UserInput);
    //if user input is Even it goes through this
    if (TrueorFalse==true){
      //this multiplies the user input to the int values of each character in the true/even array
      for (int t = 0; t < EvenArray.length; t++){
      answer = UserInput * (int)EvenArray[t];
      System.out.println(answer);
      if (t < (EvenArray.length - 1)){
      answerfull += answer +", ";
    }else{
      answerfull += answer;
    }
        }
        //if user input is odd it goes through thise
  }else{
    //this multiplies the user input to the int values of each character in the false array
    for (int f = 0; f < OddArray.length; f++){
      answer = UserInput * (int)OddArray[f];
      System.out.println(answer);
      //this if statement is to get rid of the last comma to make it look better
      if (f < (OddArray.length - 1)){
        //this adds the output to a variable to be displayed later
      answerfull += answer +", ";
    }else{
      answerfull += answer;
    }
  }
}
    System.out.println("Your Values are " + answerfull);
  }
}
