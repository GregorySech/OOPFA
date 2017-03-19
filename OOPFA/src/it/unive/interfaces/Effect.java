/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.interfaces;

/**
 *
 * @author Gregory Sech
 */
public interface Effect {
    /**
    * attiva l'effetto della carta
    */
    void resolve();
    /**
    * Definisce il proprietario della carta, ovvero il player che la carica nello stack
    * @param p 
    */ 
    void setCaster(Player p);
    /**
    * 
    * Ritorna chi ha caricato l'effetto della carta nello stack
    * @return giocatore che carica l'effetto nello stack
    */
    Player getCaster();
    /**
     * Se non ha proprietario ritorna i dettagli della carta, altrimenti ritorna il 
    * proprietario e i dettaagli
    * @return 
    */
    @Override
    String toString();
}
