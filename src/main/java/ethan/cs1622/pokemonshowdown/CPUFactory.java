package ethan.cs1622.pokemonshowdown;
/**
 * This is the class for getting a CPUS pokemon out of a factory
 */
public class CPUFactory extends PokemonFactory{
    /**
     * This is the factory the creates the new pokemon for the cpu
     * @param random - A randomly generated value
     * @return - returns the new pokemon
     */
    public Pokemon factory (int random) {
        if(random == 1){
            return new Swampert();
        }
        else if (random == 2) {
            return new Lucario();
        }
        else if (random == 3){
            return new Blaziken();
        }
        else {return null;}
    }
    }

