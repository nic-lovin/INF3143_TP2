package game;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class RoundTest {

	@Test
	public void testGetRoundNull() {
		Round r = Round.getRound(null);
		assertEquals(r.getRoundNumber(), 1);
	}
	
	@Test
	public void testGetRoundOne() {
		Round r = Round.getRound(null);
		Round r2 = Round.getRound(r);
		
		assertNotSame(r, r2);
		assertEquals(r2.getRoundNumber(), 2);
	}
	
	@Test
	public void testGetRound5000() {
		Round r = Round.getRound(null);
		int nbRounds = 5000;
		for (int i = 1; i < nbRounds; i++) {
			r = Round.getRound(r);
		}
		assertEquals(r.getRoundNumber(), nbRounds);
	}

}
