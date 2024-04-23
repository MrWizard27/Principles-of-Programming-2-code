/***********************
 *
 *  Test driver for HW 3 - Wheel with methods
 *  tests the methods needed for a Wheel of Fortune game
 *
 *   Author:   Shawn Brenneman
 *   Date:     2015-Oct 11
 *
 ***********************/
 import java.util.Arrays;
 public class HW3TestDrv {

 public static void main(String[] args) {
    
    HW3Srv srvObj = new HW3Srv();

    final String PASS = "Pass";
    final String FAIL = "FAIL  - should be: \n     ";

    // Testing createPuzzle method 

    String tst1    = "";
    char[] expArr1 = {};

    String tst2    = "a";
    char[] expArr2 = {'_',' '};

    String tst3    = "Weeks of coding can save you hours of planning.";
    char[] expArr3 = "_ _ _ _ _   _ _   _ _ _ _ _ _   _ _ _   _ _ _ _   _ _ _   _ _ _ _ _   _ _   _ _ _ _ _ _ _ _ . ".toCharArray();

    String tst4    = "Less is more.";
    char[] expArr4 = "_ _ _ _   _ _   _ _ _ _ . ".toCharArray();

    String tst5    = "640K ought to be enough for anybody.";
    char[] expArr5 = "6 4 0 _   _ _ _ _ _   _ _   _ _   _ _ _ _ _ _   _ _ _   _ _ _ _ _ _ _ . ".toCharArray();


    char[] actArr1 = srvObj.createPuzzle(tst1);
    char[] actArr2 = srvObj.createPuzzle(tst2);
    char[] actArr3 = srvObj.createPuzzle(tst3);
    char[] actArr4 = srvObj.createPuzzle(tst4);
    char[] actArr5 = srvObj.createPuzzle(tst5);

    String result1 = Arrays.equals(actArr1,expArr1)? PASS : FAIL + "\"" + Arrays.toString(expArr1) + "\"";
    String result2 = Arrays.equals(actArr2,expArr2)? PASS : FAIL + "\"" + Arrays.toString(expArr2) + "\"";
    String result3 = Arrays.equals(actArr3,expArr3)? PASS : FAIL + "\"" + Arrays.toString(expArr3) + "\"";
    String result4 = Arrays.equals(actArr4,expArr4)? PASS : FAIL + "\"" + Arrays.toString(expArr4) + "\"";
    String result5 = Arrays.equals(actArr5,expArr5)? PASS : FAIL + "\"" + Arrays.toString(expArr5) + "\"";

    System.out.println("\n----------- Testing createPuzzle method ------------\n");
    System.out.println("createPuzzle(\""  + tst1 + "\")" + 
                       " --> \""  + Arrays.toString(actArr1) + "\"\t " + result1 + "\n"); 

    System.out.println("createPuzzle(\""  + tst2 + "\")" + 
                       " --> \""  + Arrays.toString(actArr2) + "\"\t " + result2 + "\n"); 

    System.out.println("createPuzzle(\""  + tst3 + "\")\n" + 
                       " --> \""  + Arrays.toString(actArr3) + "\"\t " + result3 + "\n"); 

    System.out.println("createPuzzle(\""  + tst4 + "\")\n" + 
                       " --> \""  + Arrays.toString(actArr4) + "\"\t " + result4 + "\n"); 

    System.out.println("createPuzzle(\""  + tst5 + "\")\n" + 
                       " --> \""  + Arrays.toString(actArr5) + "\"\t " + result5 + "\n"); 

    // Testing createKey method 

    String exp1 = "";
    String exp2 = "A ";
    String exp3 = "Q U E S T I O N   A U T H O R I T Y ;   B U T ,   R A I S E   Y O U R   H A N D   F I R S T . ";
    String exp4 = "P R O G R A M S   F O R   S A L E :   F A S T ,   R E L I A B L E ,   C H E A P :   C H O O S E   T W O . ";
    String exp5 = "6 4 0 K   O U G H T   T O   B E   E N O U G H   F O R   A N Y B O D Y . ";
    
    tst3 = "Question Authority; but, raise your hand first.";
    tst4 = "Programs for Sale: Fast, Reliable, Cheap: Choose two.";
    
    String act1 = srvObj.createKey(tst1);
    String act2 = srvObj.createKey(tst2);
    String act3 = srvObj.createKey(tst3);
    String act4 = srvObj.createKey(tst4);
    String act5 = srvObj.createKey(tst5);

    result1 = act1.equals(exp1)? PASS : FAIL + "\"" + exp1 + "\"";
    result2 = act2.equals(exp2)? PASS : FAIL + "\"" + exp2 + "\"";
    result3 = act3.equals(exp3)? PASS : FAIL + "\"" + exp3 + "\"";
    result4 = act4.equals(exp4)? PASS : FAIL + "\"" + exp4 + "\"";
    result5 = act5.equals(exp5)? PASS : FAIL + "\"" + exp5 + "\"";

    System.out.println("\n----------- Testing createKey method ------------\n");
    System.out.println("createKey(\""  + tst1 + "\")" + 
                       " --> \""  + act1 + "\"\t " + result1 + "\n"); 

    System.out.println("createKey(\""  + tst2 + "\")" + 
                       " --> \""  + act2 + "\"\t " + result2 + "\n"); 

    System.out.println("createKey(\""  + tst3 + "\")\n" + 
                       " --> \""  + act3 + "\"\t " + result3 + "\n"); 

    System.out.println("createKey(\""  + tst4 + "\")\n" + 
                       " --> \""  + act4 + "\"\t " + result4 + "\n"); 

    System.out.println("createKey(\""  + tst5 + "\")\n" + 
                       " --> \""  + act5 + "\"\t " + result5 + "\n"); 

    // Testing isSolved method

    exp1        = "";
    char[] arr1 = {};
    exp2        = "C ";
    char[] arr2 = "C ".toCharArray();;
    exp3        = "L E S S   I S   M O R E . ";
    char[] arr3 = "L E _ _   I _   M O R E . ".toCharArray();
    exp4        = "Not the same length.";
    char[] arr4 = "BLIP. ".toCharArray();
    exp5        = "";
    char[] arr5 = "some stuff".toCharArray();

    boolean booAct1 = srvObj.isSolved(exp1,arr1);
    boolean booAct2 = srvObj.isSolved(exp2,arr2);
    boolean booAct3 = srvObj.isSolved(exp3,arr3);
    boolean booAct4 = srvObj.isSolved(exp4,arr4);
    boolean booAct5 = srvObj.isSolved(exp3,arr3);

    result1 =  booAct1? PASS : FAIL + "true";
    result2 =  booAct2? PASS : FAIL + "true";
    result3 = !booAct3? PASS : FAIL + "false";
    result4 = !booAct4? PASS : FAIL + "false";
    result5 = !booAct5? PASS : FAIL + "false";

    System.out.println("\n----------- Testing isSolved method ------------\n");
    System.out.println("isSolved(\""  + exp1 + "\", " + Arrays.toString(arr1) + ")" + 
                       " --> \""  + booAct1 + "\"\t\t " + result1 + "\n"); 

    System.out.println("isSolved(\""  + exp2 + "\", " + Arrays.toString(arr2) + ")" + 
                       " --> \""  + booAct2 + "\"\t " + result2 + "\n"); 

    System.out.println("isSolved(\""  + exp3 + "\", " + Arrays.toString(arr3) + ")\n" + 
                       " --> \""  + booAct3 + "\"\t " + result3 + "\n"); 

    System.out.println("isSolved(\""  + exp4 + "\", " + Arrays.toString(arr4) + ")\n" + 
                       " --> \""  + booAct4 + "\"\t " + result4 + "\n"); 

    System.out.println("isSolved(\""  + exp5 + "\", " + Arrays.toString(arr5) + ")\n" + 
                       " --> \""  + booAct5 + "\"\t " + result5 + "\n"); 

    // Testing isSolved method

    String key1 = "";
    String key2 = "H I   H O ";
    String key3 = "L E S S   I S   M O R E . ";

    char[] puzzle1 = {};
    char[] puzzle2 = "_ _   _ _ ".toCharArray();
    char[] puzzle3 = "H _   H _ ".toCharArray();
    char[] puzzle4 = "H _   H O ".toCharArray();

    srvObj.checkGuess('F', key1, puzzle1);
    result1 = Arrays.equals(puzzle1, new char[] {})? PASS : FAIL + Arrays.toString(new char[] {}) ;

    System.out.println("\n----------- Testing checkGuess method ------------\n");
    System.out.println("checkGuess('F',\"" + key1 + "\"," + Arrays.toString(puzzle1) + ")" + 
                       " --> "  + result1 + "\n"); 
    
    srvObj.checkGuess('F', key1, puzzle2);
    result2 = Arrays.equals(puzzle2, "_ _   _ _ ".toCharArray())? PASS : FAIL 
            + Arrays.toString("_ _   _ _ ".toCharArray());

    System.out.println("checkGuess('F',\"" + key1 + "\"," + Arrays.toString(puzzle2) + ")" + 
                       " --> "  + result2 + "\n"); 
    
    srvObj.checkGuess('F', key2, puzzle1);
    result3 = Arrays.equals(puzzle1, new char[] {})? PASS : FAIL 
            + Arrays.toString(new char[] {});

    System.out.println("checkGuess('F',\"" + key2 + "\"," + Arrays.toString(new char[] {}) + ")" + 
                       " --> "  + result3 + "\n"); 

    srvObj.checkGuess('H', key2, puzzle2);
    result4 = Arrays.equals(puzzle2, puzzle3)? PASS : FAIL 
            + Arrays.toString(puzzle3);

    System.out.println("checkGuess('H',\"" + key2 + "\"," + 
                       Arrays.toString("_ _   _ _ ".toCharArray()) + ")" + 
                       " --> "  + result4 + "\n"); 

    srvObj.checkGuess('O', key2, puzzle3);
    result5 = Arrays.equals(puzzle3, puzzle4)? PASS : FAIL 
            + Arrays.toString(puzzle4);

    System.out.println("checkGuess('O',\"" + key2 + "\"," + 
                       Arrays.toString("H _   H _ ".toCharArray()) + ")" + 
                       " --> "  + result5 + "\n"); 
    System.out.println("\n\n");


 } //main 

 }
