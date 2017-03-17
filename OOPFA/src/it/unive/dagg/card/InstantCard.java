/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.card;

import it.unive.interfaces.Flash;
import it.unive.interfaces.Player;

/**
 *Crea una carta istantanea
 * @author alessandro
 */
public class InstantCard extends AbstractCard implements Flash{
    
/**
 * Costruttore della carta istantanea
 * @param name
 * @param desc 
 */
    public InstantCard(String name,  String desc) {
        super(name,  desc);
    }
/**
 * Assegna un caster
 * @param caster 
 */
    @Override
    public void flash(Player caster) {
        this.cast(caster);
    }
    
    
}
