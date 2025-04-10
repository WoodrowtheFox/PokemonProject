package ethan.cs1622.pokemonshowdown;
import java.util.HashMap;

public class DataStorage {
    private HashMap<String, Integer> stats;
    private HashMap<String, Integer> moveset;

    public DataStorage(){
        this.stats = new HashMap<>();
        this.moveset = new HashMap<>();
    }

    public void addstats(String stat, Integer value){
        this.stats.put(stat, value);
    }
    public void addmoveset(String move, Integer power){
        this.moveset.put(move, power);
    }
    public HashMap<String, Integer> getstats(){
        return this.stats;
    }
    public HashMap<String, Integer> getmoves(){
        return this.moveset;
    }
}
