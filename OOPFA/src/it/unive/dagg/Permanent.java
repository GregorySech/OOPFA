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
public abstract class Permanent {
    
    protected String name;
    protected Player player;
    protected String description;
    
    public Permanent(Card card, Player player){
        this.name = card.name;
        this.player = player;
        this.description = card.description;
    }
    
    public Player getPlayer(){
        return player;
    }
    
    public String getName(){
        return name;
    }
    
    
}
