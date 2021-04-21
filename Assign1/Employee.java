/***************************************************************
CSCI 470         Program 1     Spring 2021

Programmer: Tamjid Azad

Date Due: 1/24/21

Purpose: Created a employee class where we created two objects
         and display their salary before and after their raise.
***************************************************************/

class Employee
{
      //three private instance variables
	private String firstName;
	private String lastName;
	private double salary;


	/****************************************************************
	Function: Employee constructor that initializes the three instance variables

	Parameter: string fristname, string lastname, double salary

	Return: object employee

	Notes: This is the constructor for the employee class
	****************************************************************/
	public Employee(String firstName, String lastName, double salary)
	{
		this.firstName = firstName;
		this.salary = salary;
                this.lastName = lastName;
	}

	//Here are the Getters functions

        /****************************************************************
        Function: This is the getter method for the first_Name variable

        Parameter: nothing

        Return: string for the first name

        Notes: nothing
        ****************************************************************/
	public String getFirstName()
	{
	  return firstName;
	}


        /****************************************************************
        Function: This is the getter method for the last_Name variable

        Parameter: nothing

        Return: string for the last name

        Notes: nothing
        ****************************************************************/ 
        public String getLastName()
	{
	  return lastName;
	}



        /****************************************************************
        Function: This is the getter method for the salary variable

        Parameter: nothing

        Return: double for the salary amount

        Notes: nothing
        ****************************************************************/ 
        public double getSalary()
	{
	  return salary;
	}



        //Here are the Setters functions
        /****************************************************************
        Function: This is the setter method for the first_Name variable

        Parameter: String first that contains the name to be assigned to the first_Name

        Return: void

        Notes: nothing
        ****************************************************************/ 
        public void setFirstName(String first)
	{
	  this.firstName = first;
	}


        /****************************************************************
        Function: This is the setter method for the last_Name variable

        Parameter: String first that contains the name to be assigned to the last_Name

        Return: void

        Notes: nothing
        ****************************************************************/ 
        public void setLastName(String last)
	{
	  this.lastName = last;
	}



        /****************************************************************
        Function: This is the setter method for the salary variable

        Parameter: Double wage that contains the amount to be assigned to the salary

        Return: void

        Notes: nothing
        ****************************************************************/ 
        public void setSalary(Double wage)
	{
	  if (wage >= 0)
	   {
	     this.salary = wage;
	   }
	}


}
