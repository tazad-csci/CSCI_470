/***************************************************************
CSCI 470         Program 2     Spring 2021

Programmer: Tamjid Azad

Date Due: 2/3/21

Purpose: This is the testline driver code that will create the
         Line and TwoDPoint objects and call their methods..
***************************************************************/

//recieves the class from this subdirectory
import azadlinepackage.*;

class TestLine {

      public static void main(String args[]) 
      {
      //declare an instance of the line calss and initialize as NULL
	Line l1 = null, l2 = null, l3 = null, l4 = null; 

      //initialize the line object l1 
	try
	{
	  l1 = new Line (10, 10, 100, 100);
	}
        catch (Exception err)
        {
          System.out.println("EXCEPTION:This try catch caught a Generic Exception for a bad constructor -Failed to create\n");
          System.out.println(" a line with 4 invalid values-leaving with rc of 88");
        }

	//draw it
	l1.draw();

	//change start point with valid values
	l1.setLine(5, 5, l1.getXTwo(), l1.getYTwo());

	//draw it again with new start point
	l1.draw();


	//try to change xOne (x1) to an illegal value
	try
	{
	  l1.setXOne(3000);
	}
	catch (Exception err)
	{
           System.out.println("-EXCEPTION: MY TRY CATCH CAUGHT A GENERIC EXECPTION IN A SET METHOD\n FOR BAD VALUE OF X1 FOR AN EXISTING LINE");
           System.out.println("\n   " + err + "  Was out of Bounds\n");
	}

	//draw the line...x1 should now be zero
	l1.draw();


	try
	{
	 //create a second Line instance, or object
	   l2 = new Line(100, 100, 400, 400); 
	}
       catch (Exception err)
       {
 	     System.out.println("EXCEPTION:This try catch caught a Generic Exception for a bad constructor -Failed to create\n");
             System.out.println(" a line with 4 invalid values-leaving with rc of 88");
       }


     //draw 2nd line
       l2.draw();


      try
      {
	  //set a new valid yTwo for line 2 
	  l2.setYTwo(479); 
      }
      catch (Exception err)
      {
  	  System.out.println("-EXCEPTION: MY TRY CATCH CAUGHT A GENERIC EXECPTION IN A SET METHOD\n FOR BAD VALUE OF X1 FOR AN EXISTING LINE");
          System.out.println("\n   " + err + "  Was out of Bounds\n");
      }


     //draw 2nd line again 
       l2.draw();


       //print out the angle of both of the lines
        System.out.println("The Angle for line 1 is " + l1.getAngle());
        System.out.println("The Angle for line 2 is " + l2.getAngle() + "\n");

      //print out the length of both of the lengths
        System.out.println("The Length for line 1 is " + l1.getLength());
        System.out.println("The Length for line 2 is " + l2.getLength() + "\n");

     //create two TwoDPoint  objects
	TwoDPoint twoDPointVal1 = new TwoDPoint(10,100);
        TwoDPoint twoDPointVal2 = new TwoDPoint(5,400);


      //this will create new coordinates using the seond line constructor that takes two  TwoDPoint values
	try
	{
	  l3 = new Line(twoDPointVal1,twoDPointVal2);
	}
	catch (Exception err)
	{
          System.out.println("EXCEPTION:This try catch caught a Generic Exception for a bad constructor -Failed to create\n");
          System.out.println(" a line with 2 invalid values-leaving with rc of 88");
	}


     //print out the value of each of the coordinate points
        System.out.println("test 2D point Constructor X1 = " + l3.getXOne());
        System.out.println("\ntest 2D point Constructor X2 = " + l3.getXTwo());
        System.out.println("\ntest 2D point Constructor Y1 = " + l3.getYOne());
        System.out.println("\ntest 2D point Constructor Y2 = " + l3.getYTwo());


      //this code will throw an exception since the values are out of range
	try
	{
	 l4 = new Line(10,20,3000,20);
	}catch (Exception err)
	{
	  System.out.println("\nEXCEPTION: This try catch caught a Generic Exception for a bad constructor - Failed to create a \nline with 4 invalid values leaving with re of 88");
	  System.out.println("\nJava Result: 88");
	  System.out.println("\n\nBUILD SUCCESSFUL (total time: 0 seconds)");
	  System.exit(88);
	}

    } // end of main

}  // end class TestLine
