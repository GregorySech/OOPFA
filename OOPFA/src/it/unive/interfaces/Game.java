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
    public PhaseObserver getPhaseObserver();
    public PermanentObserver getPermanentObserver();
    public StackObserver getStackObserver();
    public VictoryObserver getVictoryObserver();
    public Player getRival(Player p);
    
}
