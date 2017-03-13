/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.permanent;

import it.unive.interfaces.Card;
import it.unive.interfaces.Effect;
import it.unive.interfaces.Player;

/**
 *
 * @author giacomo
 */
public abstract class CreaturePermanent extends Permanent{
    private int initialHp;
    private int hp;
    private int attack;
    private boolean tapped = false; 
    private boolean defender = false;
    
    public CreaturePermanent(String name, int lifePoints, int attack, Player p){
        super(name, p);
        initialHp = lifePoints;
        hp = initialHp;
        this.attack = attack;     
    }
    public int getHp(){
        return hp;
    }

    public int getAttack(){
        return attack;
    }

    public boolean isTapped(){
        return tapped;
    }

    public boolean isDefender(){
        return defender;
    }

    public void setDefender(boolean def) {
        defender = def;
    }

    public void tap(){
        tapped = true;
    }

    public void untap(){
        tapped = false;
    }

    public void defenseFrom(CreaturePermanent attacker) throws Exception{
        if(!defender)
             throw new Exception("["+name+"] I can't defend you!");
        hp -= attacker.getAttack();
        attack(attacker);
    }

    public void attack(Player enemy) throws Exception{ /*una creatura può attaccare solo il giocatore avversario.*/
        if(!tapped)
            throw new Exception("["+name+"] I can't attack!");
        enemy.subtractLife(hp);
    }
    private void attack(CreaturePermanent enemyCreature) {
        
        /*PRIVATE perchè lo chiamo internamente con il metodo defenseFrom*/
        hp -= enemyCreature.getAttack();
        if(hp <= 0)
           destroy();
    }
    public void restoreHp(){
        hp = initialHp;
    }
    
    public String toString(){
       return super.toString()+" HP: "+hp+" ATTACK: "+attack+" TAPPED: "+tapped;
    }
}