//This code was made by Michael Plafcan(Section 01) on 4/27/2023
import java.util.ArrayList;
public class Bank{
    //instance variables
    //2d array list
    private ArrayList<ArrayList<String>> history;
    private ArrayList<Account> accounts;
    private int currentAccountID;
    private int currentTransactionID;

    //constructor
    public Bank(){
        //creates the 2d arraylist
        this.history = new ArrayList<ArrayList<String>>();
        //creates arraylist
        this.accounts = new ArrayList<Account>();
        this.currentAccountID = 0;
        this.currentTransactionID = 0;
        //creates 3 example accounts
        createAccount("Steven", "Strange", 100200);
        createAccount("Maria", "Hanberg", 31415.92);
        createAccount("Phil", "Coulson", 2817.42);
    }

    //getter for the most recent account created
    public Account getAccount(){
        return this.accounts.get(accounts.size() -1);
    }

    //getter that gets the account with the account ID specified
    public Account getAccount(int AccountID){
        return this.accounts.get(Accountsearch(AccountID));
    }
    
    //deposits money into an account and saves a receipt of it in history
    public void deposit(int position, double amount){
        //creates receipt and puts money into the account
        String Receipt = accounts.get(position).deposit(amount);
        //adds the receipt to the history 2d array list
        this.history.get(position).add("Transaction ID: " + currentTransactionID + "| " + Receipt);
        //gets the next transaction ID ready for the next receipt
        currentTransactionID++;
    }

    //withdraws money out of an account and saves a receipt
    public void withdraw(int position, double amount){
        //tells you if you have insufficient funds
        if ((accounts.get(position).getbalance() - amount) < 0){
            System.out.println("Insufficient funds");
        }else{
            //withdraws money and saves a receipt
        String Receipt = accounts.get(position).withdraw(amount);
        //adds receipt to transaction history
        this.history.get(position).add("Transaction ID: " + currentTransactionID + "| " + Receipt);
        //gets the next transaction ID ready for the next receipt 
        currentTransactionID++;
        }
    }

    //displays the transaction history of every account
    public void displayTransactions(){
        //goes through the accounts
        for (int x = 0; x < this.history.size(); x++){
            //prints the name of the account
            System.out.println("|" + accounts.get(x).getName());
            //Goes through their transactions
            for (int y = 0; y < this.history.get(x).size(); y++){
                //prints their transactions
                System.out.println(this.history.get(x).get(y));
            }
            //spacer
            System.out.println();
        }
    }

        //displays the transaction history for specific account
        public void displayTransactions(int AccountID){
            //gets the location of the account
            int position = Accountsearch(AccountID);

            //goes through the transactions of the account
            for (int x = 0; x < this.history.get(position).size(); x++){
                //prints the transactions
                System.out.println(this.history.get(position).get(x));
            }
            //spacer
            System.out.println();
        }

        //creates an account
    public void createAccount(String FirstName, String LastName){
        //adds a new row to the 2d array
        this.history.add(new ArrayList<String>());
        //adds a new account to the accounts array
        this.accounts.add(new Account(this.currentAccountID, FirstName, LastName));
        //gets the next Account ID ready for the next accounted being created
        this.currentAccountID++;

    }

    public void createAccount(String FirstName, String LastName, double balance){
        //adds a new row to the 2d array
        this.history.add(new ArrayList<String>());
        //adds a new account to the accounts array
        this.accounts.add(new Account(this.currentAccountID, FirstName, LastName, balance));
        //gets the next Account ID ready for the next accounted being created
        this.currentAccountID++;

    }

    //deletes an account
    public void deleteAccount(int position){
        //removes its row in transaction history
        this.history.remove(position);
        //removes its place in the accounts array
        this.accounts.remove(position);
    }

    //displays all the accounts
    public void displayAccounts(){
        //prints accounts array
        for (int x = 0; x < accounts.size(); x++){
            //prints the account at x
            System.out.println(accounts.get(x));
        }
    }

    //searches the position of the account with a certain account ID
    public int Accountsearch(int AccountID){
        //sets postion to -1, if no account if found -1 means no accounts
        int position = -1;
        //goes through accounts
        for (int x = 0; x < accounts.size(); x++){
            //checks the Account ID of the account
            if (accounts.get(x).getaccountid() == AccountID){
                //if it matches, sets position to x
                position = x;
            }
        }
        //returns the account location or -1 if there is no matching account
        return position;
    }
}
