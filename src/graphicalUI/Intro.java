/*-------------------------------------------------------------------
 * Author:			Omar Almootassem
 * Written:			Oct/02/2014
 * Last Updated:	Oct/05/2014
 * 
 * Called by the main method. Creates the introductory page and when
 * the play button is clicked, it launches Bird which starts the 
 * game.
 ------------------------------------------------------------------*/

package graphicalUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class Intro{
	
	//create JFrame and JLayeredPane
	public JFrame frame = new JFrame("Flappy Bird");;
	private JLayeredPane pane = new JLayeredPane();
	   
	/**
	 * Constructs the start of the game
	 */
	public Intro(){
		//create both images
		final ImagePanel background = new ImagePanel(new ImageIcon ("images/background.jpg").getImage());
		final ImagePanel playButton = new ImagePanel(new ImageIcon ("images/playButton.png").getImage());
		


	    //add Mouse Listener for playButton
		playButton.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//Hide previous visuals
				background.setVisible(false);
				playButton.setVisible(false);
				System.out.println("Play Button Clicked\nFirst Visuals Removed"); //Debugging
				new Bird(frame);
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
		
	      pane.add(background, JLayeredPane.DEFAULT_LAYER);
	      pane.add(playButton, JLayeredPane.POPUP_LAYER);

	      frame.add(pane);
	      
	      frame.setSize(280, 508);
	      frame.setResizable(false);
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.setVisible(true);
	}
}
