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
public class CreaturePermanent extends Permanent{
    /*una creatura ha: hp, valore di attacco,  */
    private int initialHp;
    private int hp;
    private int attack;
   
    private boolean tapped = false; 
    /*ABILITÀ: Cosa Sono? */
    public CreaturePermanent(Card/*Creature*/ c, Player p){
        /*devo vedere come è fatto Effect.*/
        super(c, p);
        initialHp = 0/*c.getLife()*/;
        hp = initialHp;
        attack = 0 /*c.attack()*/;       
    }
    public int getHp(){
        return hp;
    }
    public int getAttack(){
        return attack;
    }
    public Player getChief(){
        return chief;
    }
    public boolean isTapped(){
        return tapped;
    }
    public void tap(){
        tapped = true;
    }
    public void untap(){
        tapped = false;
    }
    public void defenseFrom(CreaturePermanent attacker){
        hp -= attacker.getAttack();
        attack(attacker);
    }
    public void attack(Player enemy){ /*una creatura può attaccare solo il giocatore avversario.*/
        hp -= 0 /*enemy.getAttacked(this)*/;
    }
    private void attack(CreaturePermanent enemyCreature){
        
    }
    public void restoreHp(){
        hp = initialHp;
    }
    
    public String toString(){
       return "["+name+"] HP: "+hp+" ATTACK: "+attack+" TAPPED: "+tapped+" ("+/*chief.getName()+*/")";
    }
    
    
}
