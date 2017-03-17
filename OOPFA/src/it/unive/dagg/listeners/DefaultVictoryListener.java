/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.listeners;

import it.unive.dagg.Game;
import it.unive.interfaces.Player;
import it.unive.interfaces.VictoryListener;

/**
 *
 * @author Gregory Sech
 */
public class DefaultVictoryListener implements VictoryListener{

    @Override
    public void onVictory(Player p) {
        System.out.println("Well done ["+p.getName()+"], you've won!");
        Game.getInstance().stop();
    }
    
}
