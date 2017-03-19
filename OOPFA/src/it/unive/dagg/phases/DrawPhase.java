package it.unive.dagg.phases;

import it.unive.dagg.Game;
import it.unive.interfaces.Player;
import java.util.NoSuchElementException;

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
        try{
            getChief().draw();
        }
        catch(NoSuchElementException e){
            System.out.println("["+getChief().getName()+"] You can't draw a Card! (Empty Deck)");
            Player winner = Game.getInstance().getRival(getChief());
            Game.getInstance().getGameVictoryListener().onVictory(winner);
        }
            getChief().resizeHand();
    }
    
    
    
}
