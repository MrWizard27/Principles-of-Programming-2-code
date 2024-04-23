//This code was made by Michael Plafcan(Section 1) on 4/20/23
//imports color
import java.awt.Color;
//imports graphics
import java.awt.Graphics;
public class Cell {
    //instance variables
    private final int x;
    private final int y;
    private final int size;
    private int state;
    
    //constructor
    public Cell(int x, int y, int size){
        //initializes all the instance variables
        this.x = x;
        this.y = y;
        this.size = size;
        this.state = 0;
    }
    //instance variable that chooses the 2 colors being used (0 for white, 1 for black)
    public static final Color[] COLORS = {Color.WHITE, Color.BLACK};

    //draws the cell
    public void draw(Graphics g){
        //sets the color of the cell to its states (dead = 0 = white, alive = 1 = black)
        g.setColor(COLORS[state]);
        //draws the cell with the state color
        g.fillRect(x + 1, y + 1, size -1, size -1);
        //sets the outline color
        g.setColor(Color.LIGHT_GRAY);
        //draws the outline
        g.drawRect(x, y, size, size);
    }
    //checks if the cell is off
    public boolean isOff(){
        return state == 0;
    }
    //checks if the cell is on
    public boolean isOn(){
        return state == 1;
    }
    //turns the cell off
    public void turnOff(){
        state = 0;
    }
    //turns the cell on
    public void turnOn(){
        state = 1;
    }

}

