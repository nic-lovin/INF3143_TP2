package races;

import static org.junit.Assert.*;

import org.junit.Test;

public class RaceFactoryTest {
	
	@Test
	public void testGetRaceElf() {
		Race elf = RaceFactory.getRace("elf");
		assertNotNull(elf);
		assertTrue(elf instanceof Elf);
	}
	
	@Test
	public void testGetRaceTroll() {
		Race troll = RaceFactory.getRace("troll");
		assertNotNull(troll);
		assertTrue(troll instanceof Troll);
	}
	
	@Test
	public void testGetRaceHuman() {
		Race human = RaceFactory.getRace("human");
		assertNotNull(human);
		assertTrue(human instanceof Human);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetRaceInvalid() {
		RaceFactory.getRace("invalid");
	}

}
