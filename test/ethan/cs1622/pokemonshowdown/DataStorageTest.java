package ethan.cs1622.pokemonshowdown;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is the class used to test Datastorage
 */
class DataStorageTest {
    DataStorage data = new DataStorage();
    /**
     * This is the method used to test the adding of move and stat data
     */
    @Test
    public void testadd(){
        data.addstats("Attack", "90");
        data.addmoveset("Surf", "100");
        assertEquals("90", data.getstatvalue("Attack"));
        assertEquals("100", data.getmovevalue("Surf"));
        assertTrue(data.getstats() instanceof HashMap<String, String>);
        assertTrue(data.getmoves() instanceof HashMap<String, String>);
    }
    /**
     * This is used to test the type methods in Data storage
     */
    @Test
    public void testtype(){
        data.setType("Water");
        assertEquals("Water", data.getType());
    }

}