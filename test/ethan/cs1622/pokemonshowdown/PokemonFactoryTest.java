package ethan.cs1622.pokemonshowdown;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is the class for testing the pokemon factory class
 */
class PokemonFactoryTest {
    /**
     * This is the method for testing the actual factory
     */
    @Test
    public void testfactory(){
        PokemonFactory factory = new PokemonFactory();
        assertTrue(factory.factory("Swampert") instanceof Swampert);
        assertTrue(factory.factory("Blaziken") instanceof Blaziken);
        assertTrue(factory.factory("Lucario") instanceof Lucario);
    }
}