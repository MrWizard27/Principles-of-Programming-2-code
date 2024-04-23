//This code was made by Michael Plafcan(Section 01) on 4/27/2023
public class Dishwasher extends Appliance{

    //constructor
    public Dishwasher(String label){
        super(label,false);
    }

    //prints out Dishwasher's first sound
    public void soundOne(){
        System.out.println(sounds[2][0]);
    }

    //prints out Dishwasher's second sound
    public void soundTwo(){
        System.out.println(sounds[2][1]);
    }

    //prints out Dishwasher's third sound
    public void soundThree(){
        System.out.println(sounds[2][2]);
    }
    
}
