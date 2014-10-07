/*-------------------------------------------------------------------
 * Author:			Omar Almootassem
 * Written:			Oct/06/2014
 * Last Updated:	Oct/07/2014
 * 
 * Called by the MoveBird class. ScoreCounter checks if the bird
 * passed through the pipes. If the bird passed through the pipes
 * the counter increases by 1.
 ------------------------------------------------------------------*/

package game;

import graphicalUI.ImagePanel;

import javax.swing.JLabel;

public class ScoreCounter {
	
	//flags to check if the pipe is counted
	boolean count1 = true;
	boolean count2 = true;
	boolean count3 = true;
	/**
	 * Implements the counter for the game
	 * @param label counter label
	 * @param pipe1 first pipe
	 * @param pipe2 second pipe
	 * @param pipe3 third pipe
	 * @param counter the counter, starts at 0
	 */
	public ScoreCounter (JLabel label, ImagePanel pipe1, ImagePanel pipe2, ImagePanel pipe3, int counter){
		counter = Integer.parseInt(label.getText());
		// Counting the score
		if (pipe1.getX() >= 117 && pipe1.getX() <= 123 && count1 == true){
			label.setText(String.valueOf(counter= counter+1));
			count1 = false;
		}else if (pipe2.getX() >= 117 && pipe2.getX() <= 123 && count2 == true){
			label.setText(String.valueOf(counter= counter+1));
			count2 = false;
		}else if (pipe3.getX() >= 117 && pipe3.getX() <= 123 && count3 == true){
			label.setText(String.valueOf(counter= counter+1));
			count3 = false;
		}else{
			count1 = true;
			count2 = true;
			count3 = true;
		} 
		//System.out.println ("Counter: "+ label.getText()); // Debugging
	}
}
