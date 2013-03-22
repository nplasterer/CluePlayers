package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import clueBoard.Board;
import clueBoard.BoardCell;
import clueBoard.Card;
import clueBoard.ClueGame;
import clueBoard.ComputerPlayer;
import clueBoard.HumanPlayer;
import clueBoard.Solution;
//Naomi Plasterer and Brandon Bosso
public class GameActionTests {

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
		game.deal();
	}
	
	//Test for checking an accusation
	//When a play thinks he or she knows the answer
	@Test
	public void testCheckingAccusation() {
		//Set answer
		Solution answer = new Solution("Colonel Mustard", "Knife", "Library");
		Solution guess = answer;
		
		//Check correct accusation
		//correct if it contains the correct person, weapon and room
		guess = answer;
		Assert.assertTrue(game.checkAccusation(guess));
		//Check false accusation
		//not correct if the room is wrong, or if the person is wrong, if the weapon is wrong, or if all three are wrong
		//wrong room
		guess = new Solution("Colonel Mustard", "Knife", "Billiards Room");
		Assert.assertFalse(game.checkAccusation(guess));
		//wrong weapon
		guess = new Solution("Colonel Mustard", "Lead Pipe", "Library");
		Assert.assertFalse(game.checkAccusation(guess));
		//wrong person
		guess = new Solution("Ms. Peacock", "Knife", "Library");
		Assert.assertFalse(game.checkAccusation(guess));
	}
	
	//Test for selecting a target location ensures that the room is always selected if it isn't the last visited
	//the computer plays will select randomly from the possible locations to move to
	@Test
	public void testTargetLocationAlwaysSelected() {
		ComputerPlayer player = new ComputerPlayer();
		//pick location with at least one room as a target
		
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
	for (int i=0; i<100; i++) {
		BoardCell selected = player.pickLocation(board.getTargets());
		if (selected == board.getRoomCellAt(12, 0))
			loc_12_0Tot++;
		else if (selected == board.getRoomCellAt(14, 2))
			loc_14_2Tot++;
		else if (selected == board.getRoomCellAt(15, 1))
			loc_15_1Tot++;
		else
			fail("Invalid target selected");
	}
	// Ensure we have 100 total selections (fail should also ensure)
	assertEquals(100, loc_12_0Tot + loc_14_2Tot + loc_15_1Tot);
	// Ensure each target was selected more than once
	assertTrue(loc_12_0Tot > 10);
	assertTrue(loc_14_2Tot > 10);
	assertTrue(loc_15_1Tot > 10);							
}

	//Test Target Location
	//ensures that if the room is the last visited, a random choice is made
	@Test
	public void testTargetLocationLastVisited(){
		ComputerPlayer player = new ComputerPlayer();
		//pick a location with at least one room as a target that already been visited
	}
	
	//Test for Disproving a suggestion
	//when the player is in a room and makes a suggestion in order to eliminate suspects
	@Test
	public void testDisprovingSuggestion() {
		//Set suggestion
		Solution suggestion = new Solution("Colonel Mustard", "Knife", "Library");
		ComputerPlayer computer1 = new ComputerPlayer();
		ComputerPlayer computer2 = new ComputerPlayer();
		ComputerPlayer computer3 = new ComputerPlayer();
		HumanPlayer human = new HumanPlayer();
		ArrayList<Card> hand = new ArrayList<Card>();
		ArrayList<ComputerPlayer> comps = new ArrayList<ComputerPlayer>();
		
		
		//ensure If a player (human or computer) has a card that's suggested, that card is "shown"
		Card mustardCard = new Card("Colonel Mustard", Card.cardType.PERSON);
		hand.add(mustardCard);
		computer1.setCards(hand);
		Assert.assertEquals(computer1.disproveSuggestion(suggestion), mustardCard);
		
		
		//ensure If the player has multiple cards that match, the card to be returned is selected randomly.
		Card knifeCard = new Card ("Knife", Card.cardType.WEAPON);
		Card libraryCard = new Card("Library", Card.cardType.ROOM);
		hand.add(knifeCard);
		hand.add(libraryCard);
		human.setCards(hand);
		int mustard = 0, knife = 0, library = 0;
		//make sure card is valid and counts how many times each card is returned
		for(int i = 0; i < 100; i++) {
			if(human.disproveSuggestion(suggestion) == mustardCard)
				mustard++;
			else if(human.disproveSuggestion(suggestion) == knifeCard)
				knife++;
			else if(human.disproveSuggestion(suggestion) == libraryCard)
				library++;
			else
				fail("Invalid card returned");
		}
		//makes sure every card is returned more than once
		Assert.assertTrue(mustard > 10);
		Assert.assertTrue(knife > 10);
		Assert.assertTrue(library > 10);
			
		//ensure In the board game, disproving a suggestion starts with a player to the left of the person making the suggestion
		hand.remove(mustardCard);
		hand.remove(knifeCard);
		computer2.setCards(hand);
		hand.remove(libraryCard);
		hand.add(knifeCard);
		computer3.setCards(hand);
		comps.add(computer1);
		comps.add(computer2);
		comps.add(computer3);
		int comp1 = 0, comp2 = 0, comp3 = 0;
		game.setComputer(comps);
		for(int i = 0; i < 100; i++) {
			Card returned = game.handleSuggestion(suggestion);
			if(returned == mustardCard)
				comp1++;
			else if(returned == libraryCard)
				comp2++;
			else if(returned == knifeCard)
				comp3++;
			else
				fail("Invalid card returned");	
		}
		Assert.assertTrue(comp1 > 10);
		Assert.assertTrue(comp2 > 10);
		Assert.assertTrue(comp3 > 10);
		//ensure The player making the suggestion should not be queried
		game.setCurrentPlayer(computer1);
		for(int i = 0; i < 100; i++) {
			Card returned = game.handleSuggestion(suggestion);
			if(returned == mustardCard)
				fail("Suggesting player cannot return a card");	
		}
	}
	
	//Test for making a suggestion
	//ensuring that the computer player's suggestion includes only cards that have not been seen
	//which include cards that the player has been dealt
	@Test
	public void testMakingSuggestion() {
		//make computer player, set location, and update seen
		ComputerPlayer player = new ComputerPlayer();
		java.awt.Point location = new java.awt.Point(9,19);
		player.setLocation(location);
		Card mustardCard = new Card("Colonel Mustard", Card.cardType.PERSON);
		Card knifeCard = new Card ("Knife", Card.cardType.WEAPON);
		Card libraryCard = new Card("Library", Card.cardType.ROOM);
		player.updateSeen(mustardCard);
		player.updateSeen(knifeCard);
		player.updateSeen(libraryCard);
		
		//make suggestion and test
		for(int i = 0; i < 100; i++) {
			Solution guess = player.createSuggestion();
			Assert.assertEquals("Dining Room", guess.getRoom());
			Card guessPerson = new Card(guess.getPerson(), Card.cardType.PERSON);
			Assert.assertFalse(player.seen.contains(guessPerson));
			Card guessWeapon = new Card(guess.getWeapon(), Card.cardType.WEAPON);
			Assert.assertFalse(player.seen.contains(guessWeapon));
		}
	}
}
