/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg;

import it.unive.dagg.phases.PhaseListener;
import java.util.ArrayList;

/**
 * 
 * @author Gregory Sech
 */
class PhaseObserver {
    private final ArrayList<PhaseListener> lpl;
    
    PhaseObserver(){
        this.lpl = new ArrayList<>();
        
    }

    void addPhaseListener(PhaseListener phaseListener) {
        lpl.add(phaseListener);
    }

    
    
}
