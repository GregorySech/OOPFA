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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removePhaseListener(PhaseListener pl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void phaseStarted(Phase p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void phaseEnded(Phase p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
    
}
