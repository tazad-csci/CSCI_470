/***************************************************************
CSCI 470         Program 1     Spring 2021

Programmer: Tamjid Azad

Date Due: 1/24/21

Purpose: Contains the driver code for produceing output to demomstrate
	       the Employee and Date class.
***************************************************************/

public class DriverTest {

	/********************************************************
	Function: public static void main(string[] args)

	Parameter: String[] args

	Returns: Nothing

	Notes: Conains the driver code that shows screen output
	*********************************************************/
	public static void main(String[] args)
	{
	     //test for the Employee.java file
	        Employee John = new Employee( "John", "Anderson", 4500.00 );
		Employee Kevin = new Employee( "Kevin", "Johnson", 3000.00 );


	     //print out the salaries for john
		System.out.println("Here is the salaries for John and Kevin");
		System.out.println("------------------------------------------");

    System.out.println("This is the salary of John " + John.getSalary(
    System.out.println("This is the salary of Kevin " + Kevin.getSalary());

  //give each employee a ten percent raise
		John.setSalary(4950.00);
    Kevin.setSalary(3300.00);


 //print each employee's salary after the raise
    System.out.println("\nHere is their salaries after a 10% hike");
    System.out.println("------------------------------------------");

	  System.out.println("This is the salary of John after a hike of 10% " + John.getSalary());
	  System.out.println("This is the salary of kevin after a hike of 10% " + Kevin.getSalary());

 //test for the Date.java file
    Date myObj = new Date(1,11,21);
    Date myObj2 = new Date(2,23,18);


 //print out the date
    System.out.println("\nHere is the date");
    System.out.println("---------------");
    System.out.println("Date: " + myObj.displayDate() + "\n");

	}
}
