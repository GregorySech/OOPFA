package it.unive.dagg.phases;

import it.unive.dagg.Game;
import it.unive.interfaces.Player;

/**
 * Concept of Phase: a Player's activity with a starting point and an ending point.
 * @author Gregory Sech
 */
public abstract class AbstractPhase implements it.unive.interfaces.Phase{
    
    private final Player chief;
    
    public AbstractPhase(Player chief) {
        this.chief = chief;
    }
    
    /**
     * @return "owner" of the phase.
     */
    @Override
    public Player getChief(){
        return chief;
    }
    
    /**
     * Phase's starting point.
     */
    protected void phaseStart(){
        Game.getInstance().getPhaseObserver().phaseStarted(this);
    }
    
    /**
     * Phase's ending point.
     */
    protected void phaseEnd(){
        Game.getInstance().getPhaseObserver().phaseEnded(this);
    }
    
    /**
     * @Override this for a specific activity
     */
    protected void activity(){
        
    }
    
    /**
     * Phase's life cycle.
     */
    @Override
    public final void phaseRun(){
       phaseStart();
       activity();
       phaseEnd();
    }
    
}
