/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.interfaces;

/**
 *
 * @author Gregory Sech
 */
public interface PhaseObserver {
    public void addPhaseListener(PhaseListener pl);
    public void removePhaseListener(PhaseListener pl);
    public void phaseStarted(Phase p);
    public void phaseEnded(Phase p);
}
