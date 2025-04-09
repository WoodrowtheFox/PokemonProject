package ethan.cs1622.pokemonshowdown;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Pokemon{
    protected HashMap<String, Integer> stats;
    protected HashMap<String, Integer> moves;
    protected ArrayList<String> typearray;
    protected String name;
    protected String type;
    protected boolean weakness;
    protected boolean tera;

    public Pokemon(){
        this.stats = new HashMap<>();
        this.moves = new HashMap<>();
        this.name = "Unknown";
        this.type = "Normal";
        this.tera = false;
        this.weakness = false;
        this.typearray = new ArrayList<>();
    }

    public abstract void setname(String name);

    public abstract String getname();

    public abstract void settype(String type);

    public abstract String getType();

    public abstract void addmove(String movename, Integer basepower);

    public abstract void addstat(String stat, Integer statamount);

    public abstract Integer getstat(String stat);

    public abstract boolean checkweakness(String filetype, Pokemon opponent);

    public abstract Float calcdamage(String move);

    public abstract void storestatsdata(String statsfile);

    public abstract void storemovedata(String movefile);
}
