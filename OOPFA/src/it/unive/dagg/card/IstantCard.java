/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.card;

import it.unive.interfaces.Card;
import it.unive.interfaces.Effect;
import it.unive.interfaces.Flash;

/**
 *
 * @author alessandro
 */
public class IstantCard extends AbstractCard implements Flash{
    
    public IstantCard(String name, Effect e, String desc) {
        super(name, e, desc);
    }
    
    
}
