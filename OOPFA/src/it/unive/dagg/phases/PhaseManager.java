/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.phases;

import it.unive.dagg.Game;
import it.unive.interfaces.Phase;
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
    private List<Phase> next;
    
    public PhaseManager(Player starter){
        next = new ArrayList<>();
        PhaseManager pm = this;
        Game.getInstance().getPhaseObserver().addPhaseListener(new PhaseListener() {
            PhaseManager tpm = pm;
            @Override
            public void onPhaseStarted(Phase p) {
            }

            @Override
            public void onPhaseEnded(Phase p) {
                if(p instanceof EndPhase){
                    pm.stashPhases(generateTurn(Game.getInstance().getRival(p.getChief())));
                }
            }
        });
        stashPhases(generateTurn(starter));
        getNextPhase();
        getNextPhase();
    }

    @Override
    public Phase getNextPhase() {
        return next.remove(0);
    }

    public List<Phase> generateTurn(Player p){
        ArrayList<Phase> alp = new ArrayList<>();
        
        alp.add(new UntapPhase(p));
        alp.add(new DrawPhase(p));
        alp.add(new CombatPhase(p));
        alp.add(new MainPhase(p));
        alp.add(new EndPhase(p));
        
        return alp;        
    }
    
    public void stashPhases(List<Phase> cp){
        next.addAll(cp);
    }
    
}
