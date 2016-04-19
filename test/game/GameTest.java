package game;

import static org.junit.Assert.*;

import org.junit.Test;

import game.Game;

public class GameTest {
	
	@Test
	public void testGetInstance() {
		Game g1 = Game.getInstance();
		Game g2 = Game.getInstance();
		
		assertSame(g1, g2);
	}
	
	@Test
	public void testForceReset() {
		Game g1 = Game.getInstance();
		Game.forceReset();
		Game g2 = Game.getInstance();
		
		assertNotSame(g1, g2);
	}

}
