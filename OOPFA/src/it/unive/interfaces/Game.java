/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.interfaces;

/**
 *
 */
public interface Game {
    PhaseObserver getPhaseObserver();
    PermanentObserver getPermanentObserver();
    StackObserver getStackObserver();
    VictoryObserver getVictoryObserver();
    EffectStack getEffectStack();
    StackListener getGameStackListener();
    VictoryListener getGameVictoryListener();
    
    void changeStackListener(StackListener sl);
    void changeVictoryListener(VictoryListener vl);
    
    Player getRival(Player p);
    void stop();
    void start();
}
