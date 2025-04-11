package ethan.cs1622.pokemonshowdown;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is the class used to test the Swampert pokemon
 */
class SwampertTest {
    Swampert swampert = new Swampert();
    /**
     * This is the method used to test the adding of data to the swampert class
     */
    @Test
    public void testadddata(){
        swampert.setHealth(500.0f);
        assertEquals(500.0f, swampert.getHealth());

        swampert.setType("Swampert.txt");
        assertEquals("Water", swampert.getType());

        swampert.addstat("Swampertstats.txt");
        assertEquals(90, swampert.getstat("Attack"));

        swampert.addmove("Swampertmoves.txt");
        assertEquals(90, swampert.getmove("Surf"));
    }
}