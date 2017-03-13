/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.interfaces;

/**
 *
 * @author gregory
 */
public interface VictoryObserver {
    void addVictoryListener(VictoryListener vl);
    void removeVictoryListener(VictoryListener vl);
    void won(Player winner);
}
