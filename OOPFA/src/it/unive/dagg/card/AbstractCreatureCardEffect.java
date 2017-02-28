/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.card;

/**
 *
 * @author alessandro
 */
// creature cards
public abstract class AbstractCreatureCardEffect extends AbstractCardEffect {

    protected AbstractCreatureCardEffect( Player p, Card c) {
        super(p,c);
    }
    
    // per creare le creature
    protected abstract Creature createCreature();
    
    @Override
    public void resolve() {
        Creature creature = createCreature();
        CreaturaCampo caviaCreature = new CreaturaCampo(creature);
       
    } 
}
