package clueBoard;
//Naomi and Brandon
public class Card {
	private String card;
	private enum type {PERSON, WEAPON, ROOM}
	
	public Card() {
		// TODO Auto-generated constructor stub
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}
	
	 public boolean equals(Object o) {
		  
		    if (o instanceof Card) {
		      Card c = (Card) o;
		      if (this.card.equals(c.card)) return true;
		    }
		    return false;
		    
		  }
}
