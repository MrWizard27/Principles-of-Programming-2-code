import java.awt.*;
import java.awt.event.*;
import javax.swing.*;  //notice javax
import java.util.*;

public class TiltableJLabel extends javax.swing.JLabel {

private double angle = Math.PI / 2.0; // gradians

public TiltableJLabel(Icon ic) {
	super(ic);
}

@Override
public void paintComponent(Graphics g) {
	Graphics2D g2d = (Graphics2D)g;
	int w2 = getWidth() / 2;
	int h2 = getHeight() / 2;
	g2d.rotate(angle / 2, w2, h2);
	super.paintComponent(g);
}

public void setAngle(double _angle) {
	angle = _angle;
}

}
