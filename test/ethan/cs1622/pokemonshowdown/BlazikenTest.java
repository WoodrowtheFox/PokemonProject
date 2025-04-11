package ethan.cs1622.pokemonshowdown;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is the class used to test the Blaziken Class
 */
class BlazikenTest {
    Blaziken blaziken = new Blaziken();
    /**
     * This is the method used to test the adding of data to the Blaziken class
     */
    @Test
    public void testadddata(){
        blaziken.setHealth(400.0f);
        assertEquals(400.0f, blaziken.getHealth());

        blaziken.setType("Blaziken.txt");
        assertEquals("Fire", blaziken.getType());

        blaziken.addstat("Blazikenstats.txt");
        assertEquals(80, blaziken.getstat("SpecialAttack"));

        blaziken.addmove("Blazikenmoves.txt");
        assertEquals(120, blaziken.getmove("High-JumpKick"));
    }
}