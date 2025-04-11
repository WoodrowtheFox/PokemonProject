package ethan.cs1622.pokemonshowdown;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Pokemon{
    protected HashMap<String, Integer> stats;
    protected HashMap<String, Integer> moves;
    protected ArrayList<String> typearray;
    protected ArrayList<String> key;
    protected ArrayList<Integer> value;
    protected String name;
    protected String type;
    protected float health;
    protected boolean weakness;
    protected boolean tera;

    public Pokemon(){
        this.stats = new HashMap<>();
        this.moves = new HashMap<>();
        this.health = 500.0f;
        this.name = "Unknown";
        this.type = "Normal";
        this.tera = false;
        this.weakness = false;
        this.key = new ArrayList<>();
        this.value = new ArrayList<>();
        this.typearray = new ArrayList<>();
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
    public abstract String getType();
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
     * This is used for calulating the damage done by a move
     * @param move - The move being used
     * @param pokemon - The pokemon who used the move
     * @param stat - The stat that the move is using
     * @return - returns the damage that was done
     */
    public abstract Float calcdamage(String move, Pokemon pokemon, String stat);
}
