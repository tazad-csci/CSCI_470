/***************************************************************
CSCI 470         Program 6     Spring 2021

Programmer: Tamjid Azad

Date Due: 4/23/21

Purpose: Created GraphicsFrame which contains the two frames to
	 run our program.
***************************************************************/
package package1;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;

public class GraphicsFrame extends JFrame{
   public static void main(String[] args) {
     
	   
      GraphicsFrame frame = new GraphicsFrame(); //create our frame and constructor puts large //main panel over the entire frame
     
      //set the name of the frame
      frame.setName("Frame");
     
      //set the size of the frame
      frame.setSize(400, 400);    
      frame.setVisible(true); 
   }

	/***************************************************************
	 Function: GraphicsFrame()
	 
	 Use: GraphicsFrame Constructor

	 Arguments: None

	 Returns: Nothing
  ***************************************************************/
   public GraphicsFrame() { //constructor
	 super();
	 //final Color VERY_LIGHT_GARY = new Color(204,204,204);
	 
	 JPanel panelOne = new JPanel();
     JPanel panelTwo = new JPanel();
     
     panelOne.setLayout(new BorderLayout());
     panelTwo.setLayout(new BorderLayout());
     
     panelOne.setPreferredSize(new Dimension(638, 300));
     panelTwo.setPreferredSize(new Dimension(638, 300));
     
     this.add(panelOne,BorderLayout.WEST);
     this.add(panelTwo,BorderLayout.EAST);
     
	 MainPanel mainPanelPtr = new MainPanel(); //create mainpanel that will overwrites the frame
	 BallAnimation ballAnimationPtr = new BallAnimation();
	 
	 panelOne.add(mainPanelPtr);
	 panelTwo.add(ballAnimationPtr);
	 
   }
}
