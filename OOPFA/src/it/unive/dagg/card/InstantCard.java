/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.card;

import it.unive.interfaces.Effect;
import it.unive.interfaces.Flash;
import it.unive.interfaces.Player;

/**
 *
 * @author alessandro
 */
public class InstantCard extends AbstractCard implements Flash{
    
    public InstantCard(String name, Effect e, String desc) {
        super(name, e, desc);
    }

    @Override
    public void flash(Player caster) {
        this.cast(caster);
    }
    
    
}
