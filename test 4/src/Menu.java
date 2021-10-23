import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;
import java.util.stream.Collectors;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Menu extends JFrame {
	static ArrayList<Movies> movieArray = new ArrayList<Movies>();
	static ArrayList<Board> boardArray = new ArrayList<Board>();
	static ArrayList<Football> footballArray = new ArrayList<Football>();
	private JButton buyMovie;
	private JButton buyGame;
	private JButton footballResults;
	private JButton types;
	private JButton sellGame;
	private JButton equalGame;
	private JButton quit;
	
	
	
	public Menu() {
		super("Jason Graves 4/12/2020");
		setLayout(new FlowLayout());
		buyMovie = new JButton("Buy a Movie");
		buyMovie.setPreferredSize(new Dimension(400,200));
		buyMovie.setFont(new Font("Arial", Font.PLAIN, 32));
		buyGame = new JButton("Buy a Game");
		buyGame.setPreferredSize(new Dimension(400,200));
		buyGame.setFont(new Font("Arial", Font.PLAIN, 32));
		footballResults = new JButton("Enter football results");
		footballResults.setPreferredSize(new Dimension(400,200));
		footballResults.setFont(new Font("Arial", Font.PLAIN, 32));
		types = new JButton("Types of Entertainment");
		types.setPreferredSize(new Dimension(400,200));
		types.setFont(new Font("Arial", Font.PLAIN, 32));
		sellGame = new JButton("Sell a Game");
		sellGame.setPreferredSize(new Dimension(400,200));
		sellGame.setFont(new Font("Arial", Font.PLAIN, 32));
		equalGame = new JButton("Information Printer");
		equalGame.setPreferredSize(new Dimension(400,200));
		equalGame.setFont(new Font("Arial", Font.PLAIN, 32));
		quit = new JButton("Quit");
		quit.setPreferredSize(new Dimension(805,100));
		quit.setFont(new Font("Arial", Font.PLAIN, 32));
		//these lines determine what the buttons look like
		add(buyMovie);
		add(buyGame);
		add(footballResults);
		add(types);
		add(sellGame);
		add(equalGame);
		add(quit);
		//these lines are required to add them to the window
		SelectorClass select = new SelectorClass();
		buyGame.addActionListener(select);
		footballResults.addActionListener(select);
		types.addActionListener(select);
		sellGame.addActionListener(select);
		equalGame.addActionListener(select);
		buyMovie.addActionListener(select);
		quit.addActionListener(select);
		//these lines point the buttons to code below
		
	}//end constructor
	
	
	
	class SelectorClass implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String choice = e.getActionCommand();
			if (choice.contentEquals("Buy a Movie")) {
				buyM();
			}else if (choice.contentEquals("Buy a Game")){
				buyG();
			}else if (choice.contentEquals("Enter football results")){
				doFootball();
			}else if (choice.contentEquals("Types of Entertainment")){
				typesOfEntertainment();
			}if (choice.contentEquals("Sell a Game")) {
				sellingG();
			}else if (choice.contentEquals("Information Printer")){
				printing();
			}else if (choice.contentEquals("Quit")){
				System.exit(0);
		}//end actionPerformed
			
			
	
	}//end ActionListener
		public void buyM() {
			boolean realOutside = false;
			int realYear = 0;
			int realStar = 0;
			String realTitle = "";
			int choice = 1;
			JTextField title = new JTextField();
			JTextField year = new JTextField();
			JTextField star = new JTextField();
			JList outside = new JList(new String[] {"Yes","No"});
			Object[] message = {
					"Title of movie:", title, "Year of release:", year, "Star rating:", star, "Did you watch it outside?", outside};
			int option = JOptionPane.showConfirmDialog(null, message, "Buying a Movie", JOptionPane.DEFAULT_OPTION);
			realTitle = title.getText();
			try {
			 realYear = Integer.parseInt(year.getText());
			}catch(NumberFormatException nfe) {}
			try {
			 realStar = Integer.parseInt(star.getText());
			}catch(NumberFormatException nfe) {}
			//put code for the yes/no box here
			choice = outside.getSelectedIndex();
			if(choice == 0){
				realOutside = true;
			}
			Movies mov = new Movies(realOutside, realTitle, realYear, realStar);
			movieArray.add(mov);
			System.out.println(mov);
			}//end buyM
		
		

		public void buyG() {
			boolean realOutside = false;
			boolean realCards = false;
			boolean realDice = false;
			String realName;
			int realMaximum = 0;
			int realMinimum = 0;
			int choice1 = 0;
			int choice2 = 0;
			int choice3 = 0;
			JTextField maximum = new JTextField();
			JTextField minimum = new JTextField();
			JTextField name = new JTextField();
			JList dice = new JList(new String[] {"Yes","No"});
			JList cards = new JList(new String[] {"Yes","No"});
			JList outside = new JList(new String[] {"Yes","No"});
			Object[] message = {
					"Name of Game: ", name, "Maximum number of players:", maximum, "Minimum age:", minimum, "Does it use dice?", dice, "Does it use cards?", cards, "Did you buy it outside?", outside};
			int option = JOptionPane.showConfirmDialog(null, message, "Buying a Game", JOptionPane.DEFAULT_OPTION);
			try {
				realMaximum =Integer.parseInt(maximum.getText());
			}catch(NumberFormatException nfe) {}
			try {
				realMinimum =Integer.parseInt(minimum.getText());
			}catch(NumberFormatException nfe) {}
			choice3 = outside.getSelectedIndex();
			realName = name.getText();
			if(choice3 == 0){
				realOutside = true;
			}
			choice2 = cards.getSelectedIndex();
			if(choice2 == 0) {
				realCards = true;
			}
			choice1 = dice.getSelectedIndex();
			if(choice1 == 0) {
				realDice = true;
			}
			Board brd = new Board(realName, realOutside, realMinimum, realMaximum, realDice, realCards);
			boardArray.add(brd);
			System.out.println(brd);
			}//end buyG
		
		
		
		public void typesOfEntertainment() {
			JLabel label = new JLabel("<html>The types of entertainment supported by this program are;<br/>1.) Movies. Movies are storys or events recorded by a camera as a set of moving images.<br/>2.) Board Games. Board Games are games played on a board.<br/>3.) Footabll Games. Football is a sport using an oval ball with laces.</html>");
			label.setFont(new Font("Arial", Font.PLAIN, 24));
			JOptionPane.showMessageDialog(null, label, "Types of Entertainment", JOptionPane.DEFAULT_OPTION);
		}//end of typesOfEntertainment
		
		
		
		public void doFootball() {
			String realHomeTeam = "";
			String realAwayTeam = "";
			int realHomeScore = 0;
			int realAwayScore = 0;
			int realMinimum = 0;
			int choice = 0;
			boolean realOutside = false;
			JTextField minimum = new JTextField();
			JTextField homeTeam = new JTextField();
			JTextField homeScore = new JTextField();
			JTextField awayTeam = new JTextField();
			JTextField awayScore = new JTextField();
			JList outside = new JList(new String[] {"Yes","No"});
			Object[] message = {
					"Home Team: ", homeTeam, "Home Score: ", homeScore, "Away Team: ", awayTeam, "Away Score: ", awayScore, "Youngest player's age?", minimum, "Was the game played outside? ", outside};
			int option = JOptionPane.showConfirmDialog(null, message, "FOOTBALL!", JOptionPane.DEFAULT_OPTION);
			try {
				realHomeScore =Integer.parseInt(homeScore.getText());
			}catch(NumberFormatException nfe) {}
			try {
				realAwayScore =Integer.parseInt(awayScore.getText());
			}catch(NumberFormatException nfe) {}
			try {
				realMinimum =Integer.parseInt(minimum.getText());
			}catch(NumberFormatException nfe) {}
			realHomeTeam = homeTeam.getText();
			realAwayTeam = awayTeam.getText();
			choice = outside.getSelectedIndex();
			if(choice == 1) {
				realOutside = true;
			}
			Football foot = new Football(realOutside, realMinimum, realHomeTeam, realAwayTeam, realHomeScore, realAwayScore);
			footballArray.add(foot);
			System.out.println(foot);
		}//end doFootball
		
		
		
		public void sellingG() {
			int choice = 0;
			int choice1 = 1;
			int realPrice = 0;
			double realRealRealPrice = 0;
			double realRealPrice = 0;
			boolean didSell = false;
			boolean taxes = false;
			double SALESTAXRATE = 1.065;
			ArrayList<Integer> sellCounter = new ArrayList<Integer>();
			ArrayList<String> nameArray = new ArrayList<String>();
			DefaultListModel<String> model = new DefaultListModel<>();
			JList<String> list = new JList<String>(model);
			System.out.println(Arrays.deepToString(boardArray.toArray()));
			int numberOfGames = boardArray.size();
			for(int i=0;i<numberOfGames;i++) {
				 String temp;
				 temp = boardArray.get(i).getName();
				model.addElement(temp);
			}
			JTextField much = new JTextField();
			JList tax = new JList(new String[] {"Yes","No"});
			Object[] message = {
					"What game did you sell",list,"How much did you get for it?", much, "Do you need me to calculate the tax?", tax};
			int option = JOptionPane.showConfirmDialog(null, message, "Sell a game", JOptionPane.DEFAULT_OPTION);
			choice = list.getSelectedIndex();
			try {
			boardArray.remove(choice);
			didSell = true;
			}catch(ArrayIndexOutOfBoundsException aioobe) {
				JOptionPane.showMessageDialog(null, "ERROR (you probably didn't select a game)");
			}
			try {
				realPrice =Integer.parseInt(much.getText());
			}catch(NumberFormatException nfe) {JOptionPane.showMessageDialog(null, "Integers only please");}
			choice1 = tax.getSelectedIndex();
			if(choice1 == 0) {
				taxes = true;
			}
			if(taxes == true) {
				realRealPrice = realPrice;
				realRealRealPrice =  (realRealPrice * SALESTAXRATE);
				//System.out.println("tax");
			}else {
			realRealRealPrice = realPrice;
			//System.out.println("no tax");
			}
			if(didSell == true) {
			Object[] message2 = {
					"You sold the game for $" + realRealRealPrice + "!" };
			int option2 = JOptionPane.showConfirmDialog(null, message2, "Sold a game", JOptionPane.DEFAULT_OPTION);
		}
		}//end sellingG
		
		public void printing() {
			JOptionPane.showMessageDialog(null, "All of the information you have entered into this program, \nwill now output in a text file called test4.txt wherever the program is stored\n (this will print duplicates, I can't figure out how to identify duplicates in an ArrayList..");
			try {FileOutputStream fos = new FileOutputStream("test4.txt");
				try {
					
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(movieArray.toString());
					
					ObjectOutputStream oos2 = new ObjectOutputStream(fos);
					oos2.writeObject(boardArray.toString());
					
					ObjectOutputStream oos3 = new ObjectOutputStream(fos);
					oos3.writeObject(boardArray.toString());
					
				} catch (IOException e) {e.printStackTrace();}
			} catch (FileNotFoundException e) {	e.printStackTrace();}
			
			
			
		}//end printing
	
	}}//end class
