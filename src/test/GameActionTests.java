package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import clueBoard.Board;
import clueBoard.BoardCell;
import clueBoard.ComputerPlayer;
//Naomi Plasterer and Brandon Bosso
public class GameActionTests {

	private static Board board;

	@BeforeClass
	public static void setUp() {
		board = new Board("ClueBoard.cfg","legend.cfg");
		board.loadConfigFiles();
		board.calcAdjacencies();
	}
	
	//Test for checking an accusation
	//When a play thinks he or she knows the answer
	@Test
	public void testCheckingAccusation() {
		fail("Not yet implemented");
		//Set answer
		//Check accusation
		//correct if it contains the correct person, weapon and room
		//not correct if the room is wrong, or if the person is wrong, if the weapon is wrong, or if all three are wrong
	}
	
	//Test for selecting a target location
	//the computer plays will select randomly from the possible locations to move to
	@Test
	public void testTargetLocation() {
		fail("Not yet implemented");
	}
	
	//Test targets random selection
	@Test
	public void testTargetRandomSelection() {
	ComputerPlayer player = new ComputerPlayer();
	// Pick a location with no rooms in target, just three targets
	board.calcTargets(14, 0, 2);
	int loc_12_0Tot = 0;
	int loc_14_2Tot = 0;
	int loc_15_1Tot = 0;
	// Run the test 100 times
	/*for (int i=0; i<100; i++) {
		BoardCell selected = player.pickLocation(board.getTargets());
		if (selected == board.getCellAt(12, 0))
			loc_12_0Tot++;
		else if (selected == board.getCellAt(14, 2))
			loc_14_2Tot++;
		else if (selected == board.getCellAt(15, 1))
			loc_15_1Tot++;
		else
			fail("Invalid target selected");
	}*/
	// Ensure we have 100 total selections (fail should also ensure)
	assertEquals(100, loc_12_0Tot + loc_14_2Tot + loc_15_1Tot);
	// Ensure each target was selected more than once
	assertTrue(loc_12_0Tot > 10);
	assertTrue(loc_14_2Tot > 10);
	assertTrue(loc_15_1Tot > 10);							
}

	//Test for Disproving a suggestion
	//when the player is in a room and makes a suggestion in order to eliminate suspects
	@Test
	public void testDisprovingSuggestion() {
		//ensure a player (human or computer) has a card that's suggested, that card is "shown"
		//ensure the player has multiple cards that match, the card to be returned is selected randomly
		//ensure Once a player has shown a card, no other players are queried
		//ensure disproving a suggestion starts with a player to the left of the person making the suggestion
		//ensure the player making the suggestion should not be queried
		//ensure if none of the other players has any relevant cards, the error value is returned
	}
	
	//Test for making a suggestion
	//ensuring that the computer player's suggestion includes only cards that have not been seen
	//which include cards that the player has been dealt
	@Test
	public void testMakingSuggestion() {
		//
	}
}
