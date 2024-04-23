//This code was made by Michael Plafcan(Section 01) on 4/27/2023
//imports scanner
import java.util.Scanner;
public class BankDrv {
    public static void main(String[] args){
        //creates scanner object
        Scanner in = new Scanner(System.in);
        //creates bank object
        Bank bank = new Bank();

        //welcome message
        System.out.println("Welcome to Bank of money(tm)");
        System.out.println("This Program will let you explore the account in our bank and withdraw, deposit, create, delete, and look at the transaction history of those accounts\n");
        
        //commands
        System.out.println("Commands");
        System.out.println("----------------");
        System.out.println("Back: Lets you go back/ cancel commands you used (Doesn't work when creating an account because of naming)");
        System.out.println("Create / create account: Lets you create a new account");
        System.out.println("Display / Display accounts: Shows you information on every existing account");
        System.out.println("History / Display History / Display Transactions  : Shows you the Transaction history for every account");
        System.out.println("Choose / Choose Account: Logs you into an account where you can withdraw, deposit, delete, or view information about the account");
        System.out.println("Commands: Shows you this list of commands\n");
        
        //starts infinite loop
        while(true){
        
        //asks for input
        String action = in.nextLine();
        //changes input to upercase
        action = action.toUpperCase();
        
        //Switch statement that holds the commands and what they do, takes in action and runs the statement after the matching case
        switch (action) {
            default:
            System.out.println("Not an Option");
            break;
            //creates account
            case "CREATE ACCOUNT":
            case "CREATE":
            CreateAccount(bank);
            break;
            //displays all accounts
            case "DISPLAY ACCOUNTs":
            case "DISPLAY":
            bank.displayAccounts();
            break;
            //displays transaction history of all acounts
            case "DISPLAY TRANSACTIONS":
            case "DISPLAY HISTORY":
            case "HISTORY":
            bank.displayTransactions();
            break;
            //back doesn't do anything as this is as far back as you can go
            case "BACK":
            break;
            //displays the commands
            case "COMMANDS":
            commands();
            break;
            //chooses an account
            case "CHOOSE":
            case "CHOOSE ACCOUNT":
            //asks for account ID
            System.out.println("What's your account ID");
            //stores input
            String option = in.nextLine().toUpperCase();
            
            //if you say back when it asks for account ID it'll take you back to the main command list
            if (option.equals("BACK")){

            break;
                //if it doesn't equal back, it goes forward with the normal operation
            }else {
                //try catch that checks if there are letters in the output, 
                try{
                    //converts option to an integer
                    int AccountID = Integer.parseInt(option);
                    //if it searches for the account and gets -1 then the account doesn't exist
                    if (bank.Accountsearch(AccountID) == -1){
                        System.out.println("That account doesn't exit");
                    }else{
                        //if account exists then it goes to the account command page
                    AccountChoice(AccountID, bank);
                    }
                    //if an error happened that means there was a letter or space in the output
                } catch (NumberFormatException e){
                    //prints out to make sure there are no letters or spaces
                    System.out.println("Account ID's are only numbers, please make sure there are no letters or spaces in your ID");

                }
            }
        }
        }
    }
    //lets you edit an account you chose in the main method
    public static void AccountChoice(int AccountID, Bank bank){
        //commands for editing the account you chose
        System.out.println("Account Commands");
        System.out.println("----------------");
        System.out.println("Back: Lets you go back/ cancel commands you used (Doesn't work when creating an account because of naming)");
        System.out.println("Commands: Shows you this list of commands\n");
        System.out.println("Delete / Delete Account: Deletes the Account you're on");
        System.out.println("Display / Display Account: Shows you information on the account you\n");
        System.out.println("History / Display History / Display Transactions  : Shows you the Transaction history for the account you're on");
        System.out.println("Deposit: Deposits money into the balance of the account you're currently on");
        System.out.println("Withdraw: Withdraws money from the balance of the account you're currently on");
        System.out.println("Display All / Display All Accounts / Display Accounts: Shows you information on every existing account\n");
        
        //creates scanner
        Scanner in = new Scanner(System.in);

        //starts the loop
        boolean loop = true;
        while(loop){

            //prints out the accounts name
            System.out.println("|Account| " + (bank.getAccount(AccountID).getName()));
            
            //gets input and converts it to uppercase
            String action = in.nextLine().toUpperCase();
            
            //commands
        switch (action) {
            default:
            //prints this if the input doesn't equal any of the cases
            System.out.println("Not an Option");
            break;
            //deletes account
            case "DELETE ACCOUNT":
            case "DELETE":
            DeleteAccount(AccountID, bank);
            //breaks the loop so it doesn't try to loop over on the deleted account
            loop = false;
            break;
            //prints the accounts information
            case "DISPLAY ACCOUNT":
            case "DISPLAY":
            DisplayAccount(AccountID, bank);
            break;
            //displays the transaction history of the account
            case "DISPLAY TRANSACTIONS":
            case "DISPLAY HISTORY":
            case "HISTORY":
            bank.displayTransactions(AccountID);
            break;
            //deposits money into the account
            case "DEPOSIT":
            Deposit(AccountID, bank);
            break;
            //withdraws money from the account
            case "WITHDRAW":
            Withdraw(AccountID, bank);
            break;
            //displays all the accounts
            case "DISPLAY ALL":
            case "DISPLAY ALL ACCOUNTS":
            case "DISPLAY ACCOUNTS":
            bank.displayAccounts();
            break;
            //ends the loop and goes back to the main command page
            case "BACK":
            loop = false;
            break;
            //prints the account commands
            case "COMMANDS":
            accountcommands();
            break;

        }
        }
    }

