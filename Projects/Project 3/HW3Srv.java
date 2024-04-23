public class HW3Srv{

    public String createKey(String phrase){
        //changes the given string to uppercase
        phrase = phrase.toUpperCase();

        //declares and initializes the string key (the string the method returns)
        String key = "";

        //for loop that adds spaces after every character in phrase and adds that to key
        for (int x = 0; x<phrase.length();x++){

            key += phrase.charAt(x) + " ";

        }

        //returns key
        return key;
    }

    public char[] createPuzzle(String phrase){
        //changes the given string to uppercase
        phrase = phrase.toUpperCase();
        //creates an array that is double the length of phrase
        char puzzle[] = new char [phrase.length()*2];

        //for loop that replaces letters with underscores (leaving non letters like ! alone) and adds a space after)
        for (int x = 0; x<phrase.length();x++){

            if (Character.isLetter(phrase.charAt(x))){
                //if character is a letter, replace with _
                puzzle[x*2] = '_';
            }else{
                //if not a letter, keeps it
                puzzle[x*2] = phrase.charAt(x);
            }
            //adds a space at the end
            puzzle[(x*2) + 1] = ' ';

        }

        return puzzle;

    }

    public boolean isSolved(String key, char[] puzzle){
        boolean same = true;
        //return false if the length does not match
        if (key.length()!=puzzle.length){
            return false;
        }
        //changes variable same to false if any character in puzzle is different from the key
        for (int x = 0;x<key.length();x++){   

            if (key.charAt(x)!=puzzle[x]){
                same = false;
            }

        }

        return same;

    }

    public void checkGuess(char guess, String key, char[] puzzle){
        //goes through the key
     for (int x = 0;x<key.length();x++){
        //checks if the guess equals any characters in the key
        if (guess == key.charAt(x)){
            //replaces that spot in puzzle with the letter needed
            puzzle[x] = guess;
        }
     }
        
    }

}