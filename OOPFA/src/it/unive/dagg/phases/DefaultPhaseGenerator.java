/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.phases;

import it.unive.interfaces.Phase;
import it.unive.interfaces.PhaseGenerator;
import it.unive.interfaces.Player;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gregory
 */
public class DefaultPhaseGenerator implements PhaseGenerator{

    @Override
    public List<Phase> generateTurn(Player p) {
        ArrayList<Phase> alp = new ArrayList<>();
        alp.add(new UntapPhase(p));
        alp.add(new DrawPhase(p));
        alp.add(new CombatPhase(p));
        alp.add(new MainPhase(p));
        alp.add(new EndPhase(p));
        return alp;
    }
    
}
