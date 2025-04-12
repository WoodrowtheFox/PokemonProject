package ethan.cs1622.pokemonshowdown;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * This is used to test the CPUfactory class
 */
class CPUFactoryTest {
    CPUFactory factory = new CPUFactory();
    Swampert swampert = new Swampert();
    /**
     * This is used to test the actual factory in the class
     */
    @Test
    public void testfactory(){
        assertTrue(factory.factory(1) instanceof Swampert);
        assertTrue(factory.factory(2) instanceof Lucario);
        assertTrue(factory.factory(3) instanceof Blaziken);
        assertTrue(factory.factory(4) == null);
    }
    /**
     * This is used to test the stat and move factory
     */
    @Test
    public void teststat_movefactory(){
        swampert.addmove("Swampertmoves.txt");
        swampert.addstat("Swampertstats.txt");
        assertEquals("Surf",factory.movefactory(swampert));
        assertEquals("Attack",factory.statfactory(swampert));
    }
}