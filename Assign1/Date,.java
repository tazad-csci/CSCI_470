/***************************************************************
CSCI 470         Program 1     Spring 2021

Programmer: Tamjid Azad

Date Due: 1/24/21

Purpose: Created a date class where we created a date object
	       and displayed that object using a method.
***************************************************************/

class Date
{
  //private variables of the date class
	 private int month;
	 private int day;
	 private int year;


  /****************************************************************
   Function: Date constructor that initializes the three instance variables

   Parameter: int month, int day, int year

   Return: object date

   Notes: This is the constructor for the date class that intitalized the values
  ****************************************************************/
	public Date(int month, int day, int year)
	{
		this.month = month;
		this.day = day;
		this.year = year;
	}


        //Here are the Getters functions

  /****************************************************************
   Function: This is the getter method for the getMonth variable

   Parameter: nothing

   Return: int value of the month

   Notes: nothing
  ****************************************************************/ 
   public int getMonth() 
   {
	return month;
   }


        /****************************************************************
        Function: This is the getter method for the dat variable

        Parameter: nothing

        Return: int value of the day

        Notes: nothing
        ****************************************************************/ 
   public int getDay()
   {
	return day;
   }



        /****************************************************************
        Function: This is the getter method for the year variable

        Parameter: nothing

        Return: int value of the year

        Notes: nothing
        ****************************************************************/ 
  public int getYear()
   {
	  return year;
   }



        //Here are the Setters functions

        /****************************************************************
        Function: This is the setter method for the month variable

        Parameter: Int newMonth holds the current value to be assigned to month

        Return: void

        Notes: nothing
        ****************************************************************/ 
  public void setfirstName(int newMonth)
	{
	  this.month = newMonth;
	}



        /****************************************************************
        Function: This is the setter method for the day variable

        Parameter: Int newDay holds the current value to be assigned to day

        Return: void

        Notes: nothing
        ****************************************************************/ 
  public void setlastName(int newDay)
	{
	  this.day = newDay;
	}



  /****************************************************************
   Function: This is the setter method for the year variable

   Parameter: Int newYear holds the current value to be assigned to year

   Return: void

   Notes: nothing
  ****************************************************************/
  public void setsalary(int newYear)
	{
	  this.year = newYear;
	}



 /****************************************************************
  Function: This function displays the month, day, and year

  Parameter: nothing

  Return: String that contains the formatted date using concatenation

  Notes: The format uses forware slashes(/) to separate each variable
 ****************************************************************/
	public String displayDate()
	{
	  return month + "/" + day + "/" + year; 
	}


}


