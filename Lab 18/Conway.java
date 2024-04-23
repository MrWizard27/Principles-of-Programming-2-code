//This code was made by Michael Plafcan(Section 1) on 4/20/23
//imports JFrame
import javax.swing.JFrame;

public class Conway {
    //Creates a GridCanvas Object called grdi
    private GridCanvas grid;

    public Conway(){
        //initializes the gridcanvas object, giving it a row length of 5, column length of 10, and size of 20
        grid = new GridCanvas(5, 10, 20); 
        //turns on the pixel at row 2 and column 1
        grid.turnOn(2, 1);
        //turns on the pixel at row 2 and column 2
        grid.turnOn(2, 2);
        //turns on the pixel at row 2 and column 3
        grid.turnOn(2, 3);
        //turns on the pixel at row 1 and column 7
        grid.turnOn(1, 7);
        //turns on the pixel at row 2 and column 7
        grid.turnOn(2, 7);
        //turns on the pixel at row 3 and column 7
        grid.turnOn(3, 7);
        
    }
    public static void main(String[] args){
        //Creates a string variable called titled, gives it the value of Conway's Game of Life
        String title = "Conway's Game of Life";
        //Creates new conway object
        Conway game = new Conway();
        //Creates new JFrame Object
        JFrame frame = new JFrame(title);
        //sets the default close operation for the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //makes it unresizable
        frame.setResizable(false);
        //adds the game grid to fram
        frame.add(game.grid);
        //sets the minimum size of the window to a constant
        frame.pack();
        //sets the frame to visible
        frame.setVisible(true);
        //cals the mainloop method
        game.mainloop();

    }
    //main game loop
    private void mainloop(){
        //loop that runs forever 
        while(true){
            //runs update method()
            update();
            //repaints the grid to the next step in the game
            grid.repaint();
            //try's thread.sleep unless an interupted exceptio error happens, then it catches that so the program doesn't end
            try{
            Thread.sleep(500);
            } catch (InterruptedException e){
            
            }
        }
    }
    //checks how many alive cells are next to the cell its checking
    private int countAlive(int r, int c) {
        //creates an variable called count with a value of 0
        int count = 0;
        //calls the grid test method to see if the cell is on
        //does this to every cell around the cell its checking
        count += grid.test(r - 1, c - 1);
        count += grid.test(r - 1, c);
        count += grid.test(r - 1, c + 1);
        count += grid.test(r, c - 1);
        count += grid.test(r, c + 1);
        count += grid.test(r + 1, c - 1);
        count += grid.test(r + 1, c);
        count += grid.test(r + 1, c + 1);
        //returns the amount of cells alive around the cell it's checking
        return count;

    }
    //updates the grid
    public void update(){
        //creates a 2d array called counts, gets the value by calling upon count neighbors
        int[][] counts = countNeighbors();
        //updates the grid 
        updateGrid(counts);
    }

    private int[][] countNeighbors(){
        //creates variable called row with the value of the amount of Rows
        int rows = grid.numRows();
        //creates variable called cols with the value of the amount of Columns
        int cols = grid.numCols();
        //creates 2d array called clounts
        int[][] counts = new int[rows][cols];
        //goes through the rows
        for (int r = 0; r < rows; r++){
            //goes through the columns
            for (int c = 0; c < cols; c++){
                //gives counts the value of the amount of cells next to the cell its checking
                counts[r][c] = countAlive(r,c);
            }
        }
        //returns the counts 2d array
        return counts;
    }
    //updates the grid with the next step
    private void updateGrid(int[][] counts){
        //creates variable called row with the value of the amount of Rows
        int rows = grid.numRows();
        //creates variable called cols with the value of the amount of Columns
        int cols = grid.numCols();

        //goes through rows
        for(int r = 0; r < rows; r++){
            //goes through columns
            for (int c = 0; c < cols; c++){
                //creates cell objects, calls upon the grid objet's getCell method
                Cell cell = grid.getCell(r,c);
                //updates the cell base on the amount of adjacent alive cells
                updateCell(cell, counts[r][c]);
            }
        }
    }
    //updates the cells
    private static void updateCell(Cell cell, int count){
        //if the cell is on
        if (cell.isOn()){
            //checks if the count less than 2 or greater than 3
            if (count < 2 || count > 3){
                //turns the cell off
                cell.turnOff();
            }
            //if cell is off
        }else{
            // and if the count is 3
            if (count == 3){
                //turns on cell
                cell.turnOn();
            }
        }
    }
    
}
