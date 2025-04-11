package ethan.cs1622.pokemonshowdown;

/**
 * This class is used as a factory to return a new pokemon if needed
 */
public class PokemonFactory {
    /**
     * The factory the creates the pokemon
     * @param name - name of the pokemon
     * @return - the new pokemon
     */
    public Pokemon factory(String name){
        if(name.equals("Swampert")){
            return new Swampert();
        }
        else if (name.equals("Lucario")) {
            return new Lucario();
        }
        else if (name.equals("Blaziken")){
            return new Blaziken();
        }
        else {return new Swampert();}
    }
}
