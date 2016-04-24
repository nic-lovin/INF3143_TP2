package game;

import static org.junit.Assert.*;
import org.junit.Test;

public class RoundTest {

	// L'appel de la méthode statique Round.getRound(round) avec round == null comme argument retourne un nouveau tour initilisé avec roundNumber == 1.
	@Test
	public void testGetRoundNull() {
		Round r = Round.getRound(null);
		assertEquals(r.getRoundNumber(), 1);
	}
	
	// L'appel de la méthode statique Round.getRound(round) avec round.roundNumber == 1 comme argument retourne un nouveau tour initilisé avec roundNumber == 2.
	@Test
	public void testGetRoundOne() {
		Round r = Round.getRound(null);
		Round r2 = Round.getRound(r);
		
		assertNotSame(r, r2);
		assertEquals(r2.getRoundNumber(), 2);
	}
	
	// Test de 5000 rounds
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
