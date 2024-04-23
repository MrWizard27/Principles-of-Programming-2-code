import java.util.*;

public class GameLogicTestDrv {

public static void resetTiles(Tile[] tiles) {
    for (int ii = 1; ii <= 9; ii++) {
        tiles[ii].setState(Tile.AVAILABLE);
    }
}

public static void flipTiles(Tile[] tiles) {
    for (int ii = 1; ii <= 9; ii++) {
        tiles[ii].setState(Tile.FLIPPED);
    }
}

public static String diceString(Die die1, Die die2) {
    return "Dice sum: " + (die1.getValue() + die2.getValue())
           + " (Die1: " + die1.getValue()
           + " Die2: " + die2.getValue()
           + ") ";
}

public static String tileNotFlippedString(Tile[] tiles) {
    String returnString = "";
    for (int ii = 1; ii <= 9; ii++) {
        if (tiles[ii].getState() != Tile.FLIPPED) {
            if (returnString.length() > 0) {
                returnString += ' ';
            }
            returnString += ii;
        }
    }
    return "Tiles not Flipped: " + returnString + ")";
}

public static String tileSelectedString(Tile[] tiles) {
    int total = 0;
    String returnString = "";
    for (int ii = 1; ii <= 9; ii++) {
        if (tiles[ii].getState() == Tile.SELECTED) {
            total += ii;
            if (returnString.length() > 0) {
                returnString += ' ';
            }
            returnString += ii;
        }
    }
    return "Tile sum: " + total + " (Tiles selected: " + returnString + ")";
}

public static String tileSelAndAvailString(Tile[] tiles) {
    int total = 0;
    String selectedString = "";
    String availableString = "";
    for (int ii = 1; ii <= 9; ii++) {
        if (tiles[ii].getState() == Tile.SELECTED) {
            total += ii;
            if (selectedString.length() > 0) {
                selectedString += ' ';
            }
            selectedString += ii;
        } else if (tiles[ii].getState() == Tile.AVAILABLE) {
            if (availableString.length() > 0) {
                availableString += ' ';
            }
            availableString += ii;
        }
    }
    return "Tile sum: " + total + " (Tiles selected: " + selectedString + " Tiles available: " + availableString + ")";
}

public static void main(String args[]) {
    Die die1 = new Die();
    Die die2 = new Die();

    Tile[] tiles = new Tile[10];

    for (int ii = 1; ii <= 9; ii++) {
        tiles[ii] = new Tile(ii);
    }

    boolean sumsAreEqualPassed = true;

    System.out.println("================================================================================");
    System.out.println("  TESTING sumsAreEqual");
    System.out.println("--------------------------------------------------------------------------------");

    // ---------- 1 PASS -----------------------------------------------
    resetTiles(tiles);
    die1.setValue(0);
    die2.setValue(1);
    tiles[1].setState(Tile.SELECTED);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("      sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
    } else {
        System.out.println("FAIL: sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    }

    resetTiles(tiles);
    die1.setValue(1);
    die2.setValue(0);
    tiles[1].setState(Tile.SELECTED);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("      sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
    } else {
        System.out.println("FAIL: sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    }

    // ---------- 2 PASS -----------------------------------------------
    resetTiles(tiles);
    die1.setValue(2);
    die2.setValue(0);
    tiles[2].setState(Tile.SELECTED);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("      sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
    } else {
        System.out.println("FAIL: sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    }

    resetTiles(tiles);
    die1.setValue(0);
    die2.setValue(2);
    tiles[2].setState(Tile.SELECTED);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("      sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
    } else {
        System.out.println("FAIL: sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    }

    resetTiles(tiles);
    die1.setValue(1);
    die2.setValue(1);
    tiles[2].setState(Tile.SELECTED);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("      sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
    } else {
        System.out.println("FAIL: sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    }

    // ---------- 3 PASS -----------------------------------------------
    resetTiles(tiles);
    die1.setValue(0);
    die2.setValue(3);
    tiles[1].setState(Tile.SELECTED);
    tiles[2].setState(Tile.SELECTED);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("      sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
    } else {
        System.out.println("FAIL: sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    }

    resetTiles(tiles);
    die1.setValue(3);
    die2.setValue(0);
    tiles[3].setState(Tile.SELECTED);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("      sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
    } else {
        System.out.println("FAIL: sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    }
    resetTiles(tiles);
    die1.setValue(2);
    die2.setValue(1);
    tiles[2].setState(Tile.SELECTED);
    tiles[1].setState(Tile.SELECTED);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("      sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
    } else {
        System.out.println("FAIL: sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    }

    // ---------- 4 PASS -----------------------------------------------
    resetTiles(tiles);
    die1.setValue(0);
    die2.setValue(4);
    tiles[4].setState(Tile.SELECTED);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("      sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
    } else {
        System.out.println("FAIL: sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    }

    resetTiles(tiles);
    die1.setValue(4);
    die2.setValue(0);
    tiles[3].setState(Tile.SELECTED);
    tiles[1].setState(Tile.SELECTED);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("      sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
    } else {
        System.out.println("FAIL: sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    }
    resetTiles(tiles);
    die1.setValue(2);
    die2.setValue(2);
    tiles[4].setState(Tile.SELECTED);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("      sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
    } else {
        System.out.println("FAIL: sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    }

    resetTiles(tiles);
    die1.setValue(3);
    die2.setValue(1);
    tiles[1].setState(Tile.SELECTED);
    tiles[3].setState(Tile.SELECTED);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("      sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
    } else {
        System.out.println("FAIL: sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    }

    // ---------- 7 PASS -----------------------------------------------
    resetTiles(tiles);
    die1.setValue(1);
    die2.setValue(6);
    tiles[5].setState(Tile.SELECTED);
    tiles[2].setState(Tile.SELECTED);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("      sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
    } else {
        System.out.println("FAIL: sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    }

    resetTiles(tiles);
    die1.setValue(6);
    die2.setValue(1);
    tiles[6].setState(Tile.SELECTED);
    tiles[1].setState(Tile.SELECTED);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("      sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
    } else {
        System.out.println("FAIL: sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    }

    resetTiles(tiles);
    die1.setValue(3);
    die2.setValue(4);
    tiles[7].setState(Tile.SELECTED);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("      sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
    } else {
        System.out.println("FAIL: sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    }

    resetTiles(tiles);
    die1.setValue(4);
    die2.setValue(3);
    tiles[4].setState(Tile.SELECTED);
    tiles[3].setState(Tile.SELECTED);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("      sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
    } else {
        System.out.println("FAIL: sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    }

    resetTiles(tiles);
    die1.setValue(2);
    die2.setValue(5);
    tiles[4].setState(Tile.SELECTED);
    tiles[2].setState(Tile.SELECTED);
    tiles[1].setState(Tile.SELECTED);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("      sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
    } else {
        System.out.println("FAIL: sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    }

    // ---------- 12 PASS -----------------------------------------------
    resetTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    tiles[1].setState(Tile.SELECTED);
    tiles[2].setState(Tile.SELECTED);
    tiles[3].setState(Tile.SELECTED);
    tiles[6].setState(Tile.SELECTED);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("      sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
    } else {
        System.out.println("FAIL: sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    }

    resetTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    tiles[1].setState(Tile.SELECTED);
    tiles[2].setState(Tile.SELECTED);
    tiles[4].setState(Tile.SELECTED);
    tiles[5].setState(Tile.SELECTED);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("      sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
    } else {
        System.out.println("FAIL: sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    }
    resetTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    tiles[1].setState(Tile.SELECTED);
    tiles[2].setState(Tile.SELECTED);
    tiles[9].setState(Tile.SELECTED);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("      sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
    } else {
        System.out.println("FAIL: sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    }

    resetTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    tiles[3].setState(Tile.SELECTED);
    tiles[9].setState(Tile.SELECTED);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("      sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
    } else {
        System.out.println("FAIL: sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    }

    resetTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    tiles[5].setState(Tile.SELECTED);
    tiles[7].setState(Tile.SELECTED);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("      sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
    } else {
        System.out.println("FAIL: sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    }

    // ---------- 1 FAIL -----------------------------------------------
    resetTiles(tiles);
    die1.setValue(0);
    die2.setValue(1);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("FAIL: sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    } else {
        System.out.println("      sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
    }

    resetTiles(tiles);
    die1.setValue(1);
    die2.setValue(0);
    tiles[2].setState(Tile.SELECTED);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("FAIL: sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    } else {
        System.out.println("      sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
    }

    // ---------- 2 FAIL -----------------------------------------------
    resetTiles(tiles);
    die1.setValue(2);
    die2.setValue(0);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("FAIL: sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    } else {
        System.out.println("      sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
    }

    resetTiles(tiles);
    die1.setValue(0);
    die2.setValue(2);
    tiles[1].setState(Tile.SELECTED);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("FAIL: sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    } else {
        System.out.println("      sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
    }

    resetTiles(tiles);
    die1.setValue(1);
    die2.setValue(1);
    tiles[1].setState(Tile.SELECTED);
    tiles[2].setState(Tile.SELECTED);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("FAIL: sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    } else {
        System.out.println("      sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
    }

    // ---------- 3 FAIL -----------------------------------------------
    resetTiles(tiles);
    die1.setValue(0);
    die2.setValue(3);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("FAIL: sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    } else {
        System.out.println("      sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
    }

    resetTiles(tiles);
    die1.setValue(3);
    die2.setValue(0);
    tiles[1].setState(Tile.SELECTED);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("FAIL: sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    } else {
        System.out.println("      sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
    }

    resetTiles(tiles);
    die1.setValue(2);
    die2.setValue(1);
    tiles[3].setState(Tile.SELECTED);
    tiles[9].setState(Tile.SELECTED);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("FAIL: sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    } else {
        System.out.println("      sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
    }

    // ---------- 4 FAIL -----------------------------------------------
    resetTiles(tiles);
    die1.setValue(0);
    die2.setValue(4);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("FAIL: sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    } else {
        System.out.println("      sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
    }

    resetTiles(tiles);
    die1.setValue(4);
    die2.setValue(0);
    tiles[3].setState(Tile.SELECTED);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("FAIL: sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    } else {
        System.out.println("      sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
    }
    resetTiles(tiles);
    die1.setValue(2);
    die2.setValue(2);
    tiles[5].setState(Tile.SELECTED);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("FAIL: sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    } else {
        System.out.println("      sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
    }

    resetTiles(tiles);
    die1.setValue(3);
    die2.setValue(1);
    tiles[1].setState(Tile.SELECTED);
    tiles[3].setState(Tile.SELECTED);
    tiles[4].setState(Tile.SELECTED);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("FAIL: sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    } else {
        System.out.println("      sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
    }

    // ---------- 7 FAIL -----------------------------------------------
    resetTiles(tiles);
    die1.setValue(1);
    die2.setValue(6);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("FAIL: sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    } else {
        System.out.println("      sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
    }

    resetTiles(tiles);
    die1.setValue(6);
    die2.setValue(1);
    tiles[1].setState(Tile.SELECTED);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("FAIL: sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    } else {
        System.out.println("      sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
    }
    resetTiles(tiles);
    die1.setValue(3);
    die2.setValue(4);
    tiles[9].setState(Tile.SELECTED);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("FAIL: sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    } else {
        System.out.println("      sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
    }

    resetTiles(tiles);
    die1.setValue(4);
    die2.setValue(3);
    tiles[1].setState(Tile.SELECTED);
    tiles[3].setState(Tile.SELECTED);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("FAIL: sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    } else {
        System.out.println("      sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
    }

    resetTiles(tiles);
    die1.setValue(2);
    die2.setValue(5);
    tiles[1].setState(Tile.SELECTED);
    tiles[2].setState(Tile.SELECTED);
    tiles[3].setState(Tile.SELECTED);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("FAIL: sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    } else {
        System.out.println("      sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
    }

    // ---------- 12 FAIL -----------------------------------------------
    resetTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("FAIL: sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    } else {
        System.out.println("      sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
    }

    resetTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    tiles[6].setState(Tile.SELECTED);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("FAIL: sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    } else {
        System.out.println("      sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
    }

    resetTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    tiles[5].setState(Tile.SELECTED);
    tiles[8].setState(Tile.SELECTED);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("FAIL: sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    } else {
        System.out.println("      sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
    }

    resetTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    tiles[1].setState(Tile.SELECTED);
    tiles[2].setState(Tile.SELECTED);
    tiles[3].setState(Tile.SELECTED);
    tiles[4].setState(Tile.SELECTED);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("FAIL: sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    } else {
        System.out.println("      sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
    }

    resetTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    tiles[1].setState(Tile.SELECTED);
    tiles[2].setState(Tile.SELECTED);
    tiles[4].setState(Tile.SELECTED);
    tiles[6].setState(Tile.SELECTED);
    if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
        System.out.println("FAIL: sumsAreEqual returns true:  " + diceString(die1, die2) + tileSelectedString(tiles));
        sumsAreEqualPassed = false;
    } else {
        System.out.println("      sumsAreEqual returns false: " + diceString(die1, die2) + tileSelectedString(tiles));
    }

    System.out.println();
    if (sumsAreEqualPassed) {
        System.out.println("*** YES!!  sumsAreEqual passes tests (which are not comprehensive, but a pretty good representation)!\n");
    }

    boolean playerHasWonPassed = true;

    System.out.println("================================================================================");
    System.out.println("  TESTING playerHasWon");
    System.out.println("--------------------------------------------------------------------------------");

    // ---------- 1 PASS -----------------------------------------------
    flipTiles(tiles);
    die1.setValue(0);
    die2.setValue(1);
    tiles[1].setState(Tile.SELECTED);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("      playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    } else {
        System.out.println("FAIL: playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    }

    flipTiles(tiles);
    die1.setValue(1);
    die2.setValue(0);
    tiles[1].setState(Tile.SELECTED);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("      playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    } else {
        System.out.println("FAIL: playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    }

    // ---------- 2 PASS -----------------------------------------------
    flipTiles(tiles);
    die1.setValue(2);
    die2.setValue(0);
    tiles[2].setState(Tile.SELECTED);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("      playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    } else {
        System.out.println("FAIL: playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    }

    flipTiles(tiles);
    die1.setValue(0);
    die2.setValue(2);
    tiles[2].setState(Tile.SELECTED);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("      playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    } else {
        System.out.println("FAIL: playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    }

    flipTiles(tiles);
    die1.setValue(1);
    die2.setValue(1);
    tiles[2].setState(Tile.SELECTED);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("      playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    } else {
        System.out.println("FAIL: playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    }

    // ---------- 3 PASS -----------------------------------------------
    flipTiles(tiles);
    die1.setValue(0);
    die2.setValue(3);
    tiles[1].setState(Tile.SELECTED);
    tiles[2].setState(Tile.SELECTED);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("      playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    } else {
        System.out.println("FAIL: playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    }

    flipTiles(tiles);
    die1.setValue(3);
    die2.setValue(0);
    tiles[3].setState(Tile.SELECTED);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("      playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    } else {
        System.out.println("FAIL: playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    }
    flipTiles(tiles);
    die1.setValue(2);
    die2.setValue(1);
    tiles[2].setState(Tile.SELECTED);
    tiles[1].setState(Tile.SELECTED);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("      playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    } else {
        System.out.println("FAIL: playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    }

    // ---------- 4 PASS -----------------------------------------------
    flipTiles(tiles);
    die1.setValue(0);
    die2.setValue(4);
    tiles[4].setState(Tile.SELECTED);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("      playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    } else {
        System.out.println("FAIL: playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    }

    flipTiles(tiles);
    die1.setValue(4);
    die2.setValue(0);
    tiles[3].setState(Tile.SELECTED);
    tiles[1].setState(Tile.SELECTED);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("      playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    } else {
        System.out.println("FAIL: playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    }
    flipTiles(tiles);
    die1.setValue(2);
    die2.setValue(2);
    tiles[4].setState(Tile.SELECTED);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("      playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    } else {
        System.out.println("FAIL: playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    }

    flipTiles(tiles);
    die1.setValue(3);
    die2.setValue(1);
    tiles[1].setState(Tile.SELECTED);
    tiles[3].setState(Tile.SELECTED);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("      playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    } else {
        System.out.println("FAIL: playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    }

    // ---------- 7 PASS -----------------------------------------------
    flipTiles(tiles);
    die1.setValue(1);
    die2.setValue(6);
    tiles[5].setState(Tile.SELECTED);
    tiles[2].setState(Tile.SELECTED);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("      playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    } else {
        System.out.println("FAIL: playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    }

    flipTiles(tiles);
    die1.setValue(6);
    die2.setValue(1);
    tiles[6].setState(Tile.SELECTED);
    tiles[1].setState(Tile.SELECTED);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("      playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    } else {
        System.out.println("FAIL: playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    }

    flipTiles(tiles);
    die1.setValue(3);
    die2.setValue(4);
    tiles[7].setState(Tile.SELECTED);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("      playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    } else {
        System.out.println("FAIL: playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    }

    flipTiles(tiles);
    die1.setValue(4);
    die2.setValue(3);
    tiles[4].setState(Tile.SELECTED);
    tiles[3].setState(Tile.SELECTED);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("      playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    } else {
        System.out.println("FAIL: playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    }

    flipTiles(tiles);
    die1.setValue(2);
    die2.setValue(5);
    tiles[4].setState(Tile.SELECTED);
    tiles[2].setState(Tile.SELECTED);
    tiles[1].setState(Tile.SELECTED);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("      playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    } else {
        System.out.println("FAIL: playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    }

    // ---------- 12 PASS -----------------------------------------------
    flipTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    tiles[1].setState(Tile.SELECTED);
    tiles[2].setState(Tile.SELECTED);
    tiles[3].setState(Tile.SELECTED);
    tiles[6].setState(Tile.SELECTED);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("      playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    } else {
        System.out.println("FAIL: playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    }

    flipTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    tiles[1].setState(Tile.SELECTED);
    tiles[2].setState(Tile.SELECTED);
    tiles[4].setState(Tile.SELECTED);
    tiles[5].setState(Tile.SELECTED);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("      playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    } else {
        System.out.println("FAIL: playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    }
    flipTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    tiles[1].setState(Tile.SELECTED);
    tiles[2].setState(Tile.SELECTED);
    tiles[9].setState(Tile.SELECTED);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("      playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    } else {
        System.out.println("FAIL: playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    }

    flipTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    tiles[3].setState(Tile.SELECTED);
    tiles[9].setState(Tile.SELECTED);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("      playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    } else {
        System.out.println("FAIL: playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    }

    flipTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    tiles[5].setState(Tile.SELECTED);
    tiles[7].setState(Tile.SELECTED);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("      playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    } else {
        System.out.println("FAIL: playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    }

    // ---------- 1 FAIL (tile left) -----------------------------------------------
    flipTiles(tiles);
    die1.setValue(0);
    die2.setValue(1);
    tiles[1].setState(Tile.SELECTED);
    tiles[2].setState(Tile.AVAILABLE);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }

    flipTiles(tiles);
    die1.setValue(1);
    die2.setValue(0);
    tiles[1].setState(Tile.SELECTED);
    tiles[9].setState(Tile.AVAILABLE);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }

    // ---------- 2 FAIL (tile left) -----------------------------------------------
    flipTiles(tiles);
    die1.setValue(2);
    die2.setValue(0);
    tiles[2].setState(Tile.SELECTED);
    tiles[1].setState(Tile.AVAILABLE);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }

    flipTiles(tiles);
    die1.setValue(0);
    die2.setValue(2);
    tiles[2].setState(Tile.SELECTED);
    tiles[3].setState(Tile.AVAILABLE);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }

    flipTiles(tiles);
    die1.setValue(1);
    die2.setValue(1);
    tiles[2].setState(Tile.SELECTED);
    tiles[4].setState(Tile.AVAILABLE);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }

    // ---------- 3 FAIL (tile left) -----------------------------------------------
    flipTiles(tiles);
    die1.setValue(0);
    die2.setValue(3);
    tiles[1].setState(Tile.SELECTED);
    tiles[2].setState(Tile.SELECTED);
    tiles[5].setState(Tile.AVAILABLE);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }

    flipTiles(tiles);
    die1.setValue(3);
    die2.setValue(0);
    tiles[3].setState(Tile.SELECTED);
    tiles[6].setState(Tile.AVAILABLE);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }
    flipTiles(tiles);
    die1.setValue(2);
    die2.setValue(1);
    tiles[2].setState(Tile.SELECTED);
    tiles[1].setState(Tile.SELECTED);
    tiles[7].setState(Tile.AVAILABLE);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }

    // ---------- 4 FAIL (tile left) -----------------------------------------------
    flipTiles(tiles);
    die1.setValue(0);
    die2.setValue(4);
    tiles[4].setState(Tile.SELECTED);
    tiles[8].setState(Tile.AVAILABLE);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }

    flipTiles(tiles);
    die1.setValue(4);
    die2.setValue(0);
    tiles[3].setState(Tile.SELECTED);
    tiles[1].setState(Tile.SELECTED);
    tiles[2].setState(Tile.AVAILABLE);
    tiles[4].setState(Tile.AVAILABLE);
    tiles[5].setState(Tile.AVAILABLE);
    tiles[6].setState(Tile.AVAILABLE);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }
    flipTiles(tiles);
    die1.setValue(2);
    die2.setValue(2);
    tiles[4].setState(Tile.SELECTED);
    tiles[6].setState(Tile.AVAILABLE);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }

    flipTiles(tiles);
    die1.setValue(3);
    die2.setValue(1);
    tiles[1].setState(Tile.SELECTED);
    tiles[3].setState(Tile.SELECTED);
    tiles[6].setState(Tile.AVAILABLE);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }

    // ---------- 7 FAIL (tile left) -----------------------------------------------
    flipTiles(tiles);
    die1.setValue(1);
    die2.setValue(6);
    tiles[5].setState(Tile.SELECTED);
    tiles[2].setState(Tile.SELECTED);
    tiles[6].setState(Tile.AVAILABLE);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }

    flipTiles(tiles);
    die1.setValue(6);
    die2.setValue(1);
    tiles[6].setState(Tile.SELECTED);
    tiles[1].setState(Tile.SELECTED);
    tiles[7].setState(Tile.AVAILABLE);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }

    flipTiles(tiles);
    die1.setValue(3);
    die2.setValue(4);
    tiles[7].setState(Tile.SELECTED);
    tiles[6].setState(Tile.AVAILABLE);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }

    flipTiles(tiles);
    die1.setValue(4);
    die2.setValue(3);
    tiles[4].setState(Tile.SELECTED);
    tiles[3].setState(Tile.SELECTED);
    tiles[6].setState(Tile.AVAILABLE);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }

    flipTiles(tiles);
    die1.setValue(2);
    die2.setValue(5);
    tiles[4].setState(Tile.SELECTED);
    tiles[2].setState(Tile.SELECTED);
    tiles[1].setState(Tile.SELECTED);
    tiles[6].setState(Tile.AVAILABLE);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }

    // ---------- 12 FAIL (tile left) -----------------------------------------------
    flipTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    tiles[1].setState(Tile.SELECTED);
    tiles[2].setState(Tile.SELECTED);
    tiles[3].setState(Tile.SELECTED);
    tiles[6].setState(Tile.SELECTED);
    tiles[9].setState(Tile.AVAILABLE);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }

    flipTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    tiles[1].setState(Tile.SELECTED);
    tiles[2].setState(Tile.SELECTED);
    tiles[4].setState(Tile.SELECTED);
    tiles[5].setState(Tile.SELECTED);
    tiles[6].setState(Tile.AVAILABLE);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }
    flipTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    tiles[1].setState(Tile.SELECTED);
    tiles[2].setState(Tile.SELECTED);
    tiles[9].setState(Tile.SELECTED);
    tiles[6].setState(Tile.AVAILABLE);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }

    flipTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    tiles[3].setState(Tile.SELECTED);
    tiles[9].setState(Tile.SELECTED);
    tiles[6].setState(Tile.AVAILABLE);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }

    flipTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    tiles[5].setState(Tile.SELECTED);
    tiles[7].setState(Tile.SELECTED);
    tiles[6].setState(Tile.AVAILABLE);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }

    // ---------- 1 FAIL (not equal) -----------------------------------------------
    flipTiles(tiles);
    die1.setValue(0);
    die2.setValue(1);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }

    flipTiles(tiles);
    die1.setValue(1);
    die2.setValue(0);
    tiles[2].setState(Tile.SELECTED);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }

    // ---------- 2 FAIL (not equal) -----------------------------------------------
    flipTiles(tiles);
    die1.setValue(2);
    die2.setValue(0);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }

    flipTiles(tiles);
    die1.setValue(0);
    die2.setValue(2);
    tiles[1].setState(Tile.SELECTED);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }

    flipTiles(tiles);
    die1.setValue(1);
    die2.setValue(1);
    tiles[1].setState(Tile.SELECTED);
    tiles[2].setState(Tile.SELECTED);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }

    // ---------- 3 FAIL (not equal) -----------------------------------------------
    flipTiles(tiles);
    die1.setValue(0);
    die2.setValue(3);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }

    flipTiles(tiles);
    die1.setValue(3);
    die2.setValue(0);
    tiles[1].setState(Tile.SELECTED);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }

    flipTiles(tiles);
    die1.setValue(2);
    die2.setValue(1);
    tiles[3].setState(Tile.SELECTED);
    tiles[9].setState(Tile.SELECTED);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }

    // ---------- 4 FAIL (not equal) -----------------------------------------------
    flipTiles(tiles);
    die1.setValue(0);
    die2.setValue(4);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }

    flipTiles(tiles);
    die1.setValue(4);
    die2.setValue(0);
    tiles[3].setState(Tile.SELECTED);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }
    flipTiles(tiles);
    die1.setValue(2);
    die2.setValue(2);
    tiles[5].setState(Tile.SELECTED);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }

    flipTiles(tiles);
    die1.setValue(3);
    die2.setValue(1);
    tiles[1].setState(Tile.SELECTED);
    tiles[3].setState(Tile.SELECTED);
    tiles[4].setState(Tile.SELECTED);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }

    // ---------- 7 FAIL (not equal) -----------------------------------------------
    flipTiles(tiles);
    die1.setValue(1);
    die2.setValue(6);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }

    flipTiles(tiles);
    die1.setValue(6);
    die2.setValue(1);
    tiles[1].setState(Tile.SELECTED);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }
    flipTiles(tiles);
    die1.setValue(3);
    die2.setValue(4);
    tiles[9].setState(Tile.SELECTED);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }

    flipTiles(tiles);
    die1.setValue(4);
    die2.setValue(3);
    tiles[1].setState(Tile.SELECTED);
    tiles[3].setState(Tile.SELECTED);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }

    flipTiles(tiles);
    die1.setValue(2);
    die2.setValue(5);
    tiles[1].setState(Tile.SELECTED);
    tiles[2].setState(Tile.SELECTED);
    tiles[3].setState(Tile.SELECTED);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }

    // ---------- 12 FAIL (not equal) -----------------------------------------------
    flipTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }

    flipTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    tiles[6].setState(Tile.SELECTED);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }

    flipTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    tiles[5].setState(Tile.SELECTED);
    tiles[8].setState(Tile.SELECTED);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }

    flipTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    tiles[1].setState(Tile.SELECTED);
    tiles[2].setState(Tile.SELECTED);
    tiles[3].setState(Tile.SELECTED);
    tiles[4].setState(Tile.SELECTED);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }

    flipTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    tiles[1].setState(Tile.SELECTED);
    tiles[2].setState(Tile.SELECTED);
    tiles[4].setState(Tile.SELECTED);
    tiles[6].setState(Tile.SELECTED);
    if (GameLogic.playerHasWon(tiles, die1, die2)) {
        System.out.println("FAIL: playerHasWon returns true:  " + diceString(die1, die2) + tileSelAndAvailString(tiles));
        playerHasWonPassed = false;
    } else {
        System.out.println("      playerHasWon returns false: " + diceString(die1, die2) + tileSelAndAvailString(tiles));
    }

    System.out.println();
    if (playerHasWonPassed) {
        System.out.println("*** YES!!  playerHasWon passes tests (which are not comprehensive, but a pretty good representation)!\n");
    }

    boolean flipIsPossiblePassed = true;

    System.out.println("================================================================================");
    System.out.println("  TESTING flipIsPossible");
    System.out.println("--------------------------------------------------------------------------------");

    // ---------- 1 PASS -----------------------------------------------
    resetTiles(tiles);
    die1.setValue(0);
    die2.setValue(1);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("      flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
    } else {
        System.out.println("FAIL: flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    }

    flipTiles(tiles);
    die1.setValue(1);
    die2.setValue(0);
    tiles[1].setState(Tile.AVAILABLE);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("      flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
    } else {
        System.out.println("FAIL: flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    }

    flipTiles(tiles);
    die1.setValue(1);
    die2.setValue(0);
    tiles[1].setState(Tile.AVAILABLE);
    tiles[7].setState(Tile.AVAILABLE);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("      flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
    } else {
        System.out.println("FAIL: flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    }

    // ---------- 6 PASS -----------------------------------------------
    resetTiles(tiles);
    die1.setValue(0);
    die2.setValue(6);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("      flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
    } else {
        System.out.println("FAIL: flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    }

    flipTiles(tiles);
    die1.setValue(6);
    die2.setValue(0);
    tiles[6].setState(Tile.AVAILABLE);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("      flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
    } else {
        System.out.println("FAIL: flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    }

    flipTiles(tiles);
    die1.setValue(5);
    die2.setValue(1);
    tiles[1].setState(Tile.AVAILABLE);
    tiles[5].setState(Tile.AVAILABLE);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("      flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
    } else {
        System.out.println("FAIL: flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    }

    flipTiles(tiles);
    die1.setValue(5);
    die2.setValue(1);
    tiles[1].setState(Tile.AVAILABLE);
    tiles[5].setState(Tile.AVAILABLE);
    tiles[6].setState(Tile.AVAILABLE);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("      flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
    } else {
        System.out.println("FAIL: flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    }

    flipTiles(tiles);
    die1.setValue(4);
    die2.setValue(2);
    tiles[2].setState(Tile.AVAILABLE);
    tiles[4].setState(Tile.AVAILABLE);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("      flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
    } else {
        System.out.println("FAIL: flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    }

    flipTiles(tiles);
    die1.setValue(4);
    die2.setValue(2);
    tiles[2].setState(Tile.AVAILABLE);
    tiles[4].setState(Tile.AVAILABLE);
    tiles[7].setState(Tile.AVAILABLE);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("      flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
    } else {
        System.out.println("FAIL: flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    }

    flipTiles(tiles);
    die1.setValue(3);
    die2.setValue(3);
    tiles[1].setState(Tile.AVAILABLE);
    tiles[2].setState(Tile.AVAILABLE);
    tiles[3].setState(Tile.AVAILABLE);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("      flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
    } else {
        System.out.println("FAIL: flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    }

    // ---------- 7 PASS -----------------------------------------------
    resetTiles(tiles);
    die1.setValue(1);
    die2.setValue(6);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("      flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
    } else {
        System.out.println("FAIL: flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    }

    flipTiles(tiles);
    die1.setValue(6);
    die2.setValue(1);
    tiles[7].setState(Tile.AVAILABLE);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("      flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
    } else {
        System.out.println("FAIL: flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    }

    flipTiles(tiles);
    die1.setValue(5);
    die2.setValue(2);
    tiles[1].setState(Tile.AVAILABLE);
    tiles[6].setState(Tile.AVAILABLE);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("      flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
    } else {
        System.out.println("FAIL: flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    }

    flipTiles(tiles);
    die1.setValue(5);
    die2.setValue(2);
    tiles[1].setState(Tile.AVAILABLE);
    tiles[2].setState(Tile.AVAILABLE);
    tiles[6].setState(Tile.AVAILABLE);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("      flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
    } else {
        System.out.println("FAIL: flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    }

    flipTiles(tiles);
    die1.setValue(4);
    die2.setValue(3);
    tiles[2].setState(Tile.AVAILABLE);
    tiles[5].setState(Tile.AVAILABLE);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("      flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
    } else {
        System.out.println("FAIL: flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    }

    flipTiles(tiles);
    die1.setValue(4);
    die2.setValue(3);
    tiles[2].setState(Tile.AVAILABLE);
    tiles[4].setState(Tile.AVAILABLE);
    tiles[5].setState(Tile.AVAILABLE);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("      flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
    } else {
        System.out.println("FAIL: flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    }

    flipTiles(tiles);
    die1.setValue(3);
    die2.setValue(4);
    tiles[1].setState(Tile.AVAILABLE);
    tiles[2].setState(Tile.AVAILABLE);
    tiles[4].setState(Tile.AVAILABLE);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("      flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
    } else {
        System.out.println("FAIL: flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    }

    // ---------- 11 PASS -----------------------------------------------
    resetTiles(tiles);
    die1.setValue(5);
    die2.setValue(6);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("      flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
    } else {
        System.out.println("FAIL: flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    }

    flipTiles(tiles);
    die1.setValue(6);
    die2.setValue(5);
    tiles[5].setState(Tile.AVAILABLE);
    tiles[6].setState(Tile.AVAILABLE);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("      flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
    } else {
        System.out.println("FAIL: flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    }

    flipTiles(tiles);
    die1.setValue(5);
    die2.setValue(6);
    tiles[4].setState(Tile.AVAILABLE);
    tiles[7].setState(Tile.AVAILABLE);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("      flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
    } else {
        System.out.println("FAIL: flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    }

    flipTiles(tiles);
    die1.setValue(6);
    die2.setValue(5);
    tiles[1].setState(Tile.AVAILABLE);
    tiles[2].setState(Tile.AVAILABLE);
    tiles[3].setState(Tile.AVAILABLE);
    tiles[7].setState(Tile.AVAILABLE);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("      flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
    } else {
        System.out.println("FAIL: flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    }

    flipTiles(tiles);
    die1.setValue(6);
    die2.setValue(5);
    tiles[1].setState(Tile.AVAILABLE);
    tiles[4].setState(Tile.AVAILABLE);
    tiles[6].setState(Tile.AVAILABLE);
    tiles[7].setState(Tile.AVAILABLE);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("      flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
    } else {
        System.out.println("FAIL: flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    }

    flipTiles(tiles);
    die1.setValue(6);
    die2.setValue(5);
    tiles[1].setState(Tile.AVAILABLE);
    tiles[4].setState(Tile.AVAILABLE);
    tiles[6].setState(Tile.AVAILABLE);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("      flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
    } else {
        System.out.println("FAIL: flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    }

    flipTiles(tiles);
    die1.setValue(5);
    die2.setValue(6);
    tiles[1].setState(Tile.AVAILABLE);
    tiles[2].setState(Tile.AVAILABLE);
    tiles[3].setState(Tile.AVAILABLE);
    tiles[5].setState(Tile.AVAILABLE);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("      flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
    } else {
        System.out.println("FAIL: flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    }

    // ---------- 12 PASS -----------------------------------------------
    resetTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("      flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
    } else {
        System.out.println("FAIL: flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    }

    flipTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    tiles[5].setState(Tile.AVAILABLE);
    tiles[7].setState(Tile.AVAILABLE);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("      flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
    } else {
        System.out.println("FAIL: flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    }

    flipTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    tiles[1].setState(Tile.AVAILABLE);
    tiles[5].setState(Tile.AVAILABLE);
    tiles[7].setState(Tile.AVAILABLE);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("      flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
    } else {
        System.out.println("FAIL: flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    }

    flipTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    tiles[4].setState(Tile.AVAILABLE);
    tiles[8].setState(Tile.AVAILABLE);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("      flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
    } else {
        System.out.println("FAIL: flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    }

    flipTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    tiles[4].setState(Tile.AVAILABLE);
    tiles[8].setState(Tile.AVAILABLE);
    tiles[9].setState(Tile.AVAILABLE);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("      flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
    } else {
        System.out.println("FAIL: flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    }

    flipTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    tiles[2].setState(Tile.AVAILABLE);
    tiles[3].setState(Tile.AVAILABLE);
    tiles[7].setState(Tile.AVAILABLE);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("      flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
    } else {
        System.out.println("FAIL: flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    }

    flipTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    tiles[1].setState(Tile.AVAILABLE);
    tiles[2].setState(Tile.AVAILABLE);
    tiles[3].setState(Tile.AVAILABLE);
    tiles[4].setState(Tile.AVAILABLE);
    tiles[6].setState(Tile.AVAILABLE);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("      flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
    } else {
        System.out.println("FAIL: flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    }

    flipTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    tiles[1].setState(Tile.AVAILABLE);
    tiles[2].setState(Tile.AVAILABLE);
    tiles[4].setState(Tile.AVAILABLE);
    tiles[5].setState(Tile.AVAILABLE);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("      flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
    } else {
        System.out.println("FAIL: flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    }

    flipTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    tiles[1].setState(Tile.AVAILABLE);
    tiles[2].setState(Tile.AVAILABLE);
    tiles[4].setState(Tile.AVAILABLE);
    tiles[5].setState(Tile.AVAILABLE);
    tiles[6].setState(Tile.AVAILABLE);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("      flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
    } else {
        System.out.println("FAIL: flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    }

    // ---------- 1 FAIL -----------------------------------------------
    flipTiles(tiles);
    die1.setValue(0);
    die2.setValue(1);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("FAIL: flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    } else {
        System.out.println("      flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
    }

    resetTiles(tiles);
    die1.setValue(1);
    die2.setValue(0);
    tiles[1].setState(Tile.FLIPPED);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("FAIL: flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    } else {
        System.out.println("      flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
    }

    // ---------- 6 FAIL -----------------------------------------------
    flipTiles(tiles);
    die1.setValue(0);
    die2.setValue(6);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("FAIL: flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    } else {
        System.out.println("      flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
    }

    resetTiles(tiles);
    die1.setValue(5);
    die2.setValue(1);
    tiles[1].setState(Tile.FLIPPED);
    tiles[4].setState(Tile.FLIPPED);
    tiles[6].setState(Tile.FLIPPED);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("FAIL: flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    } else {
        System.out.println("      flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
    }

    resetTiles(tiles);
    die1.setValue(4);
    die2.setValue(2);
    tiles[1].setState(Tile.FLIPPED);
    tiles[2].setState(Tile.FLIPPED);
    tiles[6].setState(Tile.FLIPPED);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("FAIL: flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    } else {
        System.out.println("      flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
    }

    // ---------- 7 FAIL -----------------------------------------------
    flipTiles(tiles);
    die1.setValue(1);
    die2.setValue(6);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("FAIL: flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    } else {
        System.out.println("      flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
    }

    resetTiles(tiles);
    die1.setValue(6);
    die2.setValue(1);
    tiles[1].setState(Tile.FLIPPED);
    tiles[2].setState(Tile.FLIPPED);
    tiles[3].setState(Tile.FLIPPED);
    tiles[7].setState(Tile.FLIPPED);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("FAIL: flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    } else {
        System.out.println("      flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
    }

    resetTiles(tiles);
    die1.setValue(5);
    die2.setValue(2);
    tiles[1].setState(Tile.FLIPPED);
    tiles[2].setState(Tile.FLIPPED);
    tiles[4].setState(Tile.FLIPPED);
    tiles[7].setState(Tile.FLIPPED);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("FAIL: flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    } else {
        System.out.println("      flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
    }

    resetTiles(tiles);
    die1.setValue(4);
    die2.setValue(3);
    tiles[1].setState(Tile.FLIPPED);
    tiles[4].setState(Tile.FLIPPED);
    tiles[5].setState(Tile.FLIPPED);
    tiles[7].setState(Tile.FLIPPED);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("FAIL: flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    } else {
        System.out.println("      flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
    }

    resetTiles(tiles);
    die1.setValue(3);
    die2.setValue(4);
    tiles[4].setState(Tile.FLIPPED);
    tiles[5].setState(Tile.FLIPPED);
    tiles[6].setState(Tile.FLIPPED);
    tiles[7].setState(Tile.FLIPPED);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("FAIL: flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    } else {
        System.out.println("      flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
    }

    // ---------- 11 FAIL -----------------------------------------------
    flipTiles(tiles);
    die1.setValue(5);
    die2.setValue(6);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("FAIL: flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    } else {
        System.out.println("      flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
    }

    resetTiles(tiles);
    die1.setValue(6);
    die2.setValue(5);
    tiles[2].setState(Tile.FLIPPED);
    tiles[3].setState(Tile.FLIPPED);
    tiles[4].setState(Tile.FLIPPED);
    tiles[5].setState(Tile.FLIPPED);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("FAIL: flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    } else {
        System.out.println("      flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
    }

    resetTiles(tiles);
    die1.setValue(5);
    die2.setValue(6);
    tiles[2].setState(Tile.FLIPPED);
    tiles[3].setState(Tile.FLIPPED);
    tiles[4].setState(Tile.FLIPPED);
    tiles[5].setState(Tile.FLIPPED);
    tiles[9].setState(Tile.FLIPPED);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("FAIL: flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    } else {
        System.out.println("      flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
    }

    resetTiles(tiles);
    die1.setValue(6);
    die2.setValue(5);
    tiles[1].setState(Tile.FLIPPED);
    tiles[2].setState(Tile.FLIPPED);
    tiles[4].setState(Tile.FLIPPED);
    tiles[5].setState(Tile.FLIPPED);
    tiles[8].setState(Tile.FLIPPED);
    tiles[9].setState(Tile.FLIPPED);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("FAIL: flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    } else {
        System.out.println("      flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
    }

    resetTiles(tiles);
    die1.setValue(6);
    die2.setValue(5);
    tiles[3].setState(Tile.FLIPPED);
    tiles[4].setState(Tile.FLIPPED);
    tiles[5].setState(Tile.FLIPPED);
    tiles[8].setState(Tile.FLIPPED);
    tiles[9].setState(Tile.FLIPPED);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("FAIL: flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    } else {
        System.out.println("      flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
    }

    // ---------- 12 FAIL -----------------------------------------------
    flipTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("FAIL: flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    } else {
        System.out.println("      flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
    }

    resetTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    tiles[1].setState(Tile.FLIPPED);
    tiles[2].setState(Tile.FLIPPED);
    tiles[3].setState(Tile.FLIPPED);
    tiles[4].setState(Tile.FLIPPED);
    tiles[5].setState(Tile.FLIPPED);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("FAIL: flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    } else {
        System.out.println("      flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
    }

    resetTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    tiles[1].setState(Tile.FLIPPED);
    tiles[3].setState(Tile.FLIPPED);
    tiles[4].setState(Tile.FLIPPED);
    tiles[5].setState(Tile.FLIPPED);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("FAIL: flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    } else {
        System.out.println("      flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
    }

    resetTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    tiles[3].setState(Tile.FLIPPED);
    tiles[4].setState(Tile.FLIPPED);
    tiles[5].setState(Tile.FLIPPED);
    tiles[6].setState(Tile.FLIPPED);
    tiles[9].setState(Tile.FLIPPED);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("FAIL: flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    } else {
        System.out.println("      flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
    }

    resetTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    tiles[1].setState(Tile.FLIPPED);
    tiles[2].setState(Tile.FLIPPED);
    tiles[5].setState(Tile.FLIPPED);
    tiles[8].setState(Tile.FLIPPED);
    tiles[9].setState(Tile.FLIPPED);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("FAIL: flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    } else {
        System.out.println("      flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
    }

    resetTiles(tiles);
    die1.setValue(6);
    die2.setValue(6);
    tiles[1].setState(Tile.FLIPPED);
    tiles[2].setState(Tile.FLIPPED);
    tiles[3].setState(Tile.FLIPPED);
    tiles[5].setState(Tile.FLIPPED);
    tiles[8].setState(Tile.FLIPPED);
    tiles[9].setState(Tile.FLIPPED);
    if (GameLogic.flipIsPossible(tiles, die1, die2)) {
        System.out.println("FAIL: flipIsPossible returns true:  " + diceString(die1, die2) + tileNotFlippedString(tiles));
        flipIsPossiblePassed = false;
    } else {
        System.out.println("      flipIsPossible returns false: " + diceString(die1, die2) + tileNotFlippedString(tiles));
    }

    // ----------------------------
    System.out.println();
    if (flipIsPossiblePassed) {
        System.out.println("*** YES!!  flipIsPossible passes tests (which are not comprehensive, but a pretty good representation)!\n");
    }

    System.out.println("--------------------------------------------------------------------------------");
    System.out.println("  SUMMARY: sumsAreEqual: " + (sumsAreEqualPassed?"PASS":"FAIL"));
    System.out.println("           playerHasWon: " + (playerHasWonPassed?"PASS":"FAIL"));
    System.out.println("         flipIsPossible: " + (flipIsPossiblePassed?"PASS":"FAIL"));
    System.out.println("--------------------------------------------------------------------------------");
}
}
