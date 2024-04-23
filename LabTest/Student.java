//this code is made by Michael Plafcan on March 2nd 2023
public class Student{
    //instance Variables
    private String Name;
    private int Age;
    private String PhoneNumber;
    private double GPA;

    public Student(){
        //this class initializes the instance Variables
        this.Name = null;
        this.Age = 0;
        this.PhoneNumber = null;
        this.GPA = 0;

    }

    public Student(String name, int age, String pnumber, double gpa){
        //this class takes parameters from a studen object creation statement and sets each variable in the object as the parameters
        this.Name = name;
        this.Age = age;
        this.PhoneNumber = pnumber;
        this.GPA = gpa;

    }

    public void setName(String name){
        //sets name as input
        this.Name = name;

    }

    public void setAge(int age){
        //sets age as input
        this.Age = age;

    }

    public void setPhone(String pnumber){
        //sets phone number as input
        this.PhoneNumber = pnumber;

    }

    public void setGpa(double gpa){
        //sets GPA as input
        this.GPA = gpa;

    }

    public String getName(){
        //gives the Name instance variable
        return this.Name;

    }

    public int getAge(){
        //gives the Age instance variable
        return this.Age;

    }

    public String getPhone(){
        //gives the Phone Number instance variable
        return this.PhoneNumber;

    }

    public double getGpa(){
        //gives the GPA instance variable
        return this.GPA;

    }

    public String toString(){
        //Returns instance variables shaped as

        //Student: John Smith
        //Age: 18
        //Phone Number: 111-111-1111
        //GPA: 3.5

        return "Student: " + this.Name + "\nAge: " + this.Age + "\nPhone Number: " + this.PhoneNumber + "\nGPA: " + this.GPA;

    }

    public boolean equals(Student that){
        //checks to see if the value of each variable is the same
        return this.Name.equals(that.Name) && this.Age == that.Age && this.PhoneNumber.equals(that.PhoneNumber) && this.GPA == that.GPA;
    }
}