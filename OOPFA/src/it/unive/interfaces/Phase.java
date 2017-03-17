/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.interfaces;

/**
 * Phase's services. 
 * @author Gregory Sech
 */
public interface Phase {
    /**
     * This will activate ALL the Phase life cycle.
     */
    public void phaseRun();
    /**
     * @return Phase's owner.
     */
    public Player getChief();
    
}
