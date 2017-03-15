/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.listeners;

import it.unive.dagg.Game;
import it.unive.interfaces.Effect;
import it.unive.interfaces.Flash;
import it.unive.interfaces.Player;
import it.unive.interfaces.StackListener;

/**
 *
 * @author giacomo
 */
public class DefaultStackListener implements StackListener{

    @Override
    public void onEffectCasted(Effect e) {
        Player rival = Game.getInstance().getRival(e.getCaster());
                    Flash rFlashPlay = null;
                    Flash mFlashPlay = null;
                    System.out.println("["+e.getCaster()+"] casted an effect.");
                    rFlashPlay = rival.stackPlay();
                    if(rFlashPlay != null)
                        rival.play(rFlashPlay);
                    else{
                        mFlashPlay = e.getCaster().stackPlay();
                        if(mFlashPlay != null)
                            e.getCaster().play(mFlashPlay);
                    }
                    if(mFlashPlay == null && rFlashPlay == null)
                        Game.getInstance().getEffectStack().resolve(); /*risolvo lo stack. */
                }
              
}
