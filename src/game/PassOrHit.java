/*-------------------------------------------------------------------
 * Author:			Omar Almootassem
 * Written:			Oct/07/2014
 * Last Updated:	N/A
 * 
 * Called by the MoveBird method. It checks if the bird passes 
 * through the openings of the pipes. If the bird hits the pipes, 
 * it calls the Finished method
 ------------------------------------------------------------------*/

package game;

import graphicalUI.Finished;
import graphicalUI.ImagePanel;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class PassOrHit {
	/**
	 * Checks if the bird passed through the pipes
	 * @param pipe1
	 * @param pipe2
	 * @param pipe3
	 * @param bird
	 * @param frame
	 * @param oldPane
	 * @param counter
	 */
	public PassOrHit (ImagePanel pipe1, ImagePanel pipe2, ImagePanel pipe3, ImagePanel bird, final JFrame frame, JLayeredPane oldPane, int counter){
		//locations of the opening in all 3 pipes
		int pipe1Top = pipe1.getY()+418;
		int pipe1Bottom = pipe1.getY()+516;
		int pipe2Top = pipe2.getY()+418;
		int pipe2Bottom = pipe2.getY()+516;
		int pipe3Top = pipe3.getY()+418;
		int pipe3Bottom = pipe3.getY()+516;
		
		//Check if top or right side of bird hits pipe1
		if (pipe1.getX() <= (123+34) && pipe1.getX() >= (123)){
			if (bird.getY() <= pipe1Top || bird.getY() >= pipe1Bottom){
				new Finished(frame, oldPane, counter);
			}

		}
		//Check if top or right side of bird hits pipe2
		if (pipe2.getX() <= (123+34) && pipe2.getX() >= (123)){
			if (bird.getY() <= pipe2Top || bird.getY() >= pipe2Bottom){
				new Finished(frame, oldPane, counter);
			}
		}
		//Check if top or right side of bird hits pipe3
		if (pipe3.getX() <= (123+34) && pipe3.getX() >= (123)){
			if (bird.getY() <= pipe3Top || bird.getY() >= pipe3Bottom){
				new Finished(frame, oldPane, counter);
			}
		}

		//Check if the bottom side of the bird hits pipe1
		if (pipe1.getX() <= (123+34) && pipe1.getX() >= (123)){
			if (bird.getY()+24 <= pipe1Top || bird.getY()+24 >= pipe1Bottom){
				new Finished(frame, oldPane, counter);
			}
		}
		//Check if the bottom side of the bird hits pipe2
		if (pipe2.getX() <= (123+34) && pipe2.getX() >= (123)){
			if (bird.getY()+24 <= pipe2Top || bird.getY()+24 >= pipe2Bottom){
				new Finished(frame, oldPane, counter);
			}
		}
		//Check if the bottom side of the bird hits pipe3
		if (pipe3.getX() <= (123+34) && pipe3.getX() >= (123)){
			if (bird.getY()+24 <= pipe3Top || bird.getY()+24 >= pipe3Bottom){
				new Finished(frame, oldPane, counter);
			}
		}
		
		//If the bird hits the top or bottom boundaries end the game
		if (bird.getY() <= 0 ){
			new Finished(frame, oldPane, counter);
		} else if (bird.getY() >= 512){
			new Finished(frame, oldPane, counter);;
		}

	}
}
