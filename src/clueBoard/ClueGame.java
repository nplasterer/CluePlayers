package clueBoard;
//Naomi and Brandon
import java.util.ArrayList;

public class ClueGame {
	private ArrayList<ComputerPlayer> computer;
	private ArrayList<Card> answer;
	private ArrayList<Card> cards;
	private HumanPlayer human;
	private boolean turn;
	
	public ClueGame() {
		computer = new ArrayList<ComputerPlayer>();
		cards = new ArrayList<Card>();
		human = new HumanPlayer();
		answer = new ArrayList<Card>();
	}
	
	public void deal(){
		
	}
	
	public void loadConfigFiles(){
		
	}
	
	public void selectAnswer(){
		
	}
	
	public void handleSuggestion(String person, String room, String weapon, Player accusingPerson){
		
	}
	
	public boolean checkAccusation(Solution solution){
		return turn;
	}

	
	//load separate config files to test for exceptions
	public void loadPlayerConfigFile(String file) throws BadConfigFormatException {
		
	}
	
	public void loadCardConfigFile(String file) throws BadConfigFormatException {
	
	}

	public ArrayList<Card> getAnswer() {
		return answer;
	}

	public void setAnswer(ArrayList<Card> answer) {
		this.answer = answer;
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}

	public ArrayList<ComputerPlayer> getComputer() {
		return computer;
	}

	public HumanPlayer getHuman() {
		return human;
	}
}
