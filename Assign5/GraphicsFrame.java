/***************************************************************
CSCI 470         Program 5     Spring 2021

Programmer: Tamjid Azad

Date Due: 4/9/21

Purpose: Created GraphicsFrame which contains the two frames to
		     run our program.
***************************************************************/
package package1;

import javax.swing.JFrame;
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

   public GraphicsFrame() { //constructor
	 super();
	 MainPanel mainPanelPtr = new MainPanel(); //create mainpanel that will overwrites the frame
	 
	 //we will add subpanels to the large main panel in its constructor
	 this.add(mainPanelPtr,BorderLayout.CENTER); //main panel covers entire frame
}
}
