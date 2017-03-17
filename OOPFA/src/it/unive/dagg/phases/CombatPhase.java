package it.unive.dagg.phases;

import it.unive.interfaces.Player;

/**
 * Chief's combat phase (2nd assignment).
 * @author Gregory Sech
 */
public class CombatPhase extends AbstractPhase {
    
    public CombatPhase(Player chief) {
        super(chief);
    }

    @Override
    protected void activity() {
        super.activity(); 
        System.out.println("CombatPhase di "+getChief().getName());
    }
    
    
    
}
