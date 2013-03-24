package clueBoard;

import java.util.Set;

//Naomi and Brandon
public class ComputerPlayer extends Player{
	private char lastVistedRoom;
	
	public ComputerPlayer(String name, java.awt.Point location, java.awt.Color color) {
		super(name, location, color);
	}
	
	public ComputerPlayer() {
		super();
	}
	
	public BoardCell pickLocation(Set<BoardCell> target){
		return null;
		
	}
	
	public Solution createSuggestion(){
		return null;
	}
	
	public void updateSeen(Card seen){
		
	}

	public char getLastVistedRoom() {
		return lastVistedRoom;
	}

	public void setLastVistedRoom(char lastVistedRoom) {
		this.lastVistedRoom = lastVistedRoom;
	}
}
