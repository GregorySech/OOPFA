/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.observers;

import it.unive.interfaces.Effect;
import it.unive.interfaces.StackListener;
import java.util.ArrayList;


public class StackObserver implements it.unive.interfaces.StackObserver {
    private ArrayList<StackListener> alsl;
    public StackObserver(){
        this.alsl = new ArrayList<>();
    }
    @Override
    public void casted(Effect e) {
        for(StackListener sl : alsl)
            sl.onEffectCasted(e);
    }

    @Override
    public void updateStackListener(StackListener deprecated, StackListener updated) {
        alsl.remove(deprecated);
        alsl.add(updated);
    }

    @Override
    public void addStackListener(StackListener sl) {
        alsl.add(sl);
    }

    @Override
    public void removeStackListener(StackListener sl) {
        alsl.remove(sl);
    }
    
}
