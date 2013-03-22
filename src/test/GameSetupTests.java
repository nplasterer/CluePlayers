package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import clueBoard.BadConfigFormatException;
import clueBoard.Board;
import clueBoard.Card;
import clueBoard.ClueGame;
import clueBoard.ComputerPlayer;
import clueBoard.HumanPlayer;
//Naomi Plasterer and Brandon Bosso
public class GameSetupTests {

	private static Board board;
	private static ClueGame game;
	private static int TOTAL_CARDS = 21;
	private static int ROOM_CARDS = 9;
	private static int PLAYER_CARDS = 6;
	private static int WEAPON_CARDS = 6;
	

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
	
	//Test for loading the people
	@Test
	public void testLoadPeople() {
		//set up test variables
		HumanPlayer human = game.getHuman();
		boolean equal = false;
		java.awt.Point testLocation;
		java.awt.Color testColor;
		ArrayList<ComputerPlayer> computers = game.getComputer();
		ComputerPlayer testComp;
		
		//test human player
		//set to human name, starting location and color
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
		
		//test second computer
		//set to computer 2 name, starting location and color
		testComp = computers.get(1);
		testLocation = new java.awt.Point(0,0);
		testColor = new java.awt.Color(0,0,0);
		Assert.assertEquals("Brandon", testComp.getName());
		if(testLocation.equals(testComp.getLocation()))
			equal = true;
		Assert.assertEquals(equal, true);
		equal = false;
		if(testColor.equals(testComp.getColor()))
			equal = true;
		Assert.assertEquals(equal, true);
		equal = false;
		
		//test fourth computer
		//set to computer 4 name, starting location and color
		testComp = computers.get(3);
		testLocation = new java.awt.Point(0,0);
		testColor = new java.awt.Color(0,0,0);
		Assert.assertEquals("Brandon", testComp.getName());
		if(testLocation.equals(testComp.getLocation()))
			equal = true;
		Assert.assertEquals(equal, true);
		equal = false;
		if(testColor.equals(testComp.getColor()))
			equal = true;
		Assert.assertEquals(equal, true);
		equal = false;
	}

	//Test for loading the cards
	@Test
	public void testLoadCards() {
		int rooms = 0;
		int players = 0;
		int weapons = 0;
		//Make cards for testing
		Card mustardCard = new Card("Colonel Mustard", Card.cardType.PERSON);
		Card knifeCard = new Card ("Knife", Card.cardType.WEAPON);
		Card libraryCard = new Card("Library", Card.cardType.ROOM);

		for(Card c : game.getCards()) {
			if (c.getType() == Card.cardType.PERSON)
				players++;
			else if (c.getType() == Card.cardType.WEAPON)
				weapons++;
			else if (c.getType() == Card.cardType.ROOM)
				rooms++;
		}
		//test deck size and ensures correct number of each card type
		Assert.assertEquals(rooms,ROOM_CARDS);
		Assert.assertEquals(players,PLAYER_CARDS);
		Assert.assertEquals(weapons, WEAPON_CARDS);
		Assert.assertEquals(game.getCards().size(), TOTAL_CARDS);
		
		//test that deck contains one specific card of each type
		Assert.assertTrue(game.getCards().contains(mustardCard));
		Assert.assertTrue(game.getCards().contains(knifeCard));
		Assert.assertTrue(game.getCards().contains(libraryCard));
	}
	
	
	//Test for dealing the cards
	@Test
	public void testDealingCards() {
		//ensure all cards are dealt
		//ensure all players have roughly the same number of cards
		//ensure once card is not given to two different players
	}
}
