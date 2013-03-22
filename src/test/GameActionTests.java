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
}