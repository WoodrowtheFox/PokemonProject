package ethan.cs1622.pokemonshowdown;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is the class used to test the Blaziken pokemon
 */
class BlazikenTest {
    Damagefactory factory = new Damagefactory(100);
    Swampert opponent = new Swampert();
    Blaziken blaziken = new Blaziken();
    /**
     * This is the method used to test the adding of data to the Blaziken class
     */
    @Test
    public void testadddata(){
        blaziken.setHealth(500.0f);
        assertEquals(500.0f, blaziken.getHealth());

        blaziken.setType("Swampert.txt");
        assertTrue(blaziken.getType() instanceof Water);

        blaziken.addstat("Swampertstats.txt");
        assertEquals(90, blaziken.getstat("Attack"));

        blaziken.addmove("Swampertmoves.txt");
        assertEquals(100, blaziken.getmove("Surf"));


    }
    /**
     * This is the actual test for the calc of damage
     */
    @Test
    public void testcalc(){
        blaziken.addmove("Swampertmoves.txt");
        blaziken.addstat(("Swampertstats.txt"));
        opponent.addmove(("Blazikenmoves.txt"));
        opponent.addstat(("Blazikenstats.txt"));
        Float value1 = factory.damagefactory(blaziken, opponent, "Attack", 500.0f, "Surf");
        Float value2 = factory.damagefactory(blaziken, opponent, "Attack", 500.0f, "Surf");
        Float value3 = factory.damagefactory(blaziken, opponent, "Attack", 500.0f, "Surf");
        Float value4 = factory.damagefactory(blaziken, opponent, "Attack", 500.0f, "Surf");
        Float value5 = factory.damagefactory(blaziken, opponent, "Attack", 500.0f, "Surf");
        Float avg = (value1 + value2 + value3 + value4 + value5)/5;
        assertEquals(avg, factory.damagefactory(blaziken, opponent, "Attack", 500.0f, "Surf"));

    }
    /**
     * This is used to test the strengths and weaknesses
     */
    @Test
    public void testeffects(){
        blaziken.setType("Swampert.txt");
        blaziken.setStrength();
        blaziken.setWeakness();
        assertTrue(blaziken.getweakness("Grass"));
        assertTrue(blaziken.getstrength("Water"));
    }
    /**
     * This is used to test the data of cpus
     */
    @Test
    public void testcpu(){
        blaziken.setType("Swampert.txt");
        blaziken.addmove("Swampertmoves.txt");
        blaziken.addstat("Swampertstats.txt");
        assertEquals("Surf", blaziken.getmovename(0));
        assertEquals("Attack", blaziken.getstatname(0));
        assertEquals(0, blaziken.getCpumoves());
        assertEquals(0, blaziken.getCpustats());
    }
}

