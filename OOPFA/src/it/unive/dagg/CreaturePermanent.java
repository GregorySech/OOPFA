/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg;

/**
 *
 * @author giacomo
 */
public abstract class CreaturePermanent extends Permanent {
    private int hp;
    private int attack;
    private boolean tapped = false;
    /* CONSTRUCTOR */
    public CreaturePermanent(Card card, Player player){
        super(card, player);
        this.hp = card.hp;
        this.attack = card.attack;
       
    }
    /*ATTACK : attacca la creatura creature */
    public void attack(CreaturePermanent creature){
        creature.attacked(this);
    }
    
    private void attacked(CreaturePermanent creature){
        this.hp -= creature.getAttack();
        
    }
    
    public void tap(){
        tapped = true;
    }
    
    public void untap() {
        tapped = false;
    }
    
    public int getAttack(){
        return this.attack;
    }
    
    public void setAttack(int attack){
        this.attack = attack;
    }
    
    public int getHp(){
        return this.hp;
    }
    
    public void setHp(int hp){
        this.hp = hp;
    }
    
    public boolean isTapped(){
        return tapped;
    }
    
    
    /* TO STRING : stampa la creatura*/
    @Override
    public String toString(){
        return "["+name+"] HEALTH: "+hp+" ATTACK: "+attack+" ";
    }
    
}