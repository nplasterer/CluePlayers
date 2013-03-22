package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import clueBoard.Board;
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
	public void test() {
		fail("Not yet implemented");
	}
	
	//Test for selecting a target location
	//the computer plays will select randomly from the possible locations to move to
	@Test
	public void test2() {
		fail("Not yet implemented");
	}

	//Test for Disproving a suggestion
	//when the player is in a room and makes a suggestion in order to eliminate suspects
	@Test
	public void test3() {
		fail("Not yet implemented");
	}
	
	//Test for making a suggestion
	//ensuring that the computer player's suggestion includes only cards that have not been seen
	//which include cards that the player has been dealt
	@Test
	public void test4() {
		fail("Not yet implemented");
	}
}
