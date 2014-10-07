/*-------------------------------------------------------------------
 * Author:			Omar Almootassem
 * Written:			Oct/01/2014
 * Last Updated:	Oct/06/2014
 * 
 * Called by the Intro class. This class adds the background image,
 * as well as the bird and the pipes. On every mouse click, this
 * class calls the MoveBird class.
 ------------------------------------------------------------------*/

package graphicalUI;

import game.MoveBird;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Bird {
	//create JLayeredPane
	private JLayeredPane pane = new JLayeredPane();
	//boolean checker for clickToPlay
	boolean firstTime = true;
	//score counter
	int counter = 0;

	public Bird(final JFrame frame){

		//create Image Panels for the background and bird
		final ImagePanel background = new ImagePanel(new ImageIcon ("images/background.jpg").getImage());
		final ImagePanel birdy = new ImagePanel(new ImageIcon ("images/flappy.png").getImage());
			birdy.setLocation(123, 300);
		final ImagePanel pipes1 = new ImagePanel(new ImageIcon ("images/completePipes.png").getImage());
			pipes1.setLocation(480, -232);
		final ImagePanel pipes2 = new ImagePanel(new ImageIcon ("images/completePipes.png").getImage());
			pipes2.setLocation(680, -180);
		final ImagePanel pipes3 = new ImagePanel(new ImageIcon ("images/completePipes.png").getImage());
			pipes3.setLocation(880, -260);
		//Click To Play Label
		final JLabel clickToPlayLabel = new JLabel("Click To Play");
			clickToPlayLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		final JPanel clickToPlay = new JPanel();
			clickToPlay.add(clickToPlayLabel);
			clickToPlay.setLocation(40, 75);
			clickToPlay.setSize(200, 100);
			clickToPlay.setOpaque(false);
		//Score label	
		final JLabel scoreLabel = new JLabel(String.valueOf(counter));
			scoreLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		final JPanel score = new JPanel();
			score.add(scoreLabel);
			score.setLocation(87, 125);
			score.setSize(100, 100);
			score.setOpaque(false);

		
		//add Mouse Listener for game
		frame.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//hide tapToPlay
				if (firstTime == true){
					clickToPlay.setVisible(false);
					System.out.println("tapToPlay Hidden"); //Debugging
					firstTime = false;
				 }
//				System.out.println("Screen Clicked" + 
//						"\nBird Moved To: ("+ birdy.getX() + "," + birdy.getY() + ")"); //Debugging
				//get flight path and of bird and move the bird
				SwingUtilities.invokeLater(new Runnable(){
					@Override
					public void run() {
						new MoveBird(birdy, pipes1, pipes2, pipes3, frame, scoreLabel, counter, pane);
					}					
				});
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

		//add everything to frame		
		pane.add(background, JLayeredPane.DEFAULT_LAYER);
		pane.add(birdy, JLayeredPane.MODAL_LAYER);
		pane.add(clickToPlay, JLayeredPane.MODAL_LAYER);
		pane.add(pipes1,JLayeredPane.MODAL_LAYER);
		pane.add(pipes2,JLayeredPane.MODAL_LAYER);
		pane.add(pipes3,JLayeredPane.MODAL_LAYER);
		pane.add(score, JLayeredPane.POPUP_LAYER);
		frame.add(pane);
		
		//set frame defaults
		frame.setSize(280, 508);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);		
	}
}
