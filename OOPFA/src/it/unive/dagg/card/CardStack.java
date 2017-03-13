package it.unive.dagg.card;

import it.unive.dagg.Game;
import it.unive.interfaces.Effect;
import it.unive.interfaces.EffectStack;
import java.util.ArrayDeque;
import java.util.Iterator;


public class CardStack implements Iterable<Effect>, EffectStack {

    private final ArrayDeque<Effect> stack = new ArrayDeque<>();
    
    @Override
    public Iterator<Effect> iterator() {
        return stack.iterator();
    }
    
    public void add(Effect e) {
        stack.push(e); 
        Game.getInstance().getStackObserver().casted(e);
    }

    public void remove(Effect e) {
        stack.remove(e);
    }
    
    public void resolve() {
        while(!stack.isEmpty()) { 
            Effect e = stack.pop();
            System.out.println("\n---------------------\nStack: resolved " + e);
            e.resolve(); 
        }
    }
}
