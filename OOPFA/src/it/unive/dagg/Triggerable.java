/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg;

import java.util.Collection;

/**
 *
 * @author Gregory Sech
 * Interfaccia per gli oggetti che sono suscettibili da trigger del gioco.
 */
public interface Triggerable {
    /**
     * 
     * @param t source trigger.
     * @return risolve i trigger e ritorna nuovi trigger se ne vengono generati.
     */
    Collection<Trigger> runTrigger(Trigger t);
}
