package ethan.cs1622.pokemonshowdown;

public class TypeFactory {
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
