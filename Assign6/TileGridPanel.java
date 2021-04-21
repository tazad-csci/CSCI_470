/***************************************************************
CSCI 470         Program 4     Spring 2021

Programmer: Tamjid Azad

Date Due: 4/23/21

Purpose: Created TileGridPanel which is the yellow area in the
		     middle we listen for mouse events to draw the grid.
***************************************************************/
package package1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TileGridPanel extends JPanel implements MouseListener
{
	int selectedTile = -1; //this is set to 0-4 when user clicks on a button in toolbar in mainpanel
	
	//create the variables for the 2darray
	static final int squareSide = 25; 
	int GridRow=5,GridCol=5;
	int gridHeight, gridWidth, startX, startY;
	
	Image[][] gif2dArray = new Image[GridRow][GridCol]; //we take gifs in here and draw in tilegrid

	//constructor
	 public TileGridPanel()
	  {  
		 this.addMouseListener(this);  //tells this panel we have routines for mousevents interface
	     this.setBackground(Color.yellow);
	  }
	 
	 
	/***************************************************************
	Function: void mouseClicked(MouseEvent event)

	Use: This will fill the gif2darray with the icon selected by the user from the toolbar

	Arguments: MouseEvent event used to check when the user has click in the yellow center panel

	Returns: Nothing
	***************************************************************/
	 public void mouseClicked(MouseEvent event) { //user has click  in the yellow center panel
		  
		  //code a loop to fill the gif2darray above with the selected image out of MainPanel.imagaA[]
		    this.repaint();  //show new grid with your images from 2d array
		  
		    for (int row = 0; row < gif2dArray.length; row++) { 
		   	  for (int col = 0; col < gif2dArray[row].length; col++) { 
		   		   gif2dArray[row][col] = MainPanel.imageA[selectedTile]; 
		    	 } 
		      }
		    
		 }
			 
	 
	 
	 
	/***************************************************************
	Function: void ResetGridTile()

	Use: Nulls the 2darray so that it shows no icons

	Arguments: None

	Returns: Nothing
	***************************************************************/  
	public void ResetGridTile() {   

		 for (int row = 0; row < gif2dArray.length; row++) { 
		   	  for (int col = 0; col < gif2dArray[row].length; col++) { 
		   		 gif2dArray[row][col] = null;  //use in/out loop  to set all to null
		   	 } 
		}
		
	  this.repaint();  //draw empty grid
	  
	}
	
	
	/***************************************************************
	Function: void paintComponent(Graphics g)

	Use: This will get the center of the panel and draw the 2darray containing the icon

	Arguments: Graphics g used to call base constructor

	Returns: Nothing
	***************************************************************/ 
	@Override
	public void paintComponent(Graphics g)	//paints the center panel with elements in 2darray
	{ 
	  super.paintComponent(g);
	  gridWidth = GridCol*squareSide;  //need to find center area of the center panel
	  gridHeight = GridRow*squareSide;
	  int panelWidth = getWidth();
	  int panelHeight = getHeight();
	  System.out.println(panelWidth);
	  System.out.println(panelHeight);

	  startX = (panelWidth-gridWidth)/2;//get starting point to draw grid based 
	  startY = (panelHeight-gridHeight)/2;
	  System.out.println(startX);
	  System.out.println(startY);
	  
	 //copy gif image array over to the drawing grid with inner/ outer loop
	    for (int row = 0; row < gif2dArray.length; row++) { 
		   	  for (int col = 0; col < gif2dArray[row].length; col++) { 
		   		 g.drawImage(gif2dArray[row][col], startX+(squareSide*row), startY+(squareSide*col), this);
		   	 } 
		}
	  
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}
