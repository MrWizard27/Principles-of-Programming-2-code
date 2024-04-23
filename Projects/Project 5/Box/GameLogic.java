//This Code was made by Michael plafcan in Section 01 on 3/28/2023
import java.util.*;

public class GameLogic {

/** @return true if and only if the sum of the dice equals the sum of the tiles that are
    currently selected.
    
    For example, if the dice add up to 11 and only tile[2] and tile[8]
    are selected false is returned.  Were only tile[3] and tile[8] selected, it would return
    true.

    @param tiles an array of Tile objects.  The array size is 10.  tiles[0] is null, tiles[1]
    represents tile 1, tiles[2] represents tile 2, and so forth.
 */
static boolean sumsAreEqual(Tile[] tiles, Die die1, Die die2) {
    //adds the values of the 2 dies together to get the sum
    int SumofDie = die1.getValue() + die2.getValue();
    //declares the sum of tiles variable
    int SumofTiles = 0;
    //loops through all the tiles
    for (int tile = 1; tile < tiles.length; tile++){
        //checks to see if the tiles state is SELECTED
        if (tiles[tile].getState() == Tile.SELECTED){
            //if the tiles is one that was selected then it get the value of said tile and adds it onto the sum
            SumofTiles+=tiles[tile].getValue();
        }
    } //return true is boths sums are equal and false if they're not equal
	return SumofDie == SumofTiles;
}

/** @return true if and only if the sum of the dice equals the sum of the tiles that are
    currently selected and there are no tiles left available.

    @param tiles an array of Tile objects.  The array size is 10.  tiles[0] is null, tiles[1]
    represents tile 1, tiles[2] represents tile 2, and so forth.
 */
static boolean playerHasWon (Tile[] tiles, Die die1, Die die2){
	//adds the values of the 2 dies together to get the sum
    int SumofDie = die1.getValue() + die2.getValue();
    //declares the sum of tiles variable
    int SumofTiles = 0;
    //loops through all the tiles
    for (int tile = 1; tile < tiles.length; tile++){
        //checks to see if the tiles state is SELECTED
        if (tiles[tile].getState() == Tile.SELECTED){
            //if the tiles is one that was selected then it get the value of said tile and adds it onto the sum
            SumofTiles+=tiles[tile].getValue();
        }
        //checks to see if a tile is available (unselected and not flipped)
        if (tiles[tile].getState() == Tile.AVAILABLE){
            //if there are tiles left, it returns false
            return false;
        }
    } //return true is boths sums are equal and false if they're not equal
	return SumofDie == SumofTiles;
}

/** @return true if and only if there exists some combination of tiles that are not flipped that
    will add up to the sum of the dice.

    @param tiles an array of Tile objects.  The array size is 10.  tiles[0] is null, tiles[1]
    represents tile 1, tiles[2] represents tile 2, and so forth.
*/

static boolean flipIsPossible (Tile[] tiles, Die die1, Die die2) {
	//adds the values of the 2 dies together to get the sum
    int SumofDie = die1.getValue() + die2.getValue();
    //declares and initializes Sum of available tiles variable
    int SumofAvailTiles = 0;
    //created the AvailTiles array that holds the values of all available tiles
    int[] AvailTiles = {0,1,2,3,4,5,6,7,8,9};
    //goes through each tile to see whether they are avaiable
    for (int tile = 1; tile<tiles.length;tile++){
        if (tiles[tile].getState() == Tile.AVAILABLE){
            //if its available the loop adds it's value to sum of availTiles
            SumofAvailTiles += tiles[tile].getValue();
        }else {
            //if its not available it changes that tiles value to 0 in AvailTiles
            AvailTiles[tile] = 0;
        }
    }



    //runs code below if the sum of all the available tiles is greater than or equal to the sum of the dice
    if (SumofDie <= SumofAvailTiles){

        //goes through the tiles array
        for (int tile1 = 1;tile1<tiles.length;tile1++){
            //sets Sum of available tiles to the value of the tile the loop is on (ignoring unavailable tiless)
            SumofAvailTiles = AvailTiles[tile1];
            //checks if the tiles being counted are at the same value as the dice
            if (SumofDie == SumofAvailTiles){
                return true;
                //if it isn't the same value it adds another tile 
            }else if (SumofDie > SumofAvailTiles){

                //for loop that goes through the second tile
                for (int tile2 = 2;tile2<tiles.length;tile2++){
                    //makes sure that it isn't using the same tile twice (if it is then it prematurely ends the loop)
                    if (tile2 == tile1){
                            break;
                    }
                    //sets SumofAvailTiles to the sum of the tiles being counted
                    SumofAvailTiles = AvailTiles[tile1] + AvailTiles[tile2];
                    //checks if the tiles being counted are at the same value as the dice
                    if (SumofDie == SumofAvailTiles){
                        return true;
                    //if it isn't the same value it adds another tile 
                    }else if (SumofDie > SumofAvailTiles){

                        //for loop for the third tile
                        for (int tile3 = 3;tile3<tiles.length;tile3++){
                            //makes sure that it isn't using the same tile twice (if it is then it prematurely ends the loop)
                            if (tile3 == tile2 || tile3 == tile1){
                                    break;
                            }
                            //sets SumofAvailTiles to the sum of the tiles being counted
                            SumofAvailTiles = AvailTiles[tile1] + AvailTiles[tile2] + AvailTiles[tile3];
                            //checks if the tiles being counted are at the same value as the dice
                            if (SumofDie == SumofAvailTiles){
                                return true;
                                //if not, it adds the last tile since 4 is the max amount of tiles you need to equal the largest number you can get with 2 dice
                            }else if (SumofDie > SumofAvailTiles){

                                //for loop for the fourth tile
                                for (int tile4 = 4;tile4<tiles.length;tile4++){
                                    //makes sure that it isn't using the same tile twice (if it is then it prematurely ends the loop)
                                    if (tile4 == tile3 || tile4 == tile2 || tile4 == tile1){
                                        break;
                                    }
                                    //sets SumofAvailTiles to the sum of the tiles being counted
                                    SumofAvailTiles = AvailTiles[tile1] + AvailTiles[tile2] + AvailTiles[tile3] + AvailTiles[tile4];
                                    //checks if the tiles being counted are at the same value as the dice
                                    if (SumofDie == SumofAvailTiles){
                                        return true;
                                    } 
                                }
                            }
                        } 
                    }
                }
            }
        }
    }
    //if the dice doesn't equal any of combinations of tiles then it returns false
        return false;
    }
}
