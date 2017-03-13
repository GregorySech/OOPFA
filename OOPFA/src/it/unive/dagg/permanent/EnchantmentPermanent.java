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
public abstract class EnchantmentPermanent extends Permanent{
    
    public EnchantmentPermanent(String name, Player p) {
        super(name, p);
    }
    /**
     * 
     * @param p 
     */
    public abstract void afflict(Player player);
    /**
     * 
     * @param permanent 
     */
    public abstract void afflict(Permanent permanent);
}