package game;

import static org.junit.Assert.*;

import org.junit.Test;

import game.Game;

public class GameTest {
	
	// L'appel de la méthode statique Game::getInstance() retourne toujours la même instance.
	@Test
	public void testGetInstance() {
		Game g1 = Game.getInstance();
		Game g2 = Game.getInstance();
		
		assertSame(g1, g2);
	}
	
	// Il est possible d'utiliser la méthode statique Game::forceReset() pour forcer la création d'une nouvelle instance lors du prochain appel à Game::getInstance().
	@Test
	public void testForceReset() {
		Game g1 = Game.getInstance();
		Game.forceReset();
		Game g2 = Game.getInstance();
		
		assertNotSame(g1, g2);
	}

}
