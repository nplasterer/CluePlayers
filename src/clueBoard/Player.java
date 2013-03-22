package clueBoard;
//Naomi and Brandon
import java.util.ArrayList;
import java.util.HashSet;

public class Player {
	private String name;
	private ArrayList<Card> cards = new ArrayList<Card>();
	private java.awt.Point location;
	private java.awt.Color color;

	public Player() {
		// TODO Auto-generated constructor stub
	}
	
	public Card disproveSuggestion(String person, String room, String weapon){
		
		return cards.get(0);	
	}

	public String getName() {
		return name;
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public java.awt.Point getLocation() {
		return location;
	}
	
	public java.awt.Color getColor() {
		return color;
	}

}
