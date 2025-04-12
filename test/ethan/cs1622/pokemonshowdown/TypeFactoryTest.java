package ethan.cs1622.pokemonshowdown;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * This is used to test the type factory
 */
class TypeFactoryTest {
    TypeFactory factory = new TypeFactory();
    /**
     * This is used to test the actual factory
     */
    @Test
    public void testfactory(){
        assertTrue(factory.typefactory("Water") instanceof Water);
        assertTrue(factory.typefactory("Fire") instanceof Fire);
        assertTrue(factory.typefactory("Steel") instanceof Steel);
        assertTrue(factory.typefactory("Steels") == null);

    }
}