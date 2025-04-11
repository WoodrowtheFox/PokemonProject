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
    public abstract void setType(String filename);

    public abstract String getType();

    public abstract void setHealth(float health);

    public abstract float getHealth();

    public abstract void addmove(String filename);

    public abstract void addstat(String filename);

    public abstract Integer getstat(String stat);

    public abstract Float calcdamage(String move, Pokemon pokemon, String stat);
}
