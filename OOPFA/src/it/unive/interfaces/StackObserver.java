/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.interfaces;

/**
 *
 */
public interface StackObserver {
    /**
     * 
     * @param e Effect aggiunto allo Stack degli effetti
     */
    void casted(Effect e);
    /**
     * 
     * @param deprecated vecchio StackListener da sostituire
     * @param updated nuovo StackListener
     */
    void updateStackListener(StackListener deprecated, StackListener updated);
    
    /**
     * 
     * @param sl StackListener da aggiungere all'osservatore
     */
    void addStackListener(StackListener sl);
    
    /**
     * 
     * @param sl StackListener da aggiungere 
     * @return null se non è riuscito a rimuovere sl, sl altrimenti
     */
    void removeStackListener(StackListener sl);
}   
    

