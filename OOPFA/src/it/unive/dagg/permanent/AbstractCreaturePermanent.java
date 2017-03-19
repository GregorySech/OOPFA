/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.permanent;

import it.unive.interfaces.Creature;
import it.unive.interfaces.Modifier;
import it.unive.interfaces.Player;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author giacomo
 */
public abstract class AbstractCreaturePermanent extends AbstractPermanent implements Creature{
    private final int hp;
    private final int attack;
    private int damage;
    private boolean tapped = false;
    private List<Modifier> buffs;
    public AbstractCreaturePermanent(String name, int lifePoints, int attack, Player p){
        super(name, p);
        this.hp = lifePoints;
        this.attack = attack;
        this.buffs = new ArrayList<>();
        
    }
    @Override
    public int getHp(){
        int left = hp - damage;
        for(Modifier m : buffs)
            left += m.getHpMod();
        return left > 0 ? left : 0;
    }

    @Override
    public int getAttack(){
        int left = attack;
        for(Modifier m : buffs)
            left += m.getAttackMod();
        return left > 0 ? left : 0;
    }

    @Override
    public boolean isTapped(){
        return tapped;
    }

    @Override
    public void tap(){
        tapped = true;
    }

    @Override
    public void untap(){
        tapped = false;
    }

    @Override
    public void damage(int val) {
        this.damage += val;
        if(getHp() - damage <= 0)
            destroy();
    }

    @Override
    public void restoreHp(){
        damage = 0;
    }

    @Override
    public String toString(){
       return super.toString()+" HP: "+getHp()+" ATTACK: "+getAttack()+" TAPPED: "+tapped;
    }

    @Override
    public void addModifier(Modifier m) {
        buffs.add(m);
    }

    @Override
    public void removeModifier(Modifier m) {
        buffs.remove(m);
    }
    
    
}