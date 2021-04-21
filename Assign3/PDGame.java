/***************************************************************
CSCI 470         Program 3     Spring 2021

Programmer: Tamjid Azad

Date Due: 2/21/21

Purpose: Created a class PDGame which represents the game itself
         and controls the logic for it.
***************************************************************/

import java.util.*;
import java.io.*;
import java.lang.reflect.Array;


public class PDGame {

  //data members for the PDGame class
    ArrayList<String> stratgiesUsed = new ArrayList<>();
    private ArrayList<String> stratgiesList = new ArrayList<>();
    private int strategy, computerPlayer;
    private String Score, result;
    private List<String> scannerList = new ArrayList<>();
    GameStat gs1 = null;



/***************************************************************
Function: PDGame Constructor(String file)

Use: Use scanner to read a textfile that has random numbers

Arguments: 1. file: the textfile containing the computer's decisions

Returns: A PDGame object containing the value of the file
***************************************************************/
public PDGame(String file) {
        
        try {

        //create new scanner to read input file
            Scanner myReader = new Scanner(new FileInputStream(file));

        //in the while loop, split each character by a space and retreive it into an arraylist
            while (myReader.hasNextLine()) {
              
                //read the line
                String data = myReader.nextLine();
              
                //split the values apart by a space
                String[] values = data.split(" ");
             
                //store each character into an arraylist
                for (int i = 0; i < values.length; i++) {
                    String data2 = (String) Array.get(values,i);
                    scannerList.add(data2);
                }
            }

            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }


    }

/***************************************************************
Function: void setStrategy(int newStrategy)

Use: Set method for the strategy data member

Arguments: 1. newStrategy: The strategy that you choose the computer to play this game.

Returns: Nothing
***************************************************************/
public void setStrategy(int newStrategy) {

    strategy = newStrategy;
    gs1 = new GameStat();

    //check which strategy was used and store it in an arraylist
    if (newStrategy == 1)
    gs1.setComputerStrategy("Reads Strategy From Input File");
    else if (newStrategy == 2)
    gs1.setComputerStrategy("Tit-For-Tat");
    else if (newStrategy == 3)
    gs1.setComputerStrategy("Tit-For-Two-Tats");
    else if (newStrategy == 4)
    gs1.setComputerStrategy("Random Choice by Computer");
    
}   

/***************************************************************
Function: GameStat getStats()

Use: Get method for the GameStat data member

Arguments: None

Returns: A pointer to GameStat for this game
***************************************************************/    
public GameStat getStats() {
    return gs1;
}
  
 
/***************************************************************
Function: String getScores()

Use: Get method for the GameStat data member

Arguments: None

Returns: A string message indicating what the final scores are
***************************************************************/  
public String getScores() {
    Score = "Your prison sentence is " + gs1.getPlayerYears() + "\n ------ Your partner's/computer prison sentence is: " + gs1.getComputerYears();
    return Score;
}




 
/***************************************************************
Function: String playRound(int decision)

Use: Method that determines the outcome based on the computer and
     player's decisions and update the GameStat object according 
     to the score above.

Arguments: 1. decision : player's decision in that round

Returns: A string message about the outcome based on the two decisions
***************************************************************/ 
public String playRound(int decision) {
  
    gs1.setRound(1);
    int number = gs1.getRound() - 1;

    /**
     * Generates the computer's decision based on the strategy selected
     * by using a series of if statements 
     */
    if (strategy == 1)
    { 
        computerPlayer = Integer.parseInt(scannerList.get(number));
    }
    else if (strategy == 2)
    {

        if (gs1.getRound() == 1)
        {
            computerPlayer = 2;
        }
        else 
        {
            computerPlayer = decision;
        }

    }
    else if (strategy == 3)
    {
        if (gs1.getRound() == 1 || gs1.getRound() == 2)
        {
            computerPlayer = 2;
        }
        else 
        {
            computerPlayer = decision;
        }

    }
    else if (strategy == 4)
    {
        computerPlayer  = (int)(Math.random() * 2+1);
    }



    /**
     *  Determines the outcome of the round based on the computer and player is decision
     *  by using a series of if statements
     */     
    if ( decision == 1 && computerPlayer == 1)
    {
        result = "You both get 2 years in prison.";
        gs1.update(2,2);
    }
    else if (decision == 2 && computerPlayer == 2)
    {
        result = "You both get 3 years in prison.";
        gs1.update(3,3);
    }
    else if (computerPlayer == 1 && decision == 2)
    {
        result = "You testify against your partner and they remain silent. \nYou get 1 year in prison and they get 5.";
        gs1.update(1,5);
    }
    else if (computerPlayer == 2 && decision == 1)
    {
        result = "You remain silent and your partner testify against you. \nYou get 5 year in prison and they get 1.";
        gs1.update(5,1);
    }

    return result;
}
    


/***************************************************************
Function: ArrayList<String> getStrategies() 

Use: Get method for the strategy data member

Arguments: None

Returns: An arraylist of strings which contain the 4 strategies.
***************************************************************/ 
public ArrayList<String> getStrategies() {
        
    stratgiesList.add("Computer Reads Strategy From Input File");
    stratgiesList.add("Tit-For-Tat");
    stratgiesList.add("Tit-For-Two-Tats");
    stratgiesList.add("Random Choice by Computer");

    return stratgiesList;
}


}
