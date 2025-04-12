package ethan.cs1622.pokemonshowdown;
/**
 * This is the class for the fire type
 */
public class Fire extends Type{
    /**
     * This is used to get the type of the type class
     *
     * @return - returns the type
     */
    @Override
    public Type gettype() {
        return new Fire();
    }
}