    //deposits money into an account
    public static void Deposit(int AccountID, Bank bank){
        //gets input
        Scanner in = new Scanner(System.in);
        //gets the position of the account in the account list array
        int Position = bank.Accountsearch(AccountID);

        //asks how much you want to deposit
        System.out.println("How much do you want to deposit?");
        //gets input and converts it to uppercase
        String option = in.nextLine().toUpperCase();

        //if you say back
        if (option == "BACK"){
            //skips the main code, ending the method and goes back to the account code method
        }else{
            //if option did not equal bakc then it runs this code
            try{
                
                //converts the input into a double, if there is a non number here the catch() catches it and it doesn't run the bank.deposit
                double amount = Double.parseDouble(option);
                //deposits the amount you specified into the account with the matching account id you chose beforehand
                bank.deposit(Position, amount);
                //if an error happens
            } catch (NumberFormatException e){
                //prints out "please input a number amount"
                System.out.println("Please input a number amount");

            }
        }
    }
    
    //withdraws money
    public static void Withdraw(int AccountID, Bank bank){
        //creates scanner object
        Scanner in = new Scanner(System.in);
        //gets the location of the acount with the account ID you chose
        int Position = bank.Accountsearch(AccountID);

        //asks how much you want to withdraw
        System.out.println("How much do you want to Withdraw?");
        //gets your input
        String option = in.nextLine().toUpperCase();
        
        //if you want to go back instead of withdraw this detects it and ends the method
        if (option == "BACK"){
    
        }else{
            try{
                //converts to double
                double amount = Double.parseDouble(option);
                //withdraws the amount from that account
                bank.withdraw(Position, amount);
                //catches errors
            } catch (NumberFormatException e){

                //tells you to make sure that it only has numbers
                System.out.println("Please input a number amount");

            }
        }
    }

    //displays an account
    public static void DisplayAccount(int AccountID,Bank bank){

        //gets the account with that accountID and then prints it
        System.out.println(bank.getAccount(AccountID));
    }

    //creates an account
    public static void CreateAccount(Bank bank){
        //creates scanner object
        Scanner in = new Scanner(System.in);

        //asks for the first name of the account
        System.out.println("What's your First Name");
        String FirstName = in.nextLine();

        //asks for the second name of the account
        System.out.println("What's your Last Name");
        String LastName = in.nextLine();

        //creates the account
        bank.createAccount(FirstName,LastName);

        //tells you the account ID of the new account
        System.out.println("Your account ID is " + bank.getAccount().getaccountid());
    }

    //deletes the account
    public static void DeleteAccount(int AccountID, Bank bank){
        
        //gets the location of the account
        int Position = bank.Accountsearch(AccountID);
        //deletes it
        bank.deleteAccount(Position);
        
    }

    public static void accountcommands(){
        //prints the account command list

        System.out.println("Account Commands");
        System.out.println("----------------");
        System.out.println("Back: Lets you go back/ cancel commands you used (Doesn't work when creating an account because of naming)");
        System.out.println("Commands: Shows you this list of commands\n");
        System.out.println("Delete / Delete Account: Deletes the Account you're on");
        System.out.println("Display / Display Account: Shows you information on the account you\n");
        System.out.println("History / Display History / Display Transactions  : Shows you the Transaction history for the account you're on");
        System.out.println("Deposit: Deposits money into the balance of the account you're currently on");
        System.out.println("Withdraw: Withdraws money from the balance of the account you're currently on");
        System.out.println("Display All / Display All Accounts / Display Accounts: Shows you information on every existing account");
    
    }

    public static void commands(){
        //prints command list
        System.out.println("Commands");
        System.out.println("----------------");
        System.out.println("Back: Lets you go back/ cancel commands you used (Doesn't work when creating an account because of naming)");
        System.out.println("Create / create account: Lets you create a new account");
        System.out.println("Display / Display accounts: Shows you information on every existing account");
        System.out.println("History / Display History / Display Transactions  : Shows you the Transaction history for every account");
        System.out.println("Choose / Choose Account: Logs you into an account where you can withdraw, deposit, delete, or view information about the account");
        System.out.println("Commands: Shows you this list of commands\n");

    }
}
