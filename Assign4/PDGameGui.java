/***************************************************************
CSCI 470         Program 3     Spring 2021

Programmer: Tamjid Azad

Date Due: 2/21/21

Purpose: Created a class PDGameGui which represents GUI interface
		     of the game.
***************************************************************/
package package1;
import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class PDGameGui extends JFrame implements ActionListener  , ListSelectionListener   {

   private final DefaultListModel<String> listModelPtr = new DefaultListModel<String>();

   // Default List model is the standard “mode for how a Jlist will be operated, will put in next statement below

  // private JList<String> finishedGamesListPtr = new JList<String>(listModelPtr); 
   private JList<String>  finishedGamesListPtr = new JList<String>(listModelPtr);;
   
   
   
  // this  is list on top left side and will  show times of games played that user will click to see stats of a game 

 
   private  JComboBox<Object> computerStrategyCB=null; //combo box on right side, pointer will be filled in constructor   
   private final JTextArea gameResultsTA = new JTextArea(30,70); //this is  large text area on right side
 

   private PDGame currentPDGame = null;
   private String gameStartTimeStr = null;
   private final HashMap<String, GameStat> stats = new HashMap<>(); //keep same hashmap for games played
   private int computerStrategy = 1;  //this will be filled in by the choice made by user in combo box

   
   //below are some sample text fields, more are needed…….

   private final JTextField roundsTF = new JTextField(10);
   private final JTextField computerStrategyTF = new JTextField(10);
   private final JTextField playerSentenceTF = new JTextField(10);
   private final JTextField computerSentenceTF = new JTextField(10);
   private final JTextField winnerTF = new JTextField(10);

   
 
   
   private final JLabel listGamesL = new JLabel("List of Games?");
   private final JLabel decisionL = new JLabel("Your decision this round?");
   private final JLabel roundsPlayedL = new JLabel("Rounds Played");
   private final JLabel computerStrategyL = new JLabel("Computer Strategy");
   private final JLabel playerSentenceL = new JLabel("Player Sentence");
   private final JLabel computerSentenceL = new JLabel("Computer Sentence");
   private final JLabel winnerL = new JLabel("Winner");

   

   private final JLabel computerStrategy2L = new JLabel("Computer Strategy");
   private final JButton startB = new JButton("Start New Game");
   private final JButton silentB = new JButton("Remain Slient");
   private final JButton betrayB = new JButton("Testify");



   

   

	public static void main(String[] args)  {  

		System.out.println("Hello");
		createAndShowGUI();
    }  

	
	private static void createAndShowGUI() {

	      PDGameGui pdg1 = new PDGameGui(); //call constructor below to set the window to user
	      pdg1.addListeners();     //method will add listeners to buttons	

	      // Display the window and pack together all the panels, etc
	      pdg1.pack();
	      //pdg1.setExtendedState(JFrame.MAXIMIZED_BOTH);
	      pdg1.setVisible(true);      

	}



	

	//CONSTRUCTOR WHERE YOU BUILD THE SWING INTERFACE (partial code follows)

	   public PDGameGui() {   

	      super("Prisoner's Dilemma");  //fills in the menu are of jframe with message
	      currentPDGame = new PDGame("textFile.txt");
	      super.setLayout(new BorderLayout());
	      this.setLayout(new BorderLayout());
	      this.setVisible(true);

	      JPanel container = new JPanel();
	      JPanel panelOne = new JPanel();		//left frame
	        
	      TitledBorder title;
	      title = BorderFactory.createTitledBorder("List of games");
	      panelOne.setBorder(title); 
	      panelOne.setBackground(Color.CYAN);
	        
	      JPanel panelTwo = new JPanel();	    //right frame
	      panelTwo.setBackground(Color.orange);
	        
	      panelOne.setLayout(new BorderLayout());
	      panelTwo.setLayout(new BorderLayout());
	        
	        
	        super.add(panelOne,BorderLayout.WEST);
	        super.add(panelTwo,BorderLayout.EAST);
	        this.add(container);
	    
		    JPanel panel3 = new JPanel();
		    panel3.setBackground(Color.CYAN);
		    
		    GridLayout layout = new GridLayout(5,2);
		    layout.setVgap(25);
		    panel3.setLayout(layout);
		    
		    roundsTF.setEditable(false);
		    computerStrategyTF.setEditable(false);
		    playerSentenceTF.setEditable(false);
		    computerSentenceTF.setEditable(false);
		    winnerTF.setEditable(false);
		    
	      panel3.add(roundsPlayedL);
		  panel3.add(roundsTF);
		  panel3.add(computerStrategyL);
	      panel3.add(computerStrategyTF);
		  panel3.add(playerSentenceL);
		 panel3.add(playerSentenceTF);
		 panel3.add(computerSentenceL);
		 panel3.add(computerSentenceTF);
	     panel3.add(winnerL);  	     
		 panel3.add(winnerTF);   


		      //set up JLIST and put it in a scroll pane for scrolling
		finishedGamesListPtr.setFont(new Font("SansSerif", Font.BOLD, 24));
        finishedGamesListPtr.add(listGamesL,BorderLayout.NORTH);
	    finishedGamesListPtr.setVisibleRowCount(20);
		finishedGamesListPtr.setFixedCellWidth(550);
		finishedGamesListPtr.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		 panelOne.add(new JScrollPane(finishedGamesListPtr),BorderLayout.NORTH);		    
		 panelOne.add(panel3,BorderLayout.SOUTH);       

		//fill in other panels, grids etc
		  panelTwo.setLayout(new BorderLayout());
		   
		  JPanel panel5 = new JPanel();
		  panel5.setBackground(Color.orange);

		     
		  GridLayout layout2 = new GridLayout(2,1,0,25);
		  panel5.setLayout(layout2);

		      

	//Two statements below prepare the combo box with computer strategies, need to convert the strategies array list to an array , and then it gets placed in combo box
		  Object[] strategyArray = currentPDGame.getStrategies().toArray();//convert AL to array
		  computerStrategyCB = new JComboBox<Object>(strategyArray);   //place array in combo box
		  computerStrategyCB.setSelectedIndex(0); //this sets starting value to first string in array

		      
		  JPanel panel7 = new JPanel();
		  panel7.setBackground(Color.orange);
		  panel7.setLayout(new FlowLayout());
		  panel7.add(computerStrategy2L);
		  panel7.add(computerStrategyCB);
		  panel7.add(startB);
		      

		  panel5.add(panel7,BorderLayout.WEST);

	        

		  JPanel panel8 = new JPanel();
		  panel8.setBackground(Color.orange);
		  panel8.setLayout(new FlowLayout());
		  panel8.add(decisionL);
		  panel8.add(silentB);
		  panel8.add(betrayB);

		      

		  panel5.add(panel8,BorderLayout.EAST);
		  JPanel panel6 = new JPanel();
		  panel6.setBackground(Color.orange);	      

		      

		  panel6.add(new JScrollPane(gameResultsTA));
		  panelTwo.add(panel5,BorderLayout.NORTH);
		  panelTwo.add(panel6,BorderLayout.SOUTH);

		      
	      setVisible(true);

	       
	      

	   } //end constructor


	private void addListeners() {

		// TODO Auto-generated method stub	

	     startB.addActionListener(this); // do this for all buttons ETC , and add  a ActionListener() to combo box as well
	     silentB.addActionListener(this);
	     betrayB.addActionListener(this);

	     finishedGamesListPtr.addListSelectionListener(this); //the  JLIST event listener code is addListSelectionListener

	}
	
	
	public void clearTextField() {
	     roundsTF.setText(""); 
	     computerStrategyTF.setText(""); 
	     playerSentenceTF.setText(""); 
	     computerSentenceTF.setText(""); 
	     winnerTF.setText(""); 
	}
	
	int counter = 0;
	//here is some guidance to start the game when start game is pressed by the user
	   public void startGame()  { 
		   
		 clearTextField();
	     gameResultsTA.setText("");
	     
	     startB.setEnabled(false);
		 betrayB.setEnabled(true);
		 silentB.setEnabled(true);
	     
		 counter = 0;
		 computerStrategy = computerStrategyCB.getSelectedIndex() + 1;
		 currentPDGame = new PDGame("textFile.txt");
		 currentPDGame.setStrategy(computerStrategy);

		 gameStartTimeStr = (new Date()).toString();
	     stats.put(gameStartTimeStr, currentPDGame.getStats());
	            
	     gameResultsTA.append("***Prisoner's Dilemma***\n\n");
	     promptPlayer();   
	   }
	   
	   public void promptPlayer() {
		   		
		 gameResultsTA.append("1. Cooperate with your partner and remain silent."+ "\n2. Betray and testify against your partner.\n\nWhat is your decision this round?");		   
		 counter++;
		 System.out.println("\nTHE COUNTER IS " + counter + "\n\n");
	   }

	
	   public void cooperate() {
		 clearTextField();

		 String result = currentPDGame.playRound(1);
		 gameResultsTA.append("\n\n"+ result + "\n\n");
		 
		 if (counter == 5) {
			 startB.setEnabled(true);
			 betrayB.setEnabled(false);
			 silentB.setEnabled(false);
			 getWinner();
			 endGame();
		 }
		 else {
			 promptPlayer(); 
		 }
	   }
	   
	   public void betray() {
		 clearTextField();

		 String result = currentPDGame.playRound(2);
		 gameResultsTA.append("\n\n"+ result+ "\n\n");
		 if (counter == 5) {
			   startB.setEnabled(true);
			   betrayB.setEnabled(false);
			   silentB.setEnabled(false);
			   getWinner();
			   endGame();
		   }
		   else {
			   promptPlayer(); 
		   }
	   }
	   
	   
	   
	   public void endGame()  {
		   stats.put(gameStartTimeStr, currentPDGame.getStats());
		   listModelPtr.addElement(gameStartTimeStr);		   
	   }
	   
	   
	   public void getWinner() {
		   
		 clearTextField();
		   
		 gameResultsTA.append("\nEND OF ROUNDS, GAME OVER -- " + currentPDGame.getScores()); 
		 gameResultsTA.append("\nThe winner for this game is: " + currentPDGame.getStats().getWinner() + "\n\n\n");
		 roundsTF.setText(roundsTF.getText() + currentPDGame.getStats().getRound());
		 computerStrategyTF .setText(computerStrategyTF .getText() + currentPDGame.getStats().getComputerStrategy());
		 playerSentenceTF .setText(playerSentenceTF .getText() + currentPDGame.getStats().getPlayerYears());
		 computerSentenceTF .setText(computerSentenceTF .getText() + currentPDGame.getStats().getComputerYears());
		 winnerTF.setText(winnerTF .getText() + currentPDGame.getStats().getWinnerSummary());
		     
	   }

    public void actionPerformed(ActionEvent e) {
    	
	    if (e.getSource() == startB) {
		     startGame(); 
	    } else if (e.getSource() == silentB) {
		     cooperate();
	    } else if (e.getSource() == betrayB) {
		      betray();
	    } else if (e.getSource() == computerStrategyCB) {  //when user chooses an item in combo box, this handles it
		      computerStrategy = computerStrategyCB.getSelectedIndex() + 1; //fills in this variable up top
	    }  
	    
    }



	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
			
		String searchKey = (String) finishedGamesListPtr.getSelectedValue(); //get out time of game and look up in hash map
		GameStat selectedGame = stats.get(searchKey);
		
		 int playerSentenceYrs = selectedGame.getPlayerYears();
	     int computerSentenceYrs = selectedGame.getComputerYears();
	     String computerMethod = selectedGame.getComputerStrategy();
	     String winner = selectedGame.getWinner();

	     roundsTF.setText(Integer.toString(selectedGame.getRound()));
	     roundsTF.setFont( new Font("SansSerif", Font.BOLD, 24));
	        
	       
	     computerStrategyTF.setText(computerMethod);
	     computerSentenceTF.setText(Integer.toString(computerSentenceYrs));
	     winnerTF.setText(winner);
	     playerSentenceTF.setFont( new Font("SansSerif", Font.BOLD, 24));
	     playerSentenceTF.setText(String.format("%d %s", playerSentenceYrs, 
	                ((playerSentenceYrs > 1) ? " years" : " year")));
	     
        }

}



