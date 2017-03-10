/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.card;

/**
 *
 * @author alessandro
 */

//rimuove una carta dalla mano e la mette nello stack
public abstract class AbstractCardEffect extends AbstractEffect {
    
    protected Player player;
    protected Card card;

    protected AbstractCardEffect(Player player, Card carta) {
        this.player = player;
        this.card = card;
    }
    
    @Override
    public boolean play() {
        //giocatore.metodo che scarta una carta dalla mano
        return super.play();
    }
    
    @Override
    public String toString() {
        return card.toString();
    }
}
