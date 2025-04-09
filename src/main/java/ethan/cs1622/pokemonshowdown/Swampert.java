package ethan.cs1622.pokemonshowdown;

import java.io.*;
import java.util.HashMap;
import java.util.Random;

public class Swampert extends Pokemon{

    public Swampert(){super();}

    @Override
    public void setname(String name) {
        this.name = name;
    }

    @Override
    public String getname() {
        return this.name;
    }

    @Override
    public void settype(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void addmove(String movename, Integer basepower) {
        moves.put(movename, basepower);
    }

    @Override
    public void addstat(String stat, Integer statamount) {
        stats.put(stat, statamount);
    }

    @Override
    public Integer getstat(String stat) {
        return stats.get(stat);
    }

    @Override
    public boolean checkweakness(String filetype, Pokemon opponent) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filetype))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] valueinrow = line.split(" ");
                this.typearray.add(valueinrow[0]);
            }
        }
        catch (IOException o) {
            o.getMessage();
        }
        if(typearray.contains(opponent.getType())){return true;}
        else{return false;}
    }

    @Override
    public Float calcdamage(String move) {
        Damagefactory factory = new Damagefactory(moves, move);
        return factory.damagefactory();
    }

    @Override
    public void storestatsdata(String statsfile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(statsfile))){
            for (String i : stats.keySet()){
                writer.write(i);
                writer.write(" ");
                writer.write(stats.get(i));
                writer.newLine();
            }
        }
        catch (FileNotFoundException fnf){
            System.out.println(fnf.getMessage());
        }
        catch (IOException o){
            System.out.println(o.getMessage());
        }
    }

    @Override
    public void storemovedata(String movefile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(movefile))){
            for (String i : moves.keySet()){
                writer.write(i);
                writer.write(" ");
                writer.write(moves.get(i));
                writer.newLine();
            }
        }
        catch (FileNotFoundException fnf){
            System.out.println(fnf.getMessage());
        }
        catch (IOException o){
            System.out.println(o.getMessage());
        }
    }
}
