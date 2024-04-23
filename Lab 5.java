import java.util.Scanner; 

public class Lab5{ 

public static void main(String[] args) { //This is the main method, accepts String[] as an argument.  

    Scanner scan = new Scanner(System.in); //Constuctor for the Scanner class.  

 
 

    System.out.print("Enter a phrase: "); //Prints out "Enter a Phrase: " to the console.  

    String phrase = scan.nextLine().toUpperCase(); //Prompts the user for input and converts it to upper case.  

 
 

    String extendedPhrase = ""; //Creates a empty String for the extended phrase.  

 
 

    int pos=0; // declares the pos variable and intializes it with a value of 0 

    while (pos < phrase.length()) { //while loop that iterates through so long int "pos" is less than the length of the input. 

        extendedPhrase += phrase.charAt(pos) + " "; //assigns the char at pos in phrase to the variable extendedPhrase 

        pos++; //Increments int pos by 1.  

    } 

    phrase = extendedPhrase; //makes the the variable phrase have the same value as the variable extendedPhrase 

 
 

    String puzzle = ""; //declares a String type variable named puzzle and initializes it with a blank value 

 
 

    pos=0; //assigns the pos variable 

    while (pos < phrase.length()) { //loop that continues until the variable pos is no longer less then the length of the variable phrase 

        char letter = phrase.charAt(pos); //creates a char type variable that contains the char at pos in phrase 

        if ((letter >= 'A') && (letter <= 'Z')) { //runs the statement bolow if the variable letter is in the alphabet 

            puzzle += '_'; //if the if statement is true, it adds an underscore to puzzle 

        } else { //else statement that runs if the above if statement come out as false (doesn't run if the if statement is true) 

            puzzle += letter; //add the char of the variable letter to the String Variable Puzzle 

        }  

        pos++; //increased the pos value by one 

    } // while 

     

    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");// Print out a bunch of new lines(clears the screen) 

    System.out.println(puzzle); //Prints out the string puzzle 

    System.out.println(); //Prints out a new line 

    System.out.println(); //Prints out a new line 

 
 

    char letter; //declares letter variable 

    int guesses = 0; //declares the int variable guesses and initializes it with the 0 value 

    while (!(puzzle.equals(phrase))){ //loops that runs till puzzle equals phrase 

        System.out.print("Guess a letter: "); //Prints out Guess a letter: to the command line 

        letter = scan.nextLine().toUpperCase().charAt(0); // takes in input, converts it to uppercase, then take the char at position 0 and assigns that value to letter 

        guesses++; //Increments guesses by 1  

 
 

        String newPuzzle = ""; //Creates an empty string named newPuzzle  

        pos=0;//Assigns pos variable 

        while (pos < phrase.length()) { // loop that runs till pos is no longer less then the length of the string phrase 

            if (letter == phrase.charAt(pos)) { // checks if char at (pos) in phrase meets the condition 

                newPuzzle += letter; // adds variable letter to new puzzle / if condition is met 

            } else {// runs if the first condition is not met 

                newPuzzle += puzzle.charAt(pos); // adds charAt (pos) in puzzle to newPuzzle 

            } 

            pos++;//increments the value of pos by 1 every time it loops 

        } 

        puzzle = newPuzzle; // assigns the value of newPuzzle to puzzle 

        System.out.println(); // prints an empty line 

        System.out.println(puzzle); // prints out puzzle 

    }     

 
 

 System.out.println(); // prints an empty line 

 System.out.println(" Hooray! It took you " + guesses + " guesses. \n\n\n"); // print out how many guesses it took the user 

 } 

} 