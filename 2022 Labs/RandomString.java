import java.util.Random;
public class string{
  public static void main(String[] args) {
    int result = 0;
    String garble = "";
  Random randomNumber = new Random();
  result = randomNumber.nextInt(26) + 97;
    for (int n = 7;n!=0;n--){
      result = randomNumber.nextInt(26) + 97;
    garble += (char)result;
    System.out.println(result);
    System.out.println((char)result);
  }
  System.out.println(garble);
}
}
