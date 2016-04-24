package races;

import static org.junit.Assert.*;

import org.junit.Test;

public class RaceFactoryTest {
	
	// Il est possible d'obtenir des instances de Elf en appelant la méthode statique RaceFactory.getRace(raceName) avec les bons arguments.
	@Test
	public void testGetRaceElf() {
		Race elf = RaceFactory.getRace("elf");
		assertNotNull(elf);
		assertTrue(elf instanceof Elf);
	}
	
	// Il est possible d'obtenir des instances de Troll en appelant la méthode statique RaceFactory.getRace(raceName) avec les bons arguments.
	@Test
	public void testGetRaceTroll() {
		Race troll = RaceFactory.getRace("troll");
		assertNotNull(troll);
		assertTrue(troll instanceof Troll);
	}
	
	// Il est possible d'obtenir des instances de Human en appelant la méthode statique RaceFactory.getRace(raceName) avec les bons arguments.
	@Test
	public void testGetRaceHuman() {
		Race human = RaceFactory.getRace("human");
		assertNotNull(human);
		assertTrue(human instanceof Human);
	}
	// Appeler la méthode RaceFactory.getRace avec autre chose que les chaînes de caractères elf, troll ou human retourne une IllegalArgumentException.
	@Test(expected = IllegalArgumentException.class)
	public void testGetRaceInvalid() {
		RaceFactory.getRace("invalid");
	}

}
