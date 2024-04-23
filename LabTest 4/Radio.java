//This code was made by Michael Plafcan(Section 01) on 4/27/2023
public class Radio extends Appliance{

    //constructor
    public Radio(String label){
        super(label,false);
    }

    //prints out Radio's first sound
    public void soundOne(){
        System.out.println(sounds[0][0]);
    }

    //prints out radio's second sound
    public void soundTwo(){
        System.out.println(sounds[0][1]);
    }

    //prints out radio's third sound
    public void soundThree(){
        System.out.println(sounds[0][2]);
    }
}
