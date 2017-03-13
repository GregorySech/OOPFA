/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.observers;

import it.unive.interfaces.Player;
import it.unive.interfaces.VictoryListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gregory
 */
public class VictoryObserver implements it.unive.interfaces.VictoryObserver {
    private List<VictoryListener> alvl;
    
    public VictoryObserver(){
        alvl = new ArrayList<>();
    }
    @Override
    public void addVictoryListener(VictoryListener vl) {
        alvl.add(vl);
    }

    @Override
    public void removeVictoryListener(VictoryListener vl) {
        alvl.remove(vl);
    }

    @Override
    public void won(Player winner) {
        for(VictoryListener vl : alvl)
            vl.onVictory(winner);
    }
    
}
