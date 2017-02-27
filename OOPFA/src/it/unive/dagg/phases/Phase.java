/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.phases;

import it.unive.dagg.Player;

/**
 *
 * @author Gregory Sech
 */
abstract class Phase {
    
    private final Player chief;

    Phase(Player chief) {
        this.chief = chief;
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
