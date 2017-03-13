/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.card;

import it.unive.interfaces.Card;
import it.unive.interfaces.Effect;
import it.unive.interfaces.Player;

/**
 *
 * @author alessandro
 */

public abstract class AbstractCardEffect implements Effect {
    
    protected Player player;
    protected Card card;

    protected AbstractCardEffect(Player player, Card carta) {
        this.player = player;
        this.card = carta;
    }
    
    
    @Override
    public String toString() {
        return card.toString();
    }
    
    @Override
    public void resolve(){
       
    }
    
}
