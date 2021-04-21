/***************************************************************
CSCI 470         Program 3     Spring 2021

Programmer: Tamjid Azad

Date Due: 2/21/21

Purpose: Created a class GameStat which tracks the rounds played as
         well as the player and computer total years/sentence.
***************************************************************/
package package1;

public class GameStat {

 //data members containing the years that each player has received
    private int computerYears = 0, playerYears = 0;

 //data member which holds the number of rounds played
    private int Round = 0;

 //data members which contains the strategy and winner of the game
    private String computerStrategy, stringWinner;
    

    
    /***************************************************************
    Function: int getRound()

    Use: Get method for the Round data member

    Arguments: None

    Returns: An integer indicating how many rounds played
    ***************************************************************/  
    public int getRound() {
        return Round;
    }


    /***************************************************************
    Function: void setRound(int newRound)

    Use: Set method for the Round data member

    Arguments: 1. newRonud: an integer with the new round to be played

    Returns: Nothing
    ***************************************************************/  
    public void setRound(int newRound) {
        Round += newRound;
    }


    /***************************************************************
    Function: int getPlayerYears()

    Use: Get method for the playerYears data member

    Arguments: None

    Returns: An integer determining how many years the player has
    ***************************************************************/  
    public int getPlayerYears() {
        return playerYears;
    }


    /***************************************************************
    Function: int getComputerYears()

    Use: Get method for the getComputerYears data member

    Arguments: None

    Returns: An integer determining how many years the computer has
    ***************************************************************/  
    public int getComputerYears() {
        return computerYears;
    }



    /***************************************************************
    Function: void update(int userSentence, int compSentence)

    Use: Increments the stats and is called from PDGame.

    Arguments: 1. userSentence: an integer representing the years the user must serve
               2. compSentence: an integer representing the years the computer must serve

    Returns: Nothing
    ***************************************************************/ 
    public void update(int userSentence, int compSentence) {
        playerYears += userSentence;
        computerYears += compSentence;
        //System.out.println("The playerYears inside update is " + playerYears + "!!");
        //System.out.println("The computerYears inside update is " + computerYears + "!!");
    }


    
    /***************************************************************
    Function: void setComputerStrategy(String newStrategy)

    Use: Set method for the computerStrategy data member

    Arguments: 1. newStrategy: a string representing the computer's strategy

    Returns: Nothing
    ***************************************************************/ 
    public void setComputerStrategy(String newStrategy) {
        computerStrategy = newStrategy;
    }


    /***************************************************************
    Function: String getComputerStrategy()

    Use: Get method for the computerStrategy data member

    Arguments: None

    Returns: A string containing the computer's strategy
    ***************************************************************/ 
    public String getComputerStrategy() {
        return computerStrategy;
    }


    /***************************************************************
    Function: String getWinnerSummary()

    Use: Get method for the stringWinner data member

    Arguments: None

    Returns: A string containing the winner of the game
    ***************************************************************/ 
    public String getWinnerSummary() {
        if (playerYears > computerYears)
        {
            stringWinner = "computer";
        }
        else if (playerYears < computerYears)
        {
            stringWinner = "player";
        }
        else
        {
            stringWinner = "Nobody";
        }
        return stringWinner;

    }

    /***************************************************************
    Function: String getWinner()

    Use: Get method for the stringWinner data member

    Arguments: None

    Returns: A string containing the winner of the game
    ***************************************************************/ 
    public String getWinner() {
        if (playerYears > computerYears)
        {
            stringWinner = "your opponent game computer";
        }
        else if (playerYears < computerYears)
        {
            stringWinner = "you the game player";
        }
        else
        {
            stringWinner = "Tie";
        }
        return stringWinner;

    }

}
