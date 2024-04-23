//This code was made by Michael Plafcan(Section 01) on 4/27/2023
public class Account {
    //instance variables
    private int accountid;
    private String FirstName;
    private String LastName;
    private double balance;

    //constructor
    public Account(int x, String FirstName, String LastName){
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.balance = 0;
        this.accountid = x;
    }

    //constructor but lets you choose their balance
    public Account(int x, String FirstName, String LastName, double balance){
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.balance = balance;
        this.accountid = x;
    }

    //converts the account object into a string
    public String toString(){
        
        return "\n|ID| Name | Balance|\n| " + this.accountid + " | " + getName() + "| balance: $" + balance + "|\n";
    }

    //getter for first name
    public String getFName(){
        return this.FirstName;
    }

    //getter for last name
    public String getLName(){
        return this.LastName;
    }

    //combines the first and last name to make things easier
    public String getName(){
        return this.FirstName + " " + this.LastName;
    }

    //getter for balance
    public double getbalance(){
        return this.balance;
    }

    //getter for account ID
    public int getaccountid(){
        return this.accountid;
    }

    //adds money to the balance and creates a receipt
    public String deposit(double amount){
        //adds amount to balance
        balance += amount;
        //creates receipt
        String receipt = getName() + " Deposited " + amount;
        return receipt;
    }

    //removes money from balance and creates a receipt
    public String withdraw(double amount){
        //removes amount from balance
        balance -= amount;
        //creates receipt
        String receipt = getName() + " Withdrew " + amount;
        return receipt;
    }
}
