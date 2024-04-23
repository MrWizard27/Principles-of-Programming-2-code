//This code was made by Michael Plafcan(Section 01) on 4/27/2023
public class Computer extends Appliance{

    //constructor
    public Computer(String label){
        super(label,true);
    }

    //prints out Computer's first sound
    public void soundOne(){
        System.out.println(sounds[1][0]);
    }

    //prints out Computer's second sound
    public void soundTwo(){
        System.out.println(sounds[1][1]);
    }

    //prints out Computer's third sound
    public void soundThree(){
        System.out.println(sounds[1][2]);
    }
    
}
