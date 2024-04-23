//This code was made by Michael Plafcan on 2/3/23
import java.util.Scanner;
public class Project2{
    public static void PrintArray(char[] board){
        for (int x = 0; x < board.length;x++){
            System.out.print(board[x]);
        }
    }
    public static char[] BoardCreate(String str, char[] board){
        for (int x = 0;x < str.length();x++){
            if (Character.isLetter(str.charAt(x))){
                board[x]='_';
            }else{
                board[x]= str.charAt(x);
            }
        }
        return board;
    }
    public static int Guess(String str, char[] board, int count){
        Scanner input = new Scanner(System.in);

        int dashcount = 0;
        int n = 0;
        String CheckGuess = "";
        char guess;
        int correct = 0;

        while(n == 0){

            PrintArray(board);
            System.out.println("\nInput a single letter");

            CheckGuess = input.nextLine();
            CheckGuess = CheckGuess.toUpperCase();

            if (CheckGuess.length()!=1 || !Character.isLetter(CheckGuess.charAt(0))){

                System.out.println("That is not a single letter");

            }else{

            guess = CheckGuess.charAt(0);
            dashcount = 0;
            correct = 0;

            for (int x = 0; x<str.length();x++){
        
           
                if(guess==(str.charAt(x))){

                    board[x] = str.charAt(x);
                    correct++;

                }else if(x==str.length()-1 && correct==0){

                    System.out.println("Sorry, There were no " + guess + "'s in the phrase");
                   
                }
                if (board[x]=='_'){

                    dashcount++;

                }
                if (x==str.length()-1 && dashcount==0){

                    n++;
                
                }
            }

            count++;
            }

        }
        return count;
    }
    public static void clearScreen(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a phrase for your friend to guess");
        String str = input.nextLine();
        str = str.toUpperCase();
        char board[] = new char[str.length()];
        int count = 0;
        board = BoardCreate(str,board);
        clearScreen();
        count = Guess(str,board,count);
        PrintArray(board);
        System.out.println("\nCongratulations, You win, It took you " + count + " guesses to solve it");
        }
}