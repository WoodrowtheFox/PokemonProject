package ethan.cs1622.pokemonshowdown;
import java.util.HashMap;

/**
 * This is the class used for storing data during the setting of pokemon data
 */
public class DataStorage {
    private HashMap<String, String> stats;
    private HashMap<String, String> moveset;
    private HashMap<String, String> movetype;
    private String type;

    public DataStorage(){
        this.stats = new HashMap<>();
        this.moveset = new HashMap<>();
        this.movetype = new HashMap<>();
        this.type = "Normal";
    }
    /**
     * This stores the stat name and value into a hashmap
     * @param stat - The name of the stat
     * @param value - the value of the stat
     */
    public void addstats(String stat, String value){
        this.stats.put(stat, value);
    }
    /**
     * This stores the move name and value into a hashmap
     * @param move - The name of the move
     * @param power - the basepower of the move
     */
    public void addmoveset(String move, String power){
        this.moveset.put(move, power);
    }
    /**
     * This is used to store the movetype data
     * @param move - the name of the move
     * @param movetype - the type of the move
     */
    public  void addmovetype(String move, String movetype){
        this.movetype.put(move, movetype);
    }
    /**
     * This stores the pokemons type in a string
     * @param type - the pokemons type
     */
    public void setType(String type){
        this.type = type;
    }
    /**
     * This is used to get the pokemons type
     * @return - returns the pokemons type
     */
    public String getType(){
        return type;
    }
    /**
     * This is used to get the value of a stat
     * @param stat - the stat whose value you are looking for
     * @return - returns the value of the stat
     */
    public String getstatvalue(String stat){
        return this.stats.get(stat);
    }
    /**
     * This is used to get the basepower of a move
     * @param move - the move whose power you are looking for
     * @return - returns the basepower of the move
     */
    public String getmovevalue(String move){
        return this.moveset.get(move);
    }
    /**
     * This is used to get the type of a move
     * @param move - the move whose type you are looking for
     * @return - returns the type of the move
     */
    public String getmovetype(String move){
        return this.movetype.get(move);
    }
    /**
     * This is used to get the stats hashmap to been iterated through
     * @return - the hashmap
     */
    public HashMap<String, String> getstats(){
        return this.stats;
    }
    /**
     * This is used to get the move hashmap to been iterated through
     * @return - the hashmap
     */
    public HashMap<String, String> getmoves(){
        return this.moveset;
    }
    /**
     * This is used to get the movetype hashmap to been iterated through
     * @return - the hashmap
     */
    public HashMap<String, String> getmovetyppes(){
        return this.movetype;
    }
}
