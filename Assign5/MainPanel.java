/***************************************************************
CSCI 470         Program 5     Spring 2021

Programmer: Tamjid Azad

Date Due: 4/23/21

Purpose: Created MainPanel which is the entire panel of the grid
		     mouse event thread.
***************************************************************/
package package1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainPanel extends JPanel implements ActionListener
{
  String[] imageStringNameA ={"images/pat1.gif","images/pat2.gif","images/pat3.gif","images/pat4.gif","images/pat5.gif"};	
	
	final static Image[] imageA = new Image[5];//image arr holds 5 possible images of gifs we load using toolkit code only one copy needed
	Toolkit TKI = Toolkit.getDefaultToolkit();
	
	JToolBar MainPanelToolBar = new JToolBar(); //pointer to top toolbar for main panel	
	private final JButton resetB = new JButton("Reset");
	
	TileGridPanel tileGridPanelPtr=new TileGridPanel(); //pointer to a panel yellow area where we will “paint” items on a tile Grid
	
	JButton patch1btn; //need to declare 5 buttons for tool bar….and a reset button
	JButton patch2btn;
	JButton patch3btn;
	JButton patch4btn;
	JButton patch5btn;

	public MainPanel()
	{
	  //code the toolkit code that I have shown earlier that loads the images into the one dimensional imagaA
	 
	 this.setLayout(new BorderLayout()); //we will add items to north, center south on main panel
		
	 JPanel Top = new JPanel(); 
	 JPanel Bottom = new JPanel(); 	
		 
	 Top.setBackground(Color.ORANGE);
	 Bottom.setBackground(Color.PINK);
	
	//prepare center area of main panel that is yellow
	 this.add(tileGridPanelPtr, BorderLayout.CENTER); //Adding yellow centerPanel to mainPanel.
	 this.add(Top,BorderLayout.NORTH);
	 this.add(Bottom,BorderLayout.SOUTH);
	 Bottom.add(resetB);
	
	 
	for(int i=0;i<imageA.length;i++)
	{
		imageA[i] = (Image) Toolkit.getDefaultToolkit().getImage(imageStringNameA[i]);
	}
	 
	 
  //prepare north orange area of main panel with toolbar and patch buttons 
 	 patch1btn = new JButton(new ImageIcon(imageA[0]));  //this how you get a button with an image 
	 patch2btn = new JButton(new ImageIcon(imageA[1]));  //this how you get a button with an image
	 patch3btn = new JButton(new ImageIcon(imageA[2]));  //this how you get a button with an image
	 patch4btn = new JButton(new ImageIcon(imageA[3]));  //this how you get a button with an image
	 patch5btn = new JButton(new ImageIcon(imageA[4]));  //this how you get a button with an image
	
	 MainPanelToolBar.add(patch1btn); //add 1 button to toolbar, do this for 5 buttons
	 MainPanelToolBar.add(patch2btn);
	 MainPanelToolBar.add(patch3btn);
	 MainPanelToolBar.add(patch4btn);
	 MainPanelToolBar.add(patch5btn);
	
	 patch1btn.addActionListener(this);//sets up one button for listening, need 5 of them
	 patch2btn.addActionListener(this);
	 patch3btn.addActionListener(this);
	 patch4btn.addActionListener(this);
	 patch5btn.addActionListener(this);
	 resetB.addActionListener(this);
	
	 Top.add(MainPanelToolBar);
	//this.add(MainPanelToolBar,BorderLayout.NORTH);

	
	 //tileGridPanelPtr.ResetGridTile(); //reset grid and and paint empty center area		
	}//end constructor

	
	/***************************************************************
	Function: actionPerformed(ActionEvent e) 

	Use: This checks if any of the buttons have been clicked

	Arguments: ActionEvent e which listens for the button clicks

	Returns: Nothing
	***************************************************************/ 
	public void actionPerformed(ActionEvent e)  { //put in listener method for button clicks on toolbar
	    if (e.getSource() == patch1btn) { //was  button A  clicked in toolbar?
	    	  tileGridPanelPtr.selectedTile = 0;  }//this sets the variable in tileGridPanel object,  and do this check for the 5 possible patches they could chose
	    else if (e.getSource() == patch2btn) { //was  button A  clicked in toolbar?
		      tileGridPanelPtr.selectedTile = 1;}
	    else if (e.getSource() == patch3btn) { //was  button A  clicked in toolbar?
		      tileGridPanelPtr.selectedTile = 2;}
	    else if (e.getSource() == patch4btn) { //was  button A  clicked in toolbar?
		      tileGridPanelPtr.selectedTile = 3;}
	    else if (e.getSource() == patch5btn) { //was  button A  clicked in toolbar?
		      tileGridPanelPtr.selectedTile = 4; }
	    
	    if (e.getSource() == resetB ) {
	    	System.out.println("Clicked button!");
	    	  tileGridPanelPtr.ResetGridTile(); }
	}
}
