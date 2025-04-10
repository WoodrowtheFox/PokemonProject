package ethan.cs1622.pokemonshowdown;

public class PokemonFactory {
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
