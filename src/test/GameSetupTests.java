package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import clueBoard.BadConfigFormatException;
import clueBoard.Board;
import clueBoard.ClueGame;
import clueBoard.ComputerPlayer;
import clueBoard.HumanPlayer;

public class GameSetupTests {

	private static Board board;
	private static ClueGame game;
	

	@BeforeClass
	public static void setUp() {
		//set up test board
		board = new Board("ClueBoard.cfg","legend.cfg");
		board.loadConfigFiles();
		board.calcAdjacencies();
		//set up test game
		game = new ClueGame();
		game.loadConfigFiles();
		game.selectAnswer();
	}
	
	@Test
	public void testLoadPeople() {
		try {
			game.loadPlayerConfigFile("BadPlayer.txt");
		} catch (BadConfigFormatException e) {
			System.out.println(e);
		}
		HumanPlayer human = game.getHuman();
		boolean equal = false;
		java.awt.Point testLocation;
		java.awt.Color testColor;
		ArrayList<ComputerPlayer> computers = game.getComputer();
		ComputerPlayer testComp;
		//test human player
		//set to human starting location and color
		testLocation = new java.awt.Point(0,0);
		testColor = new java.awt.Color(0,0,0);
		Assert.assertEquals("Brandon", human.getName());
		if(testLocation.equals(human.getLocation()))
			equal = true;
		Assert.assertEquals(equal, true);
		equal = false;
		if(testColor.equals(human.getColor()))
			equal = true;
		Assert.assertEquals(equal, true);
		equal = false;
		
	}

}
