/***************************************************************
CSCI 470         Program 4     Spring 2021

Programmer: Tamjid Azad

Date Due: 4/23/21

Purpose: Created AnimationPanel to display the animation in a
		     separate background thread.
***************************************************************/
package package1;

import java.awt.*;
import java.util.*;
import javax.swing.*;


class AnimationPanel extends JPanel implements Runnable {

	ArrayList<Ball> ballArraylist = new ArrayList<Ball>();
	Dimension ballPanelDimPtr = null;
	Thread threadObjPtr = null;
	
	public void startBalls() {

	    if (threadObjPtr == null) {
	    	threadObjPtr = new Thread(this,"BALL");
	    	threadObjPtr.start();
	    }
	}


	public void stopBalls() {
		// TODO Auto-generated method stub
		threadObjPtr = null;
	}
	
	public void run() {
		
		while (threadObjPtr != null)
		{
			try {
				Thread.sleep(100);
			}
			catch(InterruptedException e) {
			}
			this.repaint();	
		}
	}
	

	@Override
	protected void paintComponent(Graphics g)	//paints the center panel with elements in 2darray
	{ 
	  super.paintComponent(g);
	  this.setBackground(Color.WHITE);

	  if (ballPanelDimPtr == null) {

		  ballPanelDimPtr = this.getSize();
		  ballArraylist.add(new Ball(Color.GREEN, (ballPanelDimPtr.width * 1/50), (ballPanelDimPtr.height - 28), 330, 6, 5));
		  ballArraylist.add(new Ball(Color.PINK, (ballPanelDimPtr.width * 1/45), (ballPanelDimPtr.height - 28), 250, 12, 5));
		  ballArraylist.add(new Ball(Color.YELLOW, (ballPanelDimPtr.width * 1/35), (ballPanelDimPtr.height - 28), 180, 25, 5));
		  ballArraylist.add(new Ball(Color.RED, (ballPanelDimPtr.width * 1/30), (ballPanelDimPtr.height - 28), 300, -4, 5)); 
		  ballArraylist.add(new Ball(Color.ORANGE, (ballPanelDimPtr.width * 1/55), (ballPanelDimPtr.height - 28), 275, -4, 5)); 
	  }
	  
	  for(Ball ball: ballArraylist){
			ball.move(ballPanelDimPtr);
			ball.draw(g);
	   }
	   
	}
	
}
