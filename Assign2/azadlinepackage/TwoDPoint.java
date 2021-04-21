/***************************************************************
CSCI 470         Program 2     Spring 2021

Programmer: Tamjid Azad

Date Due: 2/7/21

Purpose: Create a TwoDPoint class that has a method accepting
         two integer arguments. It will be used to create a
         second line constructor.
***************************************************************/
package azadlinepackage;
import java.io.*;

public class TwoDPoint {

      //two public data members
	public int x;
	public int y;


        /****************************************************************
        Function: TwoDPoint(int xNew, int yNew)

        Arguments: int xNew, int yNew

        Return: An TwoDPoint object with the points

        Notes: This will be used to create a second line constructor.
        ****************************************************************/
	public TwoDPoint(int xNew, int yNew)
	{
	  this.x = xNew;
	  this.y = yNew;
	}
}
