package game.players;

import static org.junit.Assert.*;

import org.junit.Test;

import races.Human;

public class PlayerTest {

	@Test
	public void testKillPlayerHurt() {
		Player p = new Player("", Human.getRace());
		p.hurt(p.getLife());
		assertFalse(p.isAlive());
	}
	
	@Test
	public void testKillPlayerKill() {
		Player p = new Player("", Human.getRace());
		p.kill();
		assertFalse(p.isAlive());
	}
	
	@Test
	public void testGainXpLevelUp() {
		Player p = new Player("", Human.getRace());
		p.gainXp(p.nextLevelXp());
		assertEquals(p.getLevel(), 2);
	}
	
	@Test
	public void testGainXpLevelUpTwice() {
		Player p = new Player("", Human.getRace());
		p.gainXp(p.nextLevelXp());
		p.gainXp(p.nextLevelXp());
		assertEquals(p.getLevel(), 3);
	}
	
	@Test
	public void testGainXpLevelUpTwiceAtOnce() {
		Player p2 = new Player("", Human.getRace());
		p2.gainXp(p2.nextLevelXp());
		p2.gainXp(p2.nextLevelXp());
		
		Player p = new Player("", Human.getRace());
		p.gainXp(p2.getXp());
		assertEquals(p.getLevel(), 3);
	}
	
	@Test
	public void testGainXpNotEnough() {
		Player p = new Player("", Human.getRace());
		p.gainXp(p.nextLevelXp() - 1);
		assertEquals(p.getLevel(), 1);
	}
	
	@Test
	public void testLevelUpWithoutXp() {
		Player p = new Player("", Human.getRace());
		int rest = p.levelUp(0);
		assertEquals(p.getLevel(), 2);
		assertTrue(rest < 0);
	}

}
