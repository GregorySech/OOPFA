package it.unive.dagg.phases;

import it.unive.interfaces.Player;

/**
 * chief's draw phase. Chief's hand must be resized in this phase.
 * @author Gregory Sech
 */
public class DrawPhase extends AbstractPhase {
    
    public DrawPhase(Player chief) {
        super(chief);
    }

    @Override
    protected void activity() {
        System.out.println("DrawPhase di "+getChief().getName());
        getChief().draw();
        System.out.println("RESIZE DELLA MANO");
        getChief().resizeHand();
        System.out.println("FINE DRAW");
    }
    
    
    
}
