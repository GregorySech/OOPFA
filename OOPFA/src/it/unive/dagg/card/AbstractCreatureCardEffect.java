/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.card;

import it.unive.interfaces.Creature;
import it.unive.interfaces.Effect;
import it.unive.interfaces.Permanent;
import it.unive.interfaces.Player;

/**
 *
 * @author alessandro
 * 
 * Classe astratta che generalizza al classe creature
 */

public abstract class AbstractCreatureCardEffect implements Effect {
    
    Player owner;
    Permanent perm;

/**
 * Crea una carta effetto passando un permanente
 * @param c 
 */
    protected AbstractCreatureCardEffect(Permanent c) {
        perm=c;
    }
    

/*PENSO sI POSSA TOGLIERE*/
    
/**
 * Metodo che serve a creare una creatura
 * @return Creatura
 */
    protected abstract Creature createCreature();
    
/**
 * Aggiunge un permanente al campo
 */
    @Override
    public void resolve() {
        owner.addInField(perm);
    } 
}
