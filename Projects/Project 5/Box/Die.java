import java.awt.*;
import java.awt.event.*;
import javax.swing.*;  //notice javax
import java.util.*;

public class Die implements MouseListener {

private int value;
private TiltableJLabel view;
private boolean isUseable = true;

public static ImageIcon[] dieViews = { null, new ImageIcon("img/die1.png"), 
											 new ImageIcon("img/die2.png"),
											 new ImageIcon("img/die3.png"),
											 new ImageIcon("img/die4.png"),
											 new ImageIcon("img/die5.png"),
											 new ImageIcon("img/die6.png")};


private ArrayList<DieListener> listeners;

public Die() { 

	value = newValue(); 
	view = new TiltableJLabel (dieViews[value]);
	view.addMouseListener(this);
	listeners = new ArrayList<DieListener>(1);

}

public void setUseable(boolean useable) {
    isUseable = useable;
    if (useable) {
        setValue();
    } else {
        setValue(0);
    }
}

protected static int newValue() {
	return (int) (Math.random() * 6) + 1;
}

public void setValue() {
    if (isUseable) {
        setValue(newValue()); 
    }
}

protected void setValue(int _value) {
	value = _value; 
	view.setIcon(dieViews[value]);
}

public int getValue() {
	return value;
}

public TiltableJLabel getView() {
	return view;
}

public int getHeight() {
	return (int)(dieViews[value].getIconHeight() * 1.42);
}

public int getWidth() {
	return (int)(dieViews[value].getIconWidth() * 1.42);
}

public void mouseClicked(MouseEvent mEvt){
}
public void mouseEntered(MouseEvent mEvt){
}
public void mouseExited(MouseEvent mEvt){
}
public void mousePressed(MouseEvent mEvt){
	for (DieListener dl : listeners)
		dl.dieClicked();
}
public void mouseReleased(MouseEvent mEvt){
}

public void addDieListener(DieListener listener) {
	listeners.add(listener);	
}

}

