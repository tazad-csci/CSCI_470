/***************************************************************
CSCI 470         Program 2     Spring 2021

Programmer: Tamjid Azad

Date Due: 2/7/21

Purpose: Created a line class where we create line objects
         and call different methods to make calculations.
***************************************************************/

package azadlinepackage;
import java.io.*;


public class Line
{

      //four private data members (coordinates of the line)
 	private int x1, y1, x2, y2;


	/***************************************************************
	Function: Line Constructor

	Use: Four integers are used to set the x and y value coordinates

	Arguments: 1. xOne: the value for x1 , 2. yOne: the value for y1,
           3.. xTwo: the value for xTwo, 4.yTwo: the value for yTwo.

	Returns: Receives 4 integers which are the Line's start and end points.
	***************************************************************/
	public Line(int xOne, int yOne, int xTwo, int yTwo) throws Exception
	{
	// each of these validates its argument - see below.
	   try{	setXOne(xOne); }
	   catch (Exception err){}

	   try{setYOne(yOne); }
	   catch (Exception err){throw new Exception();}

           try {  setXTwo(xTwo);}
          catch (Exception err){throw new Exception();}

           try{setYTwo(yTwo);}
          catch (Exception err){throw new Exception();}

         } // end constructor




        /***************************************************************
        Function: Line Constructor

        Use: Takes two class objects from TwoDPoint

        Arguments: 1. value1: the value for x1 , 2. value2: the value for y1,

        Returns: Receives 4 integers which are the Line's start and end points.
        ***************************************************************/
	public Line(TwoDPoint value1, TwoDPoint value2) throws Exception
	{
	  this(value1.x, value1.y, value2.x, value2.y);
	}


        /****************************************************************
        Function: public void draw()

        Use: The method calls another method called drawLine(),that will
             display a text description of the line.

	Arguments: Nothing

        Return: Nothing
        ****************************************************************/
	public void draw()
	{
	    drawLine(x1, y1, x2, y2);
	}


        /****************************************************************
        Function: void drawLine(int x1, int y1, int x2, int y2)

        Parameter: int x1, int y1, int x2, int y2

        Return: nothing

        Notes: Simulates drawing of a line for console mode. It should describe
               all the important attributes of the line.
        ****************************************************************/
	private void drawLine(int x1, int y1, int x2, int y2)
	{
		System.out.println("In a drawline -draw a line from x of " + x1 + " and y of " + y1);
		System.out.println("to x of " + x2 + " and y of " + y2 + " SUCCESS\n");
	}


        /****************************************************************
        Function: void setLine(int xOne, int yOne, int xTwo, int yTwo)

        Parameter: int xOne, int yOne, int xTwo, int yTwo

        Return: Nothing

        Notes: Method setLine() allows user to change the points of the
               already existing Line.
        ****************************************************************/
	public void setLine(int xOne, int yOne, int xTwo, int yTwo)
	{
	  try{setXOne(xOne);} catch(Exception err){}
	  try{setYOne(yOne);} catch(Exception err){}
 	  try{setXTwo(xTwo);} catch(Exception err){}
  	  try{setYTwo(yTwo);} catch(Exception err){}
	}


        /****************************************************************
        Function: void setXOne(int xOne) throws Exception

        Parameter: int xOne

        Return: Nothing

        Notes: In the event of an invalid (offscreen) value, the method
               will throw an exception be caught in the driver code.
        ****************************************************************/
	public void setXOne(int xOne) throws Exception
	{

           String xOneString = String.valueOf(xOne);

	    if (xOne < 0 || xOne > 639)
               throw new Exception(xOneString);
	    else
	       x1 = xOne;
	}


        /****************************************************************
        Function: void setYOne(int yOne) throws Exception

        Parameter: int yOne

        Return: Nothing

        Notes: In the event of an invalid (offscreen) value, the method
               will throw an exception be caught in the driver code.
        ****************************************************************/
	public void setYOne(int yOne) throws Exception
	{
		if (yOne < 0 || yOne > 479)
		  throw new Exception(); //y1 = 0;
		else
		  y1 = yOne;
	}


        /****************************************************************
        Function: void setXTwo(int xTwo) throws Exception

        Parameter: int xTwo

        Return: Nothing

        Notes: In the event of an invalid (offscreen) value, the method
               will throw an exception be caught in the driver code.
        ****************************************************************/
	public void setXTwo(int xTwo) throws Exception
	{
		if (xTwo > 639 || xTwo < 0)
		  throw new Exception(); //x2 = 0;
		else
		  x2 = xTwo;
	}


        /****************************************************************
        Function: void setYTwo(int yTwo) throws Exception

        Parameter: int yTwo

        Return: Nothing

        Notes: In the event of an invalid (offscreen) value, the method
               will throw an exception be caught in the driver code.
        ****************************************************************/
	public void setYTwo(int yTwo) throws Exception
	{
		if (yTwo > 479 || yTwo < 0)
		  throw new Exception(); //y2 = 0;
		else
		  y2 = yTwo;
	}

	//Now for some "get" Access methods to get individual values


        /****************************************************************
        Function: int getXOne()

        Arguments: Nothing

        Return: An int representing the coordinate value.

        Notes: Nothing
        ****************************************************************/
	public int getXOne()
	{
	  return x1;
	}


        /****************************************************************
        Function: int getYOne()

        Arguments: Nothing

        Return: An int representing the coordinate value.

        Notes: Nothing
        ****************************************************************/
	public int getYOne()
	{
	  return y1;
	}


        /****************************************************************
        Function: int getXTwo()

        Arguments: Nothing

        Return: An int representing the coordinate value.

        Notes: Nothing
        ****************************************************************/
	public int getXTwo()
	{
	  return x2;
	}


        /****************************************************************
        Function: int getYTwo()

        Arguments: Nothing

        Return: An int representing the coordinate value.

        Notes: Nothing
        ****************************************************************/
	public int getYTwo() 
	{
	  return y2;
	}


	/***************************************************************
	Function: getLength

	Use:  Calcaultes the length of a Line based on its coordinates

	Arguments: Nothing

	Returns: The length of the line using sqrt function from Math library
	***************************************************************/
	public double getLength()
	{
	return  Math.sqrt( (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2) );
	}


        /***************************************************************
        Function: getAngle

        Use:  Calcaultes the angle of a Line.

        Arguments: Nothing

        Returns: The length of the line using sqrt function from Math library
        ***************************************************************/
	public double getAngle()
	{
	return (Math.asin( (y2 - y1) / getLength() ));
	}


} 
// end class Line

