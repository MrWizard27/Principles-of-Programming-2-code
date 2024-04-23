//This code was made by Michael Plafcan(Section 01) on 4/27/2023
public class AppDrv {

    public static void main(String[] args){
    //Creates new Radio object called radio
    Radio radio = new Radio("radio");
    //Creates new Computer object called computer
    Computer computer = new Computer("computer");
    //Creates new Dishwasher object called dishwasher
    Dishwasher dishwasher = new Dishwasher("dishwasher");

    //spacer
    System.out.println();
    //prints the appliance name
    System.out.println("|" + radio.getLabel() + "|");
    //spacer
    System.out.println();
    //prints if the appliance is digital
    radio.printDigital();
    //spacer
    System.out.println();
    //prints sound one of radio
    radio.soundOne();
    //spacer
    System.out.println();
    //prints sound two of radio
    radio.soundTwo();
    //spacer
    System.out.println();
    //prints sound three of radio
    radio.soundThree();

    //spacer
    System.out.println();
    //prints the appliance name
    System.out.println("|" + computer.getLabel() + "|");
    //spacer
    System.out.println();
    //prints if the appliance is digital
    computer.printDigital();
    //spacer
    System.out.println();
    //prints sound one of computer
    computer.soundOne();
    //spacer
    System.out.println();
    //prints sound two of computer
    computer.soundTwo();
    //spacer
    System.out.println();
    //prints sound three of computer
    computer.soundThree();

    //spacer
    System.out.println();
    //prints the appliance name
    System.out.println("|" + dishwasher.getLabel() + "|");
    //spacer
    System.out.println();
    //prints if the appliance is digital
    dishwasher.printDigital();
    //spacer
    System.out.println();
    //prints sound one of dishwasher
    dishwasher.soundOne();
    //spacer
    System.out.println();
    //prints sound two of dishwasher
    dishwasher.soundTwo();
    //spacer
    System.out.println();
    //prints sound three of dishwasher
    dishwasher.soundThree();
    }
}
