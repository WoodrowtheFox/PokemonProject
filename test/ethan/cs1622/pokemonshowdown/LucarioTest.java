package ethan.cs1622.pokemonshowdown;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * This is the class used to test the Lucario pokemon
 */
class LucarioTest {
    Damagefactory factory = new Damagefactory(100);
    Blaziken opponent = new Blaziken();
    Lucario lucario = new Lucario();
    /**
     * This is the method used to test the adding of data to the lucario class
     */
    @Test
    public void testadddata(){
        lucario.setHealth(500.0f);
        assertEquals(500.0f, lucario.getHealth());

        lucario.setType("Swampert.txt");
        assertTrue(lucario.getType() instanceof Water);

        lucario.addstat("Swampertstats.txt");
        assertEquals(90, lucario.getstat("Attack"));

        lucario.addmove("Swampertmoves.txt");
        assertEquals(100, lucario.getmove("Surf"));
    }
    /**
     * This is the actual test for the calc of damage
     */
    @Test
    public void testcalc(){
        lucario.addmove("Swampertmoves.txt");
        lucario.addstat(("Swampertstats.txt"));
        opponent.addmove(("Blazikenmoves.txt"));
        opponent.addstat(("Blazikenstats.txt"));
        Float value1 = factory.damagefactory(lucario, opponent, "Attack", 500.0f, "Surf");
        Float value2 = factory.damagefactory(lucario, opponent, "Attack", 500.0f, "Surf");
        Float value3 = factory.damagefactory(lucario, opponent, "Attack", 500.0f, "Surf");
        Float value4 = factory.damagefactory(lucario, opponent, "Attack", 500.0f, "Surf");
        Float value5 = factory.damagefactory(lucario, opponent, "Attack", 500.0f, "Surf");
        Float avg = (value1 + value2 + value3 + value4 + value5)/5;
        assertEquals(avg, factory.damagefactory(lucario, opponent, "Attack", 500.0f, "Surf"));

    }
    /**
     * This is used to test the strengths and weaknesses
     */
    @Test
    public void testeffects(){
        lucario.setType("Swampert.txt");
        lucario.setStrength();
        lucario.setWeakness();
        assertTrue(lucario.getweakness("Grass"));
        assertTrue(lucario.getstrength("Water"));
    }
    /**
     * This is used to test the data of cpus
     */
    @Test
    public void testcpu(){
        lucario.setType("Swampert.txt");
        lucario.addmove("Swampertmoves.txt");
        lucario.addstat("Swampertstats.txt");
        assertEquals("Surf", lucario.getmovename(0));
        assertEquals("Attack", lucario.getstatname(0));
        assertEquals(1, lucario.getCpumoves());
        assertEquals(1, lucario.getCpustats());
        assertEquals("Lucario", lucario.getCpuname());
    }
}

