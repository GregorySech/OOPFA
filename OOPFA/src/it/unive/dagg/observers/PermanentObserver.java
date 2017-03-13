/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.observers;

import it.unive.interfaces.Permanent;
import it.unive.interfaces.PermanentListener;
import java.util.ArrayList;

/**
 *
 * @author gregory
 */
public class PermanentObserver implements it.unive.interfaces.PermanentObserver {

    private ArrayList<PermanentListener> alpl;
    public PermanentObserver(){
        alpl = new ArrayList<>();
    }
    @Override
    public void created(Permanent p) {
        for(PermanentListener pl : alpl)
            pl.onPermanentCreated(p);
    }

    @Override
    public void summoned(Permanent p) {
        for(PermanentListener pl : alpl)
            pl.onPermanentSummoned(p);
    }

    @Override
    public void destroyed(Permanent p) {
        for(PermanentListener pl : alpl)
            pl.onPermanentDestroyed(p);
    }

    @Override
    public void removed(Permanent p) {
        for(PermanentListener pl : alpl)
            pl.onPermanentRemoved(p);
    }
    
    
    
}
