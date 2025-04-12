package ethan.cs1622.pokemonshowdown;

import java.util.HashMap;
import java.util.Random;

/**
 * This class is used to calculate the damage done by a move
 */
public class Damagefactory {
    private Random rand;
    private int critcalhit;
    private float damageroll;
    private Integer basepower;
    private float modifyer;
    public Damagefactory(Integer basepower){
        this.rand = new Random();
        this.critcalhit = rand.nextInt(0,25);
        this.damageroll = rand.nextFloat(0.75f, 1.25f);
        this.basepower = basepower;
        this.modifyer = 1.0f;
    }
    /**
     * The function that calculates the effects of a move
     * @param pokemon - the pokemon using the move
     * @param stat - the stat being used
     * @param health - the health of the opponent
     * @return - the amount/effect of the move
     */
    public Float damagefactory(Pokemon attackerpokemon, Pokemon defenderpokemon, String stat, float health, String move){
        if(defenderpokemon.getstrength(move)){this.modifyer = 0.5f;}
        else if(defenderpokemon.getweakness(move)){this.modifyer = 2.0f;}
        else{this.modifyer = 1.0f;}
        if(health > 0){
            if(critcalhit == 1){
                return modifyer * ((1.25f * basepower) + (attackerpokemon.getstat(stat) * damageroll));
            }
            else{
                return modifyer * (basepower + (attackerpokemon.getstat(stat) * damageroll));}}
        else{return 0.0f;}
    }
}
