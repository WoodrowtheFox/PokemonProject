package ethan.cs1622.pokemonshowdown;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * This is the abstract class for all pokemon
 */
public abstract class Pokemon{
    protected Type type;
    protected HashMap<String, Integer> stats;
    protected HashMap<String, Integer> moves;
    protected HashMap<String, String> movestypes;
    protected ArrayList<String> key;
    protected ArrayList<Integer> value;
    protected ArrayList<String> cpumoves;
    protected ArrayList<String> cpustats;
    protected float health;
    protected boolean tera;
    protected ArrayList<String> weakness;
    protected ArrayList<String> strength;
    protected String typecheck;

    public Pokemon(){
        this.typecheck = "Normal";
        this.stats = new HashMap<>();
        this.moves = new HashMap<>();
        this.movestypes = new HashMap<>();
        this.health = 500.0f;
        this.tera = false;
        this.cpumoves = new ArrayList<>();
        this.cpustats = new ArrayList<>();
        this.key = new ArrayList<>();
        this.value = new ArrayList<>();
        this.weakness = new ArrayList<>();
        this.strength = new ArrayList<>();
    }
    /**
     * This is used for setting the pokemons type based on previously set data
     * @param filename - The file with the pokemon type
     */
    public abstract void setType(String filename);
    /**
     * This is used for getting a pokemons type
     * @return - returns the pokemons type
     */
    public abstract Type getType();
    /**
     * This is used to set the current health of a pokemon
     * @param health - their health
     */
    public abstract void setHealth(float health);
    /**
     * This is used to get the current health of a pokemon
     * @return - their health
     */
    public abstract float getHealth();
    /**
     * This is used for setting the pokemons moves based on previously set data
     * @param filename - The file with the pokemon moves
     */
    public abstract void addmove(String filename);
    /**
     * This is used for setting the pokemons stats based on previously set data
     * @param filename - The file with the pokemon stats
     */
    public abstract void addstat(String filename);
    /**
     * This is used for getting the value of a stat
     * @param stat - The stats whose value you are looking for
     * @return - returns the value of the stat
     */
    public abstract Integer getstat(String stat);
    /**
     * This is used for getting the basepower of a move
     * @param move - The move whose basepower you are looking for
     * @return - returns the basepower of the move
     */
    public abstract Integer getmove(String move);
    /**
     * This is used to get a name of a move if cpu is selected
     * @param value - a randomly generated value
     * @return - return the move name
     */
    public abstract String getmovename(int value);
    /**
     * This is used to get a name of a stat if cpu is selected
     * @param value - a randomly generated value
     * @return - return the stat name
     */
    public abstract String getstatname(int value);
    /**
     * This is used for calulating the damage done by a move
     * @param move - The move being used
     * @param attackerpokemon - The pokemon who used the move
     * @param defenderpokemon - The pokemon who is defending
     * @param stat - The stat that the move is using
     * @return - returns the damage that was done
     */
    public abstract Float calcdamage(String move, Pokemon attackerpokemon, Pokemon defenderpokemon ,String stat);
    /**
     * This is the method used to set weaknesses
     */
    public abstract void setWeakness();
    /**
     * This is the method used to set strengths
     */
    public abstract void setStrength();
    /**
     * This is used to get a weakness value
     * @param type - the pokemon type
     * @return retuns the weakness value
     */
    public abstract boolean getweakness(String type);
    /**
     * This is used to get a strength value
     * @param type - the pokemon type
     * @return retuns the strength value
     */
    public abstract boolean getstrength(String type);
    /**
     * This is used to get the size of cpu moves
     * @return - returns the size of cpu moves
     */
    public abstract int getCpumoves();
    /**
     * This is used to get the size of cpu stats
     * @return - returns the size of cpu stats
     */
    public abstract int getCpustats();
    /**
     * This is used to get a CPU pokemon name
     * @return - the pokemon name
     */
    public abstract String getCpuname();

}
