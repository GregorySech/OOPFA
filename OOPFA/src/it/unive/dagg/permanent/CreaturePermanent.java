/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.permanent;

import it.unive.interfaces.Player;

public abstract class CreaturePermanent extends Permanent implements it.unive.interfaces.CreaturePermanent{
    private final int hp;
    private final int attack;
    private boolean tapped = false; 
    private boolean defender = false;
    private int damage;
    
    public CreaturePermanent(String name, int hp, int attack, Player p){
        super(name, p);
        this.hp = hp;
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
    public int getLife(){
        return hp-damage;
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

    @Override
    public void untap(){
        tapped = false;
    }
    @Override
    public void defenseFrom(CreaturePermanent attacker) throws Exception{
        if(!defender)
             throw new Exception("["+name+"] I can't defend you!");
        damage += attacker.getAttack();
        attack(attacker);
    }

    @Override
    public void attack(Player enemy) throws Exception{ /*una creatura può attaccare solo il giocatore avversario.*/
        if(!tapped)
            throw new Exception("["+name+"] I can't attack!");
        enemy.subtractLife(attack);
    }
    private void attack(CreaturePermanent enemyCreature) {
        
        /*PRIVATE perchè lo chiamo internamente con il metodo defenseFrom*/
        damage += enemyCreature.getAttack();
        if(damage >= hp)
           destroy();
    }
    public void restoreDamage(){
        damage = 0;
    }
    
    @Override
    public String toString(){
       return super.toString()+" HP: "+hp+" ATTACK: "+attack+" TAPPED: "+tapped;
    }
}