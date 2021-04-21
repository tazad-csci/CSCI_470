/***************************************************************
CSCI 470         Program 4     Spring 2021

Programmer: Tamjid Azad

Date Due: 4/23/21

Purpose: Created BallAnimation to which is an object in the east
		     region of the application.
***************************************************************/
package package1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BallAnimation extends JPanel implements ActionListener {

	private final JButton startB = new JButton("Start");
	private final JButton stopB = new JButton("Stop");
	
	AnimationPanel animationPanelPtr = new AnimationPanel();
	
	
	public BallAnimation() {
		stopB.setEnabled(false);
		
		this.setLayout(new BorderLayout());
		
        JPanel southPanelPtr = new JPanel();
	    southPanelPtr.setBackground(Color.LIGHT_GRAY);
	    southPanelPtr.add(startB);
	    southPanelPtr.add(stopB);
	    
		add(animationPanelPtr,BorderLayout.CENTER);
	    add(southPanelPtr,BorderLayout.SOUTH);
	    
	    startB.addActionListener(this); // do this for all buttons ETC , and add  a ActionListener() to combo box as well
	    stopB.addActionListener(this);
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 if (e.getSource() == startB) { 

			 startB.setEnabled(false);
			 stopB.setEnabled(true);
	    	 animationPanelPtr.startBalls();
		 }
	     else if (e.getSource() == stopB) {
	    	 
	    	 stopB.setEnabled(false);
	    	 startB.setEnabled(true);
	    	 animationPanelPtr.stopBalls();
	     }
	}

}
