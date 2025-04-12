package ethan.cs1622.pokemonshowdown;
/**
 * This is the factory to create different types
 */
public class TypeFactory {
    /**
     * The method to actually get differnt types
     * @param type - the type to be returned
     * @return - returns the new type
     */
    public Type typefactory(String type){
        if(type.equals("Water")){
            return new Water();
        }
        else if(type.equals("Fire")){
            return new Fire();
        }
        else if(type.equals("Steel")){
            return new Steel();
        }
        else{return null;}
    }
}
