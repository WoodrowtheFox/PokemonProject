package ethan.cs1622.pokemonshowdown;

import java.io.*;
import java.util.HashMap;
import java.util.Random;

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
                this.value.add(Integer.valueOf(valueinrow[1]));
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
     * This is used for calulating the damage done by a move
     * @param move - The move being used
     * @param pokemon - The pokemon who used the move
     * @param stat - The stat that the move is using
     * @return - returns the damage that was done
     */
    @Override
    public Float calcdamage(String move, Pokemon pokemon, String stat) {
        Damagefactory factory = new Damagefactory(getmove(move));
        return factory.damagefactory(pokemon, stat, getHealth());
    }
}
