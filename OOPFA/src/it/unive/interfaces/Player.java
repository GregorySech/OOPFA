/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.interfaces;

/**
 * Servizi che Player DEVE poter offrire
 * @author Gregory Sech
 */
public interface Player {
    /**
     * 
        Fa pescare una carta al giocatore dal proprio mazzo.
    */
    void draw();
    /**
     * Se alla fine della draw phase il giocatore ha più di 7 carte deve scartare
     */
    void resizeHand(); 
    /**
     * Fa scartare una carta al giocatore
     */
    
    void discard();
}
