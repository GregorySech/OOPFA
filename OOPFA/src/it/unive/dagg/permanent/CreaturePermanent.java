/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.permanent;

import it.unive.interfaces.Effect;
import it.unive.interfaces.Player;

/**
 *
 * @author giacomo
 */
public class CreaturePermanent extends Permanent{
    /*una creatura ha: hp, valore di attacco,  */
    private int hp;
    private int attack;
    private String name;
    private Player chief; /*Player è il possessore del Permanent. */
    private boolean tapped = false; 
    public CreaturePermanent(Effect e, Player p){
        /*devo vedere come è fatto Effect.*/
        super(e);
        chief = p;
       
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
    public void defenseFrom(CreaturePermanent attacker){
        hp -= attacker.getAttack();
    }
    public void attack(Target t){
        
    }
    
    public String toString(){
       return 
    }
    
    
}
