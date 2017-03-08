/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.phases;

import it.unive.interfaces.PhaseListener;
import it.unive.dagg.Game;
import it.unive.interfaces.Phase;
import it.unive.interfaces.Player;

/**
 * Concept of Phase: a Player's activity with a starting and ending points.
 * @author Gregory Sech
 */
public abstract class AbstractPhase implements it.unive.interfaces.Phase{
    
    private final Player chief;
    private PhaseListener pl;
    
    public AbstractPhase(Player chief) {
        this.chief = chief;
        this.pl = new PhaseListener() {
            @Override
            public void onPhaseStarted(Phase p) {
                System.out.println("[AbstractPhase] Phase iniziata");
            }

            @Override
            public void onPhaseEnded(Phase p) {
                System.out.println("[AbstractPhase] Phase finita");
            }
        };
        Game.getInstance().getPhaseObserver().addPhaseListener(pl);
    }
    
    public AbstractPhase(Player chief, PhaseListener pl){
        this.chief = chief;
        this.pl = pl;
        Game.getInstance().getPhaseObserver().addPhaseListener(pl);
    }

    @Override
    public void setPhaseListener(PhaseListener pl){
        Game.getInstance().getPhaseObserver().removePhaseListener(this.pl);
        this.pl = pl;
        Game.getInstance().getPhaseObserver().addPhaseListener(this.pl);
    }
    
    @Override
    public Player getChief(){
        return chief;
    }
    
    void phaseStart(){
        Game.getInstance().getPhaseObserver().phaseStarted(this);
    }
    
    void phaseEnd(){
        Game.getInstance().getPhaseObserver().phaseEnded(this);
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
    
    public static void main(String[] args){
        System.out.println("MAIN");
        Game.getInstance().start();
        
        
    }
}
