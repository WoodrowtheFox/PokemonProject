package ethan.cs1622.pokemonshowdown;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * This class is used to test the water type
 */
class WaterTest {
    Type type = new Water();
    /**
     * This is used to test the getting of types
     */
    @Test
    public void testget(){
        assertTrue(type.gettype() instanceof Water);
    }
}