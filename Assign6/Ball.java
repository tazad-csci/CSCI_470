/***************************************************************
CSCI 470         Program 6     Spring 2021

Programmer: Tamjid Azad

Date Due: 4/23/21

Purpose: Created Ball to represent a single bouncing ball in the
	 animation.
***************************************************************/
package package1;

import java.awt.*;

public class Ball  {

	 Color color; //Color, radius, coordinates, and movement.
	 int radius, width;
	 int x, y;
	 int dx, dy;
 
	 /***************************************************************
	 Function: Ball(Color col, int rad, int x, int y, int dx, int dy)

	 Use: Ball constructor 

	 Arguments: None

	 Returns: Nothing
     ***************************************************************/
	 Ball(Color col, int rad, int x, int y, int dx, int dy) { //Constructor statement.
		 this.color = col;
		 this.radius = rad;
		 this.x = x;
		 this.y = y;
		 this.dx = dx;
		 this.dy = dy;
	 }

	 
	/***************************************************************
	 Function: void move(Dimension dPanel)

	 Use: Calculates how the call should moce based on its measurements.

	 Arguments: A dimension object that contains the width & height 
	 		    of the panel in which the ball is moving.

	 Returns: Nothing
     ***************************************************************/
	 public void move(Dimension dPanel) { //Move function.
		 if(x <= radius || x >= (dPanel.width - ( 2 * radius))) //Checks to see if ball has hit the edge of the panel.
		 dx = -dx; //If so, switch direction.
		
		 if(y <= radius || y >= (dPanel.height - (2 * radius))) //Same for y direction.
		 dy = -dy;
		
		 x += dx; //If not, continue moving the ball in the direction and modify the coordinates to reflect the move.
		 y += dy;
		 
	 }

	 
	/***************************************************************
	 Function: void draw(Graphics g) 

	 Use: Use the object to set the drawing color to the color of the
	 	  ball and then use it to call fillOval() to draw the ball.

	 Arguments: Graphics object that will beused to draw the ball on
	 		    an off-screen image.

	 Returns: Nothing
     ***************************************************************/
	 public void draw(Graphics g) //Draws the ball in its new location, chaning x and y each time.
	 {
		 g.setColor(color); //Sets the color to whatever the balls color was.
		 g.fillOval(x, y, 2 * radius, 2 * radius); //Draws the ball in the new location.
	 }
	 	 
}
