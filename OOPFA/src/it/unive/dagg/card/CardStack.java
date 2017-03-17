package it.unive.dagg.card;

import it.unive.dagg.Game;
import it.unive.interfaces.Effect;
import it.unive.interfaces.EffectStack;
import java.util.ArrayDeque;
import java.util.Iterator;

/**
 * Classe che implementa uno stack
 * @author alessandro
 */

public class CardStack implements EffectStack {

    private final ArrayDeque<Effect> stack = new ArrayDeque<>();

/**
     * Crea un iteratore per lo stack
     * @return iteratore per lo stack
     */
    @Override
    public Iterator<Effect> iterator() {
        return stack.iterator();
    }
/**
 * Aggiunge un'effetto allo stack
 * @param e 
 */
    public void add(Effect e) {
        stack.push(e); 
        Game.getInstance().getStackObserver().casted(e);
        System.out.println("TEST");
    }
/**
 * Toglie un'effetto dallo stack
 * @param e 
 */
    public void remove(Effect e) {
        stack.remove(e);
    }
    
/**
 * Attiva un'effetto dallo stack se lo stack non è vuoto
 */
    public void resolve() {
        while(!stack.isEmpty()) { 
            Effect e = stack.pop();
            System.out.println("\n---------------------\nStack: resolved " + e);
            e.resolve(); 
        }
    }
/**
 * Stampa lo stack
 */
    @Override
    public void printStack() {
        for(Effect e : stack)
            System.out.println(e.toString());
    }
}
