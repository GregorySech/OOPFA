/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.observers;

import it.unive.interfaces.Phase;
import it.unive.interfaces.PhaseListener;
import java.util.ArrayList;

/**
 * 
 * @author Gregory Sech
 */
public class PhaseObserver implements it.unive.interfaces.PhaseObserver {
    private final ArrayList<PhaseListener> lpl;
    
    public PhaseObserver(){
        this.lpl = new ArrayList<>();
        
    }

    @Override
    public void addPhaseListener(PhaseListener pl) {
        lpl.add(pl);
    }

    @Override
    public void removePhaseListener(PhaseListener pl) {
        lpl.remove(pl);
    }

    @Override
    public void phaseStarted(Phase p) {
        for(PhaseListener pl : lpl)
            pl.onPhaseStarted(p);
    }

    @Override
    public void phaseEnded(Phase p) {
        for(PhaseListener pl : lpl)
            pl.onPhaseEnded(p);
    }

    

    
    
}
