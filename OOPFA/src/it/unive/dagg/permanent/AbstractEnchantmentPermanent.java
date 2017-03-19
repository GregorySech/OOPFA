/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.permanent;

import it.unive.interfaces.Player;

/**
 *
 * @author giacomo
 */
public abstract class AbstractEnchantmentPermanent extends AbstractPermanent{
    
    public AbstractEnchantmentPermanent(String name, Player p) {
        super(name, p);
    }
}