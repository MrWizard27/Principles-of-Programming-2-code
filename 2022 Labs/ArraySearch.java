import java.util.Random;
import java.util.Scanner;
public class ArraySearch{
  public static void main(String[] args){
int[] RandomArray = new int[100];
int found = 0;
Scanner input = new Scanner(System.in);
//assigns each part of the array to a random number
for (int n = 0; n<100; n++){
  Random randomNumber = new Random();
  RandomArray[n] = randomNumber.nextInt(100) + 1;

}
System.out.println("Insert a number 1-100 to search the Array");
int InputNum = input.nextInt();
for (int n=0;n<100;n++){
  if (RandomArray[n] == InputNum){
    System.out.println("Your number was found in Array index #" + n);
    found = 1;
  }else{

  }
}
if (found == 0){
System.out.println("Your Number was not in any index of the Array");
}
  }
}
