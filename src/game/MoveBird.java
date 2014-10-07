/*-------------------------------------------------------------------
 * Author:			Omar Almootassem
 * Written:			Oct/02/2014
 * Last Updated:	Oct/07/2014
 * 
 * Called by the Bird class. This class adjusts the bird's position
 * after every mouse click. Also, it adjusts the pipes' x and y 
 * positions.
 ------------------------------------------------------------------*/

package game;

import graphicalUI.ImagePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.Timer;


public class MoveBird {
	
	//create the timer
	Timer timer;

	//BIRD
	int yLoc = 0 ;
	int jumpMax = 10;
	//final yPosition and flag to check if bird out-jumped target
	int yFinal = 0;
	boolean greater;
	
	//ImagePanel to access imported imagePanel
	ImagePanel imagePanel;
	ImagePanel pipesPanel1;
	ImagePanel pipesPanel2;
	ImagePanel pipesPanel3;
	
	//PIPES
	int yPipes = 0;
	int xPipes = 5;
	//changing the y location of the pipes
	Random r;
	int yPipeChange = 150;
	int xPipeChange = 200;
	
	//Mouse Listener
	MouseListener mouse = new MouseListener(){
		@Override
		public void mouseClicked(MouseEvent arg0) {
			yLoc = 0;
			greater = false;
			timer.stop();
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
	};
	
	/**
	 * Class for moving the bird and pipes
	 * @param image
	 * @param pipes1
	 * @param pipes2
	 * @param pipes3
	 * @param frame
	 * @param score
	 * @param counter
	 * @param pane
	 */
	public MoveBird(final ImagePanel bird, final ImagePanel pipes1, final ImagePanel pipes2, final ImagePanel pipes3, 
					final JFrame frame, final JLabel score, final int counter, final JLayeredPane pane){
		//make the imagepanel available to all methods
		imagePanel = bird;
		pipesPanel1 = pipes1;
		pipesPanel2 = pipes2;
		pipesPanel3 = pipes3;
		//initial Random variable
		r = new Random();
		//initialize timer
		//implement timer, delay is 75ms/repaint()
		timer = new Timer(50, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				frame.addMouseListener(mouse);
				//get yLoc from PhysicsEngine and move the image accordingly
				if (greater == true || yLoc >= jumpMax){
					//move the bird
					yLoc = PhysicsEngineDOWN(yLoc);
				}
				else if (yLoc < jumpMax){
					//move the bird
					yLoc = PhysicsEngineUP(yLoc);
					//if the bird hits max height, set greater to true to start dropping the bird
					if (yLoc >= jumpMax){
						greater = true;
					}
				}
				//BIRDY
				bird.setLocation(bird.getX(), bird.getY() - yLoc);
				//Check if the bird passed through the pipes
				new PassOrHit(pipes1, pipes2, pipes3, bird, frame, pane, Integer.parseInt(score.getText()));
				//Score counter for the label in the top middle
				new ScoreCounter(score, pipes1, pipes2, pipes3, counter);

				//PIPES
				if (pipesPanel1.getX() >= -26){
					pipesPanel1.setLocation(pipesPanel1.getX() - xPipes, pipesPanel1.getY());
					//System.out.println("Pipe X1: " + pipesPanel1.getX()); //Debugging
				} else if (pipesPanel1.getX() < -26){
					pipesPanel1.setLocation(pipesPanel3.getX() + xPipeChange, PipesY(pipesPanel1));
					//System.out.println("Pipe Y1: " + yPipes); //Debugging
				}
				if (pipesPanel2.getX() >= -26){
					pipesPanel2.setLocation(pipesPanel2.getX() - xPipes, pipesPanel2.getY());
					//System.out.println("Pipe X2: " + pipesPanel2.getX()); //Debugging
				} else if (pipesPanel2.getX() < -26){
					pipes2.setLocation(pipesPanel1.getX() + xPipeChange, PipesY(pipesPanel2));
					//System.out.println("Pipe Y2: " + yPipes); //Debugging
				}
				if (pipesPanel3.getX() >= -26){
					pipesPanel3.setLocation(pipesPanel3.getX() - xPipes, pipesPanel3.getY());
					//System.out.println("Pipe X3: " + pipesPanel3.getX()); //Debugging
				} else if (pipesPanel3.getX() < -26){
					pipes3.setLocation(pipesPanel2.getX() + xPipeChange, PipesY(pipesPanel3));
					//System.out.println("Pipe Y3: " + yPipes); //Debugging
				}

			}
		});
		//setInitialDelay to 1ms and start
		timer.setInitialDelay(1);
		//only run if bird is still in screen
		if (bird.getY() > 0 && bird.getY() < 460)
			timer.start();
	}
	
	/**
	 * The physics engine that determines the bird's flight path
	 * @param yPos the bird's current y position
	 * @return yFinal the bird's final position
	 */
	public int PhysicsEngineUP(int yPos){

		yFinal = yPos + 2;

		//System.out.println("Y Position UP: " + (yFinal)); //Debugging
		//System.out.println(imagePanel.getY()); //Debugging
		
		return yFinal;
	}
	
	/**
	 * The physics engine that determines the bird's flight path
	 * @param yPos the bird's current y position
	 * @return yFinal the bird's final position
	 */
	public int PhysicsEngineDOWN(int yPos){

		yFinal = yPos - 2;

		//System.out.println("Y Position DOWN: " + (yFinal)); //Debugging
		//System.out.println(imagePanel.getY()); //Debugging
		
		return yFinal;
	}
	/**
	 * Chooses where the opening of the pipe is
	 * @param pipe the selected pipe
	 * @return yPipes the location of the pipe
	 */
	public int PipesY (ImagePanel pipe){
		yPipes = pipe.getY() - r.nextInt(100);
		 
		if (yPipes <= -350){
			yPipes = r.nextInt(300)*-1+200;
			if (yPipes >= 0){
				yPipes = -yPipes;
			}
		} 	
		if (yPipes >= -75){
			yPipes = r.nextInt(200)+125;
			if (yPipes >= 0){
				yPipes = -yPipes;
			}
		}
		return yPipes;
	}
}
