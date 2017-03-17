package it.unive.dagg.phases;

import it.unive.interfaces.Player;

/**
 * All chief's permanents should be untapped by the end of this phase.
 * @author Gregory Sech
 */
public class UntapPhase extends AbstractPhase{
    
    public UntapPhase(Player chief) {
        super(chief);
    }

    @Override
    protected void activity() {
        super.activity(); 
        System.out.println("UntapPhase di "+getChief().getName());
    }
    
    
}
