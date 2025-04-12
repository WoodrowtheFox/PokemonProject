package ethan.cs1622.pokemonshowdown;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * This is used to test the CPUfactory class
 */
class CPUFactoryTest {
    CPUFactory factory = new CPUFactory();
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
}