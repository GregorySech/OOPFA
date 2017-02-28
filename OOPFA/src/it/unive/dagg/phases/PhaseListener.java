/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.phases;

/**
 *
 * @author Gregory Sech
 */
public interface PhaseListener {
    public void onPhaseStarted(Phase p);
    public void onPhaseEnded(Phase p);
}
