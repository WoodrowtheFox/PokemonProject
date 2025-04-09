package ethan.cs1622.pokemonshowdown;

import java.util.HashMap;
import java.util.Random;

public class Damagefactory {
    private Random rand;
    private int critcalhit;
    private float damageroll;
    private Integer basepower;
    public Damagefactory(HashMap<String, Integer> moves, String move){
        this.rand = new Random();
        this.critcalhit = rand.nextInt(0,25);
        this.damageroll = rand.nextFloat(0.75f, 1.25f);
        this.basepower = moves.get(move);
    }
    public Float damagefactory(){
        if(critcalhit == 1){
            return 1.25f * basepower * damageroll;
        }
        else{return basepower * damageroll;}
    }
}
