package ethan.cs1622.pokemonshowdown;
import java.util.HashMap;

public class DataStorage {
    private HashMap<String, String> stats;
    private HashMap<String, String> moveset;
    private String type;

    public DataStorage(){
        this.stats = new HashMap<>();
        this.moveset = new HashMap<>();
        this.type = "Normal";
    }

    public void addstats(String stat, String value){
        this.stats.put(stat, value);
    }
    public void addmoveset(String move, String power){
        this.moveset.put(move, power);
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }
    public HashMap<String, String> getstats(){
        return this.stats;
    }
    public HashMap<String, String> getmoves(){
        return this.moveset;
    }
}
