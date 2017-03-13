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
     * afflict è l'effetto che usa il permanente -> da implementare quando si chiama con classe anonima!
     * @param player 
     */
    public void afflict(Player player){}
    /**
     * afflict è l'effetto che usa il permanente -> da implementare quando si chiama con classe anonima!
     * @param permanent 
     */
    public void afflict(Permanent permanent){}
}