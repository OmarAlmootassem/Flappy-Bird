/*-------------------------------------------------------------------
 * Author:			Omar Almootassem
 * Written:			Oct/06/2014
 * Last Updated:	Oct/07/2014
 * 
 * Called by the PassOrHit method when the bird hits the pipes or 
 * reaches the y axis boundaries. This class displays the final
 * score and asks if the user wants to play again.
 ------------------------------------------------------------------*/

package graphicalUI;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Finished {
	//variables
	JLayeredPane pane = new JLayeredPane();

	/**
	 * Shows the end screen
	 * @param frame the usual frame
	 * @param oldPane the previous pane
	 * @param counter
	 */
	public Finished(final JFrame frame, JLayeredPane oldPane, int counter){
		//background image
		ImagePanel background = new ImagePanel(new ImageIcon ("images/background.jpg").getImage());
		//Final Score label	
		final JLabel scoreLabel = new JLabel("Final Score: " +String.valueOf(counter));
			scoreLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		final JPanel score = new JPanel();
			score.add(scoreLabel);
			score.setLocation(45, 125);
			score.setSize(200, 100);
			score.setOpaque(false);
		//Play Again label	
		final JLabel playLabel = new JLabel("Play Again?");
			playLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		final JPanel play = new JPanel();
			play.add(playLabel);
			play.setLocation(45, 250);
			play.setSize(200, 100);
			play.setOpaque(false);
			play.addMouseListener(new MouseListener(){
				@Override
				public void mouseClicked(MouseEvent arg0) {
					//re-launch game
					frame.setVisible(false);
					new Intro();
				}
				@Override
				public void mouseEntered(MouseEvent arg0) {
				}
				@Override
				public void mouseExited(MouseEvent arg0) {
				}
				@Override
				public void mousePressed(MouseEvent arg0) {
				}
				@Override
				public void mouseReleased(MouseEvent arg0) {				
				}			
			});
		
		//Hide previous pane
		oldPane.setVisible(false);
		//System.out.println(counter); //Debugging
		//Add new pane
		pane.add(background, JLayeredPane.DEFAULT_LAYER);
		pane.add(score, JLayeredPane.PALETTE_LAYER);
		pane.add(play, JLayeredPane.POPUP_LAYER);
		frame.add(pane);
	}
}
