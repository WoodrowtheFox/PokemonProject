package ethan.cs1622.pokemonshowdown;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * This is the test for the damagefactory class
 */
class DamagefactoryTest {
    Damagefactory factory = new Damagefactory(100);
    Swampert player = new Swampert();
    Blaziken opponent = new Blaziken();
    /**
     * This is the actual test for the damage factory
     */
    @Test
    public void testcalc(){
        player.addmove("Swampertmoves.txt");
        player.addstat(("Swampertstats.txt"));
        opponent.addmove(("Blazikenmoves.txt"));
        opponent.addstat(("Blazikenstats.txt"));
        Float value1 = factory.damagefactory(player, opponent, "Attack", 500.0f, "Surf");
        Float value2 = factory.damagefactory(player, opponent, "Attack", 500.0f, "Surf");
        Float value3 = factory.damagefactory(player, opponent, "Attack", 500.0f, "Surf");
        Float value4 = factory.damagefactory(player, opponent, "Attack", 500.0f, "Surf");
        Float value5 = factory.damagefactory(player, opponent, "Attack", 500.0f, "Surf");
        Float avg = (value1 + value2 + value3 + value4 + value5)/5;
        assertEquals(avg, factory.damagefactory(player, opponent, "Attack", 500.0f, "Surf"));

    }
}