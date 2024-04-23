//This code was made by Michael Plafcan(Section 1) on 4/20/23
import java.awt.Canvas;
import java.awt.Graphics;
public class GridCanvas extends Canvas{
    //creates the 2d Cell array instance variable
    private Cell[][] array;

    //constructor
    public GridCanvas(int rows, int cols, int size){
        //declares the array instance variable
        array = new Cell[rows][cols];

        //goes through the rows
        for (int r = 0; r < rows; r++){
            //makes y = size times the row its on
            int y = r * size;
            //goes through the column
            for (int c = 0; c < cols; c++){
                //makes x = size times the column its on
                int x = c * size;
                //creates a cell in the 2d array on the row and cell its on and gives it the value of those x and y variables we created
                array[r][c] = new Cell(x, y, size);
            }
        }
        //uses a java awt method to set the size of the grid
        setSize(cols * size, rows * size);
    }
    //draws the game
    public void draw(Graphics g) {
        //goes through the rows in the array
        for (Cell[] row : array) {
            //goes through the cells in the row
            for (Cell cell : row) {
                //draws the cell
                cell.draw(g);
            }
        }
    }
    //paints an individual cell
    public void paint(Graphics g){
        draw(g);
    }
    //gets the amount of rows;
    public int numRows(){
        return array.length;
    }
    //gets the amount of columns
    public int numCols(){
        return array[0].length;
    }
    //returns a certain cell
    public Cell getCell(int r, int c){
        return array[r][c];
    }
    //turns on a specific cell
    public void turnOn(int r, int c){
        array[r][c].turnOn();
    }
    //checks if a cell is on but catches any errors it encounters
    public int test(int r, int c){
        //trys a statement
        try{
            //if the cell is on it returns 1
            if (array[r][c].isOn()){
                return 1;
            }
            //if an array index out of bounds exception error happens then it catches the error and doesn't end the program
        }catch (ArrayIndexOutOfBoundsException e){

        }
        //returns 0 if an error happens or if the cell is off
        return 0;
    }

}
