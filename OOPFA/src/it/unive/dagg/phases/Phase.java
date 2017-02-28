/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.phases;

import it.unive.dagg.Game;
import it.unive.dagg.Player;

/**
 * Concept of Phase: a Player's activity with a starting and ending points.
 * @author Gregory Sech
 */
public abstract class Phase implements it.unive.interfaces.Phase{
    
    private final Player chief;

    
    public Phase(Player chief) {
        this.chief = chief;
    }

    public Player getChief(){
        return chief;
    }
    
    void phaseStart(){
        Game.getInstance().phaseStarted(this);
    }
    
    void phaseEnd(){
        
    }
    
    /**
     * @Override this for a specific activity
     */
    void activity(){
        
    }
    
    /**
     * Makes the activity start.
     */
    @Override
    public final void phaseRun(){
       phaseStart();
       activity();
       phaseEnd();
    }
    
    
}
