package clueBoard;
//Naomi and Brandon
import java.util.ArrayList;

public class ClueGame {
	private ArrayList<ComputerPlayer> computer;
	private Solution answer;
	private ArrayList<Card> cards;
	private HumanPlayer human;
	private boolean turn;
	private Player currentPlayer;

	public ClueGame() {
		computer = new ArrayList<ComputerPlayer>();
		cards = new ArrayList<Card>();
		human = new HumanPlayer();
	}
	
	public void deal(){
		
	}
	
	public void loadConfigFiles(){
		
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
	public void loadPlayerConfigFile(String file) throws BadConfigFormatException {
		
	}
	
	public void loadCardConfigFile(String file) throws BadConfigFormatException {
	
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
}
