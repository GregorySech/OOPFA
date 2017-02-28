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
    
    protected Player giocatore;
    protected Card carta;

    protected AbstractCardEffect(Player giocatore, Card carta) {
        this.giocatore = giocatore;
        this.carta = carta;
    }
    
    @Override
    public boolean play() {
        //giocatore.metodo che scarta una carta dalla mano
        return super.play();
    }
    
    @Override
    public String toString() {
        return carta.toString();
    }
}
