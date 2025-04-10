package ethan.cs1622.pokemonshowdown;

import java.io.*;
import java.util.HashMap;
import java.util.Random;

public class Swampert extends Pokemon{

    public Swampert(){super();}

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

    @Override
    public String getType() {
        return this.type;
    }

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

    @Override
    public Integer getstat(String stat) {
        return stats.get(stat);
    }

    @Override
    public Float calcdamage(String move) {
        Damagefactory factory = new Damagefactory(moves, move);
        return factory.damagefactory();
    }
}
