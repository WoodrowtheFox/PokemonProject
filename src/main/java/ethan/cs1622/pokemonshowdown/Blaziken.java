package ethan.cs1622.pokemonshowdown;

import java.io.*;
/**
 * This is the class for the pokemon Blaziken
 */
public class Blaziken extends Pokemon{

    public Blaziken(){super();}

    /**
     * This is used for setting the pokemons type based on previously set data
     * @param filename - The file with the pokemon type
     */
    @Override
    public void setType(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] valueinrow = line.split(" ");
                this.type = (valueinrow[0]);}}
        catch (IOException o) {
            o.getMessage();
        }
    }
    /**
     * This is used for getting a pokemons type
     * @return - returns the pokemons type
     */
    @Override
    public String getType() {
        return this.type;
    }
    /**
     * This is used to set the current health of a pokemon
     * @param health - their health
     */
    @Override
    public void setHealth(float health) {
        this.health = health;
    }
    /**
     * This is used to get the current health of a pokemon
     * @return - their health
     */
    @Override
    public float getHealth() {
        return this.health;
    }
    /**
     * This is used for setting the pokemons moves based on previously set data
     * @param filename - The file with the pokemon moves
     */
    @Override
    public void addmove(String filename) {
        int total = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] valueinrow = line.split(" ");
                this.key.add(valueinrow[0]);
                this.value.add(Integer.valueOf(valueinrow[2]));
                this.movestypes.put(valueinrow[0], valueinrow[1]);
            }
            for (String i : key){
                moves.put(i, value.get(total));
                total += 1;
            }
        }
        catch (IOException o) {
            o.getMessage();
        }
    }
    /**
     * This is used for setting the pokemons stats based on previously set data
     * @param filename - The file with the pokemon stats
     */
    @Override
    public void addstat(String filename) {
        int total = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] valueinrow = line.split(" ");
                this.key.add(valueinrow[0]);
                this.value.add(Integer.valueOf(valueinrow[1]));
            }
            for (String i : key){
                stats.put(i, value.get(total));
                total += 1;
            }
        }
        catch (IOException o) {
            o.getMessage();
        }
    }
    /**
     * This is used for getting the value of a stat
     * @param stat - The stats whose value you are looking for
     * @return - returns the value of the stat
     */
    @Override
    public Integer getstat(String stat) {
        return stats.get(stat);
    }
    /**
     * This is used for getting the basepower of a move
     * @param move - The move whose basepower you are looking for
     * @return - returns the basepower of the move
     */
    @Override
    public Integer getmove(String move) {
        return moves.get(move);
    }
    /**
     * This is used to get a name of a move if cpu is selected
     *
     * @param value - a randomly generated value
     * @return - return the move name
     */
    @Override
    public String getmovename(int value) {
        return cpumoves.get(value);
    }
    /**
     * This is used to get a name of a stat if cpu is selected
     *
     * @param value - a randomly generated value
     * @return - return the stat name
     */
    @Override
    public String getstatname(int value) {
        return cpustats.get(value);
    }

    /**
     * This is used for calulating the damage done by a move
     * @param move - The move being used
     * @param attackerpokemon - The pokemon who used the move
     * @param defenderpokemon - The pokemon who is defending
     * @param stat - The stat that the move is using
     * @return - returns the damage that was done
     */
    @Override
    public Float calcdamage(String move, Pokemon attackerpokemon, Pokemon defenderpokemon, String stat) {
        Damagefactory factory = new Damagefactory(getmove(move));
        return factory.damagefactory(attackerpokemon, defenderpokemon, stat, getHealth(), move);
    }
    /**
     * This is the method used to set weaknesses
     */
    @Override
    public void setWeakness() {
        try (BufferedReader reader = new BufferedReader(new FileReader(getType() + "weak.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] valueinrow = line.split(" ");
                this.weakness.add(valueinrow[0]);}}
        catch (IOException o) {
            o.getMessage();
        }
    }
    /**
     * This is the method used to set strengths
     */
    @Override
    public void setStrength() {
        try (BufferedReader reader = new BufferedReader(new FileReader(getType() + "strong.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] valueinrow = line.split(" ");
                this.strength.add(valueinrow[0]);}}
        catch (IOException o) {
            o.getMessage();
        }
    }
    /**
     * This is used to get a weakness value
     *
     * @param type - the pokemon type
     * @return retuns the weakness value
     */
    @Override
    public boolean getweakness(String type) {
        if (weakness.contains(type)){return true;}
        else{return false;}
    }
    /**
     * This is used to get a strength value
     *
     * @param type - the pokemon type
     * @return retuns the strength value
     */
    @Override
    public boolean getstrength(String type) {
        if (strength.contains(type)){return true;}
        else{return false;}
    }
    /**
     * This is used to get the size of cpu moves
     *
     * @return - returns the size of cpu moves
     */
    @Override
    public int getCpumoves() {
        return cpumoves.size() - 1;
    }
    /**
     * This is used to get the size of cpu stats
     *
     * @return - returns the size of cpu stats
     */
    @Override
    public int getCpustats() {
        return cpustats.size() - 1;
    }
}
