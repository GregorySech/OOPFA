/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.phases;

import it.unive.dagg.Player;

/**
 * Rappresents a 
 * @author Gregory Sech
 */
public abstract class Phase {
    
    private final Player chief;

    public Phase(Player chief) {
        this.chief = chief;
    }

    public Player getChief(){
        return chief;
    }
    
    void phaseStart(){
        
    }
    
    void phaseEnd(){
        
    }
    
    void activity(){
        
    }
    
    void phaseRun(){
       phaseStart();
       activity();
       phaseEnd();
    }
    
    
}
