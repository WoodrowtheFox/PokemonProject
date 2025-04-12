package ethan.cs1622.pokemonshowdown;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * This is the class used to test the Swampert pokemon
 */
class SwampertTest {
    Damagefactory factory = new Damagefactory(100);
    Blaziken opponent = new Blaziken();
    Swampert swampert = new Swampert();
    /**
     * This is the method used to test the adding of data to the swampert class
     */
    @Test
    public void testadddata(){
        swampert.setHealth(500.0f);
        assertEquals(500.0f, swampert.getHealth());

        swampert.setType("Swampert.txt");
        assertTrue(swampert.getType() instanceof Water);

        swampert.addstat("Swampertstats.txt");
        assertEquals(90, swampert.getstat("Attack"));

        swampert.addmove("Swampertmoves.txt");
        assertEquals(100, swampert.getmove("Surf"));
    }
    /**
     * This is the actual test for the calc of damage
     */
    @Test
    public void testcalc(){
        swampert.addmove("Swampertmoves.txt");
        swampert.addstat(("Swampertstats.txt"));
        opponent.addmove(("Blazikenmoves.txt"));
        opponent.addstat(("Blazikenstats.txt"));
        Float value1 = factory.damagefactory(swampert, opponent, "Attack", 500.0f, "Surf");
        Float value2 = factory.damagefactory(swampert, opponent, "Attack", 500.0f, "Surf");
        Float value3 = factory.damagefactory(swampert, opponent, "Attack", 500.0f, "Surf");
        Float value4 = factory.damagefactory(swampert, opponent, "Attack", 500.0f, "Surf");
        Float value5 = factory.damagefactory(swampert, opponent, "Attack", 500.0f, "Surf");
        Float avg = (value1 + value2 + value3 + value4 + value5)/5;
        assertEquals(avg, factory.damagefactory(swampert, opponent, "Attack", 500.0f, "Surf"));

    }
    /**
     * This is used to test the strengths and weaknesses
     */
    @Test
    public void testeffects(){
        swampert.setType("Swampert.txt");
        swampert.setStrength();
        swampert.setWeakness();
        assertTrue(swampert.getweakness("Grass"));
        assertTrue(swampert.getstrength("Water"));
    }
    /**
     * This is used to test the data of cpus
     */
    @Test
    public void testcpu(){
        swampert.setType("Swampert.txt");
        swampert.addmove("Swampertmoves.txt");
        swampert.addstat("Swampertstats.txt");
        assertEquals("Surf", swampert.getmovename(0));
        assertEquals("Attack", swampert.getstatname(0));
        assertEquals(0, swampert.getCpumoves());
        assertEquals(0, swampert.getCpustats());
        }
    }

