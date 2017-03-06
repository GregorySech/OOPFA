/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.phases;

import it.unive.dagg.Game;
import it.unive.interfaces.Player;
import it.unive.interfaces.Phase;
import it.unive.interfaces.PhaseListener;
/**
 * Gestore alternanza turni e modifiche alla struttura dei turni.
 * @author Gregory Sech
 */
public class PhaseManager {
    private PhaseListener pl;
    private AbstractPhase next;
    
    public PhaseManager(Player starter){
        pl = new PhaseListener() {
            @Override
            public void onPhaseStarted(Phase p) {
                
            }
            @Override
            public void onPhaseEnded(Phase p) {
                if(p instanceof EndPhase){
                    next = new DrawPhase(Game.getInstance().getRival(p.getChief()));
                }
            }
        };
        
    }
    
    public PhaseListener getPhaseListener(){
        return null;
    }
    
    public void setPhaseListener(PhaseListener pl){
        this.pl = pl;
    }
}
