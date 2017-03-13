/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.card;

import it.unive.interfaces.Card;
import it.unive.interfaces.Effect;
import it.unive.interfaces.Player;

/**
 *
 * @author alessandro
 */
public abstract class AbstractCard implements Card {

    String name;
    Effect e;
    String desc;
    
    public AbstractCard(String name, Effect e, String desc) {
        this.name=name;
        this.e=e;
        this.desc=desc;
    }
    
    @Override
    public Effect getEffetto(Player proprietario) {
        return e;
    }

    @Override
    public String getDescrizione() {
        return desc;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void cast(Player p) {
        
    }
    
}
