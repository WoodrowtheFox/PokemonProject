package ethan.cs1622.pokemonshowdown;

public class PokemonFactory {
    public Pokemon pokemonfactory(String name, String type){
        switch(name){
            case("Swampert"):
                Swampert swampert = new Swampert();
                swampert.setname(name);
                swampert.settype(type);
                return swampert;
            case("Lucario"):
                Lucario lucario = new Lucario();
                lucario.setname(name);
                lucario.settype(type);
                return lucario;
            case("Blaziken"):
                Blaziken blaziken = new Blaziken();
                blaziken.setname(name);
                blaziken.settype(type);
                return blaziken;
    }
    return new Swampert();
}
}
