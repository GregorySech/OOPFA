/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.interfaces;

/**
 * Metodi che Card DEVE offrire
 */
public interface Card {

    /**
     * Ritorna l'effetto assegnato ad una carta
     * @param proprietario
     * @return e -> effetto della carta
     */
    Effect getEffetto(Player proprietario);
    /**
     * Ritorna la descrizione della carta
     * @return desc -> descrizone della carta
     */
    String getDescrizione();
    /**
    * Ritorna il nome della carta
    * @return nome 
    */
    String getName();
      /**
     * Aggiunge un effetto allo stack
     * @param p 
     */
    void cast(Player caster);
    /**
     * Assegna un effetto a una carta
     * @param e 
     */
    void setEffect(Effect e);
}
