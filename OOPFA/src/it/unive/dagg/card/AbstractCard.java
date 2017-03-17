/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.card;

import it.unive.dagg.Game;
import it.unive.interfaces.Card;
import it.unive.interfaces.Effect;
import it.unive.interfaces.Player;

/**
 *
 * @author alessandro
 * Classe astratta che generalizza tutte le carte
 */
public abstract class AbstractCard implements Card {

    String name;
    Effect e;
    String desc;
    /**
     * Costruttore di una carta
     * @param name
     * @param desc 
     */
    
    public AbstractCard(String name, String desc) {
        this.name=name;
        this.desc=desc;
    }
    
    /**
     * Ritorna l'effetto assegnato ad una carta
     * @param proprietario
     * @return e -> effetto della carta
     */
    @Override
    public Effect getEffetto(Player proprietario) {
        return e;
    }
    /**
     * Assegna un effetto a una carta
     * @param e 
     */
    @Override
    public void setEffect(Effect e){
        this.e = e;
    }
    
    /**
     * Ritorna la descrizione della carta
     * @return desc -> descrizone della carta
     */
    @Override
    public String getDescrizione() {
        return desc;
    }
/**
 * Ritorna il nome della carta
 * @return nome 
 */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Aggiunge un effetto allo stack
     * @param p 
     */
    @Override
    public void cast(Player p) {
        e.setCaster(p);
        Game.getInstance().getEffectStack().add(e);
        
    }
    
}
