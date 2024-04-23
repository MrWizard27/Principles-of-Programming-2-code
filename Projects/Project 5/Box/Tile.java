import java.awt.*;
import java.awt.event.*;
import javax.swing.*;  //notice javax
import java.util.*;

public class Tile implements MouseListener {

private int value;

private int state;

/** The tile has not been flipped or selected. */
public static final int AVAILABLE = 0;

/** The tile has not been flipped, but is selected to be flipped. */
public static final int SELECTED = 1;

/** The tile has been flipped, so is not longer available. */
public static final int FLIPPED = 2;

private static final int SELECTED_Y = 20;

private JLabel view;
private ImageIcon imgPlain;
private ImageIcon imgFlipped;

private ArrayList<TileListener> listeners;

/** @param _value the value of the tile printed on the tile, which represents the number of die dots the tile can count toward. */
public Tile(int _value) {

	imgPlain = new ImageIcon("img/tile"+_value+".png");
	imgFlipped = new ImageIcon("img/tile"+_value+"back.png");

	view = new JLabel(imgPlain);
	view.addMouseListener(this);
	listeners = new ArrayList<TileListener>(1);

	this.value = _value;

	state = Tile.AVAILABLE;

}

/** @return the value of the tile printed on the tile, which represents the number of die dots the tile can count toward. */
public int getValue() {
	return value;
}

/** @return one of the three state constants described above: AVAILABLE, FLIPPED, and SELECTED. */
public int getState() {
	return state;
}

/** @param _state one of the three state constants described above: AVAILABLE, FLIPPED, and SELECTED. */
public void setState(int _state) {
    if (state != SELECTED && _state == SELECTED) {
        view.setLocation(view.getX(), view.getY() + SELECTED_Y);
    } else if (state == SELECTED && _state != SELECTED) {
        view.setLocation(view.getX(), view.getY() - SELECTED_Y);
    }
	this.state = _state;
	switch (_state) {
		case AVAILABLE :
			view.setIcon(imgPlain);
			break;
		case FLIPPED :
			view.setIcon(imgFlipped);
			break;
		case SELECTED :
			break;
		default:
	}
}

public JLabel getView() {
	return view;
}

public int getHeight() {
	return imgPlain.getIconHeight();
}

public int getWidth() {
	return imgPlain.getIconWidth();
}

public void mouseClicked(MouseEvent mEvt){
}

public void mouseEntered(MouseEvent mEvt){
}

public void mouseExited(MouseEvent mEvt){
}

public void mousePressed(MouseEvent mEvt){
	
	if (BoxState.getInstance().getInstance().getState() == GameState.FLIPPING ) {
		if (state == Tile.AVAILABLE) {
			setState(Tile.SELECTED);
			for (TileListener tl : listeners) {
				tl.tileSelected();
			}
		} else {
			if (state == Tile.SELECTED) {
				setState(Tile.AVAILABLE);
				for (TileListener tl : listeners) {
					tl.tileDeselected();
				}
			}
		}
	} else if (BoxState.getInstance().getInstance().getState() == GameState.GAME_START ) {
        for (TileListener tl : listeners) {
            tl.tileNotReady();
        }
    }

}

public void mouseReleased(MouseEvent mEvt){
}

public void addTileListener(TileListener tl) {
	listeners.add(tl);
}

}

