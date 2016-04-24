package game.players;

import static org.junit.Assert.*;

import org.junit.Test;

import races.Human;

public class PlayerTest {

	// On peut tuer un Player en lui otant toute sa vie.
	@Test
	public void testKillPlayerHurt() {
		Player p = new Player("", Human.getRace());
		p.hurt(p.getLife());
		assertFalse(p.isAlive());
	}
	
	// On peut tuer un Player directement.
	@Test
	public void testKillPlayerKill() {
		Player p = new Player("", Human.getRace());
		p.kill();
		assertFalse(p.isAlive());
	}
	
	// Un Player passe au niveau suppérieur s'il gagne assez d'expérience.
	@Test
	public void testGainXpLevelUp() {
		Player p = new Player("", Human.getRace());
		p.gainXp(p.nextLevelXp());
		assertEquals(p.getLevel(), 2);
	}
	
	// Un Player peut augmenter de niveaux deux fois de suite.
	@Test
	public void testGainXpLevelUpTwice() {
		Player p = new Player("", Human.getRace());
		p.gainXp(p.nextLevelXp());
		p.gainXp(p.nextLevelXp());
		assertEquals(p.getLevel(), 3);
	}
	
	// Un Player peut augmenter de deux niveaux d'un coup.
	@Test
	public void testGainXpLevelUpTwiceAtOnce() {
		Player p2 = new Player("", Human.getRace());
		p2.gainXp(p2.nextLevelXp());
		p2.gainXp(p2.nextLevelXp());
		
		Player p = new Player("", Human.getRace());
		p.gainXp(p2.getXp());
		assertEquals(p.getLevel(), 3);
	}
	
	// Un Player n'augmente pas de niveau s'il n'a pas atteint l'XP requis.
	@Test
	public void testGainXpNotEnough() {
		Player p = new Player("", Human.getRace());
		p.gainXp(p.nextLevelXp() - 1);
		assertEquals(p.getLevel(), 1);
	}
	
	// Un Player peut augmenter de niveau directement (sans gagner XP).
	@Test
	public void testLevelUpWithoutXp() {
		Player p = new Player("", Human.getRace());
		int rest = p.levelUp(0);
		assertEquals(p.getLevel(), 2);
		assertTrue(rest < 0);
	}

}
