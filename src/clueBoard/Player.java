package clueBoard;
//Naomi and Brandon
import java.util.ArrayList;

public class Player {
	private String name;
	public static ArrayList<Card> seen = new ArrayList<Card>();
	private ArrayList<Card> cards = new ArrayList<Card>();
	private java.awt.Point location;
	private java.awt.Color color;
	private char lastVistedRoom;
	
	public Player() {
		name = null;
		location = null;
		color = null;
	}

	public Player(String name, java.awt.Point location, java.awt.Color color) {
		this.name = name;
		this.location = location;
		this.color = color;
	}
	

	public Card disproveSuggestion(Solution suggestion){
		
		return cards.get(0);	
	}
	
	public void acceptCard(Card card) {
		cards.add(card);
	}

	
	//Setters and getters for tests
	public String getName() {
		return name;
	}

	public ArrayList<Card> getCards() {
		return cards;
	}
	
	public void setLocation(java.awt.Point location) {
		this.location = location;
	}

	public java.awt.Point getLocation() {
		return location;
	}
	
	public java.awt.Color getColor() {
		return color;
	}
	
	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}


	public char getLastVistedRoom() {
		return lastVistedRoom;
	}


	public void setLastVistedRoom(char lastVistedRoom) {
		this.lastVistedRoom = lastVistedRoom;
	}

	
}
