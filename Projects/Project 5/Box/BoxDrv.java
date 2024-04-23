import java.awt.*;
import java.awt.event.*;
import javax.swing.*;  //notice javax

public class BoxDrv implements DieListener, TileListener {

	private JLabel bkg; 
	private JFrame frame;

    private Tile[] tiles;
	private Die die1, die2;

	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 622;
	private static final int BORDER_WIDTH = 16;
	private static final int TILE_GAP = 4;

	private static final int DIE_X_RANGE = 640; 
	private static final int DIE_X_MIN = 21; 
	private static final int DIE_Y_RANGE = 270; 
	private static final int DIE_Y_MIN = 208; 

    public BoxDrv() {

		BoxSounds.init();
		
		JFrame frame = new JFrame("Shut the Box"); 

		frame.setBounds(100,100,FRAME_WIDTH,FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImageIcon img = new ImageIcon("img/boxBg.jpg");
		bkg = new JLabel(img);

		Container con = frame.getContentPane(); // inherit main frame
		con.add(bkg); 	// add the panel to frame
		bkg.setLayout(null);

		tiles = new Tile[10];

		int xx = BORDER_WIDTH + TILE_GAP;	
		int yy = BORDER_WIDTH + TILE_GAP;	

		for (int ii = 1; ii <= 9; ii++) {
			tiles[ii] = new Tile(ii);
			tiles[ii].addTileListener(this);
			bkg.add(tiles[ii].getView());
			tiles[ii].getView().setBounds(xx, yy, tiles[ii].getWidth(), tiles[ii].getHeight());
			xx += tiles[ii].getWidth() + TILE_GAP;
			// System.out.println("tile width: "+tiles[ii].getWidth());
		};

		die1 = new Die();
		die2 = new Die();

		bkg.add(die1.getView());
		bkg.add(die2.getView());

		die1.getView().setBounds(newDieX(),newDieY(), die1.getWidth(), die1.getHeight());
		die2.getView().setBounds(newDieX(),newDieY(), die1.getWidth(), die1.getHeight());
	
		die1.addDieListener(this);
		die2.addDieListener(this);


		frame.setVisible(true); // display this frame
	}

    private void resetGame() {
        for (int ii = 1; ii <= 9; ii++) {
            tiles[ii].setState(Tile.AVAILABLE);
        }
        die2.setUseable(true);
    }

	protected static double newDieAngle() {
		return Math.random() * Math.PI - Math.PI/2.0;
	}

	static int newDieX() {
		return (int) (Math.random() * DIE_X_RANGE + DIE_X_MIN);
	}

	static int newDieY() {
		return (int) (Math.random() * DIE_Y_RANGE + DIE_Y_MIN);
	}

	void rollDice() {
		Rectangle r1 = die1.getView().getBounds();
		Rectangle r2 = die2.getView().getBounds();
		r1.setLocation(newDieX(), newDieY());
		do {
			r2.setLocation(newDieX(), newDieY());
		} while (r1.intersects(r2));

		die1.setValue();
		die2.setValue();
		die1.getView().setAngle(newDieAngle());
		die2.getView().setAngle(newDieAngle());
		die1.getView().setLocation(r1.getLocation());
		die2.getView().setLocation(r2.getLocation());
	}

	public void tileSelected() {
		// System.out.println("BoxDrv.tileSelected");
		BoxSounds.tileSlide();
		if (GameLogic.playerHasWon(tiles, die1, die2)) {
			BoxState.getInstance().setState(GameState.WON);
			// System.out.println("You SHUT THE BOX!!!");
			BoxSounds.win();
            JOptionPane.showMessageDialog(frame, "You SHUT THE BOX!!!");
            resetGame();
            BoxState.getInstance().setState(GameState.GAME_START);
		}
	}

	public void tileDeselected() {
		BoxSounds.tileSlide();
		// System.out.println("BoxDrv.tileDeselected");
	}

    // called when player attempts to select a tile before rolling dice.
    public void tileNotReady() {
        // System.out.println("Roll the dice before you select tiles.");
        JOptionPane.showMessageDialog(frame, "Roll the dice before you select tiles.");
    }

	public void dieClicked() {
		// what happens when dice get clicked on
		// System.out.println("BoxDrv.dieClicked");
		switch (BoxState.getInstance().getState())
		{
			case FLIPPING :
				if (GameLogic.sumsAreEqual(tiles, die1, die2)) {
					BoxState.getInstance().setState(GameState.ROLLING);
					for (int jj = 1; jj <= 9; jj++) 
						if (tiles[jj].getState() == Tile.SELECTED) {
							//BoxSounds.tileFlip(); (decided that it's not necessary because the dice are louder.)
							tiles[jj].setState(Tile.FLIPPED);	
						}
					if (tiles[7].getState() == Tile.FLIPPED
                            && tiles[8].getState() == Tile.FLIPPED
                            && tiles[9].getState() == Tile.FLIPPED) {
                        die2.setUseable(false);
                    }
					BoxSounds.dice();
					rollDice();
					if (GameLogic.flipIsPossible(tiles, die1, die2)) {
						BoxState.getInstance().setState(GameState.FLIPPING);
					} else {
						BoxState.getInstance().setState(GameState.GAME_OVER);
						// System.out.println("Yikes.  No move available.  Game OVER.");
						BoxSounds.didntWin();
                        JOptionPane.showMessageDialog(frame, "No move available.  Game OVER.");
                        // BoxSounds.startOver();
                        resetGame();
                        BoxState.getInstance().setState(GameState.GAME_START);
					}
				
				} else {
					// System.out.println("Select tiles that add up to the sum of your previous roll before rolling again.");
                    JOptionPane.showMessageDialog(frame, "Select tiles that add up to the sum of your previous roll before rolling again.");
				}
				
				break;
			case GAME_START: 
				BoxSounds.dice();
				rollDice();
				BoxState.getInstance().setState(GameState.FLIPPING);
				break;
			default:
		}

	}


	public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
				new BoxDrv();
            }
		});
	}

}
