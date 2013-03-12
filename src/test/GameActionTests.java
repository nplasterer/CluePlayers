package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import clueBoard.Board;

public class GameActionTests {

	private static Board board;

	@BeforeClass
	public static void setUp() {
		board = new Board("ClueBoard.cfg","legend.cfg");
		board.loadConfigFiles();
		board.calcAdjacencies();
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
