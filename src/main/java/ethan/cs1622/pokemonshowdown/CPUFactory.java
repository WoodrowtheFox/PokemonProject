package ethan.cs1622.pokemonshowdown;

public class CPUFactory extends PokemonFactory{
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

