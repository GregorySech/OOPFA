/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.card;

import it.unive.interfaces.Creature;
import it.unive.interfaces.Card;
import it.unive.interfaces.Effect;
import it.unive.interfaces.Permanent;
import it.unive.interfaces.Player;

/**
 *
 * @author alessandro
 */
// creature cards
public abstract class AbstractCreatureCardEffect implements Effect {
    
    Player owner;
    Permanent perm;

    protected AbstractCreatureCardEffect( Player p, Permanent c) {
        owner=p;
        perm=c;
    }
    
    // per creare le creature
    protected abstract Creature createCreature();
    
    @Override
    public void resolve() {
        //metodo che aggiunge il permanente al campo...
        owner.addInField(perm);
    } 
}
