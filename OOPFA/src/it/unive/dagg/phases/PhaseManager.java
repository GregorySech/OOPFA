/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.phases;

import it.unive.interfaces.Player;
import it.unive.interfaces.PhaseListener;
/**
 * Gestore alternanza turni e modifiche alla struttura dei turni.
 * @author Gregory Sech
 */
public class PhaseManager implements it.unive.interfaces.PhaseManager{
    private PhaseListener pl;
    private AbstractPhase next;
    
    public PhaseManager(Player starter){
        
    }
    
    
}
