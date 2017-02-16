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
 * Entità che rimane nel campo e che potrebbe influenzare il proseguimento del
 * gioco
 */
public class Permanent implements Triggerable{

    @Override
    public Collection<Trigger> runTrigger(Trigger t) {
        return null;
    }
    
}
