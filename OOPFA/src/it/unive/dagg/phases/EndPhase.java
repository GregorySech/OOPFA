package it.unive.dagg.phases;

import it.unive.interfaces.Player;

/**
 * Chief end of turn. 
 * @author Gregory Sech
 */
public class EndPhase extends AbstractPhase{
    
    public EndPhase(Player chief) {
        super(chief);
    }

    @Override
    protected void activity() {
        super.activity(); 
        System.out.println("EndPhase di "+getChief().getName());        
    }
    
    
    
}
