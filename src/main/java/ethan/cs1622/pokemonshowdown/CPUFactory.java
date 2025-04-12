package ethan.cs1622.pokemonshowdown;

import java.util.Random;
/**
 * This is the class for getting a CPUS data out of a factory
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
    /**
     * This is used for generating a cpu move
     * @param pokemon - the cpus pokemon
     * @return - returns the move
     */
    public String movefactory(Pokemon pokemon){
        int a = pokemon.getCpumoves();
        Random rand = new Random();
        if(a == 0){return pokemon.getmovename(0);}
        else{return pokemon.getmovename(rand.nextInt(0, a));}
    }
    /**
     * This is used for generating a cpu stat
     * @param pokemon - the cpus pokemon
     * @return - returns the stat
     */
    public String statfactory(Pokemon pokemon){
        int a = pokemon.getCpustats();
        Random rand = new Random();
        if(a == 0){return pokemon.getstatname(0);}
        else{return pokemon.getstatname(rand.nextInt(0, a));}
    }
    }

