package clueBoard;

import java.util.Set;

//Naomi and Brandon
public class ComputerPlayer extends Player{
	private char lastVistedRoom;
	
	public ComputerPlayer() {
		// TODO Auto-generated constructor stub
	}
	
	public void pickLocation(Set<BoardCell> target){
		
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
