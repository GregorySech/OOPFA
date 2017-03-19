package it.unive.dagg.phases;

import it.unive.dagg.Game;
import it.unive.interfaces.Phase;
import it.unive.interfaces.PhaseGenerator;
import it.unive.interfaces.Player;
import it.unive.interfaces.PhaseListener;
import java.util.ArrayList;
import java.util.List;
/**
 * Gestore alternanza turni e modifiche alla struttura dei turni.
 * @author Gregory Sech
 */
public class PhaseManager implements it.unive.interfaces.PhaseManager{
    private PhaseListener pl;
    private PhaseGenerator pg;
    private List<Phase> next;
    public PhaseManager(Player starter){
        next = new ArrayList<>();
        pg = new DefaultPhaseGenerator();
        PhaseManager pm = this;
        Game.getInstance().getPhaseObserver().addPhaseListener(new PhaseListener() {
            PhaseManager tpm = pm;
            @Override
            public void onPhaseStarted(Phase p) {
            }

            @Override
            public void onPhaseEnded(Phase p) {
                if(p instanceof EndPhase){
                    pm.stashPhases(tpm.getPhaseGenerator().generateTurn(Game.getInstance().getRival(p.getChief())));
                }
            }
        });
        stashPhases(pg.generateTurn(starter));
        getNextPhase();
        getNextPhase();
    }

    @Override
    public Phase getNextPhase() {
        return next.remove(0);
    }
    
    public void stashPhases(List<Phase> cp){
        next.addAll(cp);
    }

    @Override
    public List<Phase> getStashedPhases() {
        return next;
    }

    
    @Override
    public PhaseGenerator getPhaseGenerator() {
        return pg;
    }

    @Override
    public void setPhaseGenerator(PhaseGenerator pg) {
        this.pg = pg;
    }
    
}
