//This code was made by Michael Plafcan(Section 01) on 4/27/2023
public class Appliance {
    //2d array that stores all the sounds of each appliance
    public static final String[][] sounds = {{"Radio Test","Static","*music*"},{"Digital","Womps","Pop"},{"Swoosh","ChuggaChugga","*Samsung song*"}};
    //name of the appliance
    private String label;
    //if the appliance is digital
    private boolean isDigital;

    //constructor
    public Appliance(String label, boolean isDigital){
        this.label = label;
        this.isDigital = isDigital;
    }

    //prints if the Appliance is digital
    public void printDigital(){
        //checks if digital
        if (isDigital){
            //if it is digital, prints out that its digital
            System.out.println(this.label + " is digital");
        }else{
            //if not, prints out that it isn't digital
            System.out.println(this.label + " isn't digital");
        }
    }
    //getter for label
    public String getLabel(){
        return this.label;
    }
}
