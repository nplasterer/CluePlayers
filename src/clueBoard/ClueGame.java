package clueBoard;
import java.awt.Color;
import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;
//Naomi and Brandon
import java.util.ArrayList;
import java.util.Scanner;

public class ClueGame {
	private ArrayList<ComputerPlayer> computer;
	private Solution answer;
	private ArrayList<Card> cards;
	private HumanPlayer human;
	private boolean turn;
	private Player currentPlayer;
	private String playerFile;

	public ClueGame() {
		computer = new ArrayList<ComputerPlayer>();
		cards = new ArrayList<Card>();
		human = new HumanPlayer();
		setPlayerFile("Players.txt");
	}
	
	public void deal(){
		
	}
	
	public void loadConfigFiles(){
		try {
			loadPlayerConfigFile(playerFile);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (BadConfigFormatException e) {
			System.out.println(e);
		}
		
		
	}
	
	public void selectAnswer(){
		
	}
	
	public Card handleSuggestion(Solution suggestion){
		return null;
	}
	
	public boolean checkAccusation(Solution solution){
		return turn;
	}

	
	//load separate config files to test for exceptions
	public void loadPlayerConfigFile(String file) throws FileNotFoundException, BadConfigFormatException {
		FileReader playerReader = new FileReader(file);
		Scanner playerScanner = new Scanner(playerReader);
		HumanPlayer human;
		ComputerPlayer currentComputer;
		final int numColumns = 4;
		int row = 0, column = 0;
		int numRows = 0;
		Point location;
		String name;
		java.awt.Color color;
		
		while(playerScanner.hasNextLine()) {
			String inputLine = playerScanner.nextLine();
			String[] parts = inputLine.split(",");
			
			//if first line, create human player
			if(numRows == 0) {
				//check for all data
				if(parts.length != numColumns) 
					throw new BadConfigFormatException("Too few columns in player legend file");
				else {
					name = parts[0];
					row = Integer.parseInt(parts[1]);
					column = Integer.parseInt(parts[2]);
					location = new Point(row,column);
					color = convertColor(parts[3]);
					human = new HumanPlayer(name, location, color);
					this.human = human;
				}
				
			}
			//otherwise make computer player
			else {
				//check for all data
				if(parts.length != numColumns) 
					throw new BadConfigFormatException("Too few columns in player legend file");
				else {
					name = parts[0];
					row = Integer.parseInt(parts[1]);
					column = Integer.parseInt(parts[2]);
					location = new Point(row,column);
					color = convertColor(parts[3]);
					currentComputer = new ComputerPlayer(name, location, color);
					this.computer.add(currentComputer);
				}
			}
			numRows++;
		}
	}
	
    // Be sure to trim the color, we don't want spaces around the name
	public Color convertColor(String strColor) {
		Color color; 
		try {     
			// We can use reflection to convert the string to a color
			Field field = Class.forName("java.awt.Color").getField(strColor.trim());     
			color = (Color)field.get(null); } 
		catch (Exception e) {  
			color = null; // Not defined } 
		}
		return color;
	}
	
	public void loadCardConfigFile(String file) throws FileNotFoundException, BadConfigFormatException {
	
	}

	//Getters and Setters for tests
	public Solution getAnswer() {
		return answer;
	}

	public void setAnswer(Solution answer) {
		this.answer = answer;
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setComputer(ArrayList<ComputerPlayer> computer) {
		this.computer = computer;
	}

	public ArrayList<ComputerPlayer> getComputer() {
		return computer;
	}

	public HumanPlayer getHuman() {
		return human;
	}
	
	
	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public String getPlayerFile() {
		return playerFile;
	}

	public void setPlayerFile(String playerFile) {
		this.playerFile = playerFile;
	}
}
