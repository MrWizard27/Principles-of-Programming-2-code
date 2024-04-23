import java.util.Random;
public class Templab{
  public static void main(String[] args){

    Random randomNumber = new Random();
    int temperature;
    temperature = randomNumber.nextInt(60) + 35;

      if (temperature >= 35 && temperature <=44){
        System.out.print("Its a COLD day with a temperature of "+temperature+" Degrees");
      }else if (temperature >= 45 && temperature <=54){
        System.out.print("Its a CHILLY day with a temperature of "+temperature+" Degrees");
      }else if (temperature >= 55 && temperature <=64){
        System.out.print("Its a COOL day with a temperature of "+temperature+" Degrees");
      }else if (temperature >= 65 && temperature <=74){
        System.out.print("Its a WARM day with a temperature of "+temperature+" Degrees");
      }else if (temperature >= 75 && temperature <=84){
        System.out.print("Its a WARMER day with a temperature of "+temperature+" Degrees");
      }else if (temperature >= 85 && temperature <=95){
        System.out.print("Its a HOT day with a temperature of "+temperature+" Degrees");
      }

  }
}
