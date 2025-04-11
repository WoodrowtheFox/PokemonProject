package ethan.cs1622.pokemonshowdown;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is the class used to test the lucario class
 */
class LucarioTest {
    Lucario lucario = new Lucario();
    /**
     * This is the method used to test the adding of data to the lucario class
     */
    @Test
    public void testadddata(){
        lucario.setHealth(320.0f);
        assertEquals(320.0f, lucario.getHealth());

        lucario.setType("Lucario.txt");
        assertEquals("Steel", lucario.getType());

        lucario.addstat("Lucariostats.txt");
        assertEquals(90, lucario.getstat("Attack"));

        lucario.addmove("Lucariomoves.txt");
        assertEquals(60, lucario.getmove("GyroBall"));
    }
}