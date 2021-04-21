/***************************************************************
CSCI 470         Program 3     Spring 2021

Programmer: Tamjid Azad

Date Due: 2/21/21

Purpose: Created a class PDGameApp which provides the interface
         for user input. 
***************************************************************/

import java.util.*;

public class PDGameApp {

 public static void main(String[] args) {

    //initialize the variables for the PDGameApp.java
  Scanner scan1 = new Scanner(System.in);
  String inAnswerString = null;
  int strategyNum, decisionInt;
  boolean playGame = true;
  HashMap<String,GameStat> hashMap1 = new HashMap<>();
  GameStat gs1 = null;
  PDGame currentGamePtr1 = null;
    

    /**
     * In the while loop, continue to play the game until the user 
     * decides not to by choosing 'n'
     */
    while (playGame) 
    {
        int i = 1;
        currentGamePtr1 = new PDGame(args[0]);
        ArrayList<String> list = currentGamePtr1.getStrategies();            //Get pointer to Strategy Arraylist in PDGame     
        System.out.println("***Starting A Session of Prisoner's Dilemma ***-5 rounds in this version of game\n");
        System.out.println("--HERE ARE STRATEGIES AVAILABLE FOR THE COMPUTER");


        /**
         * In the for loop, print out the strategies for the computer to use
         */
        for (String stratagies: list) 
        {
                System.out.println(i + ". " + stratagies);
                i++;
        }

        System.out.print("Select a strategy from above for the Computer to use in the 5 rounds : ");
        strategyNum = scan1.nextInt();

        /**
         * In this while loop, the user selects which Stratagey for
         * the opponent to use in the game. If the number selected is
         * is not valid, the player will be prompted again to pick a 
         * valid strategy  
        ***/
        while (true)
        {
          //if strategy is valid exit the loop
            if (strategyNum < 5 && strategyNum > 0)
                 break;

            System.out.println("\nINVALID COMPUTER STRATAGEY");
            System.out.println("\n--HERE ARE STRATEGIES AVAILABLE FOR THE COMPUTER");
            i = 1;

            for (String st: list) 
            {
                System.out.println(i + ". " + st);
                i++;
            }

            System.out.println("Select a strategy from above for the Computer to use in the 5 rounds : ");
            strategyNum = scan1.nextInt();
        }


    //Set the strategy (int) user chooses for their game in PDGame
        currentGamePtr1.setStrategy(strategyNum);                
        
    //Get pointer to gameStat object out of PDGame
        gs1 = currentGamePtr1.getStats();                                  
        
    //Get a new date object and assign it as a string
        String strDate = new Date().toString();

    //Create a hashmap
        hashMap1.put(strDate, gs1);


        /**
         * For each round get the player's decision and call the
         * playround function in class PDGame and get the outcome
         * of that round
        ***/
        for (int round = 0; round < 5; round++) 
        {
            System.out.println("\n\nBEGIN A ROUND - Here are your 2 choices");
            System.out.println("1. Remain silent.");
            System.out.println("2. Betray and testify against.");
            System.out.print("\n----What is your decision this round?  ");
            decisionInt = scan1.nextInt();

            String result = currentGamePtr1.playRound(decisionInt);

            System.out.println("\n" + result);
        }

        System.out.println("\nEND OF ROUNDS, GAME OVER -- " + currentGamePtr1.getScores()); 
        System.out.println("\nThe winner for this game is: " + currentGamePtr1.getStats().getWinner());
            
           
        System.out.print("\nWould you like to play another game in this session (y/n)?  ");
        inAnswerString = scan1.next();

 

        /**
         * Check if the user wants to play another game
         * using if statement to find out the letter   
        ***/  
        while (true) 
        {
            if (inAnswerString.equalsIgnoreCase("y")) 
                {
                    playGame = true;
                    break;
                }
            else if (inAnswerString.equalsIgnoreCase("n")) 
                {
                    playGame = false;
                    break;
                }

            inAnswerString = scan1.nextLine();
            System.out.print("\nInvalid Response! Would you like to play another game in this session  (y/n): ");
                

        }
            

    }
    
    //use a keyset to get all the keys from hashMap1
    Set<String> keySet2 = hashMap1.keySet();

    /**
     *In the for loop, print out the keys and the winner of each game  
    **/
    //System.out.println("keySet2 " + keySet2 + "\n");
    System.out.println("\nSummary of games and session times:\n");
 
   for (String searchKey3: keySet2)  
   {
      System.out.println("keySet2 " + searchKey3 + "\n");
   }


    for (String searchKey3: keySet2)  
    {
       GameStat gameObject = hashMap1.get(searchKey3); 
       System.out.println(searchKey3 + " \nWinner is -- " + gameObject.getWinnerSummary() + ". The computer used " + gameObject.getComputerStrategy()  + "\n"); 
    }

   }
}
