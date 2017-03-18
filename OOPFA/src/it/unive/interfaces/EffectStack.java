/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.interfaces;

/**
 *
 * @author alessandro
 */
public interface EffectStack extends Iterable<Effect> {
 /**
 * Aggiunge un'effetto allo stack
 * @param e 
 */
    void add(Effect e);
/**
 * Toglie un'effetto dallo stack
 * @param e 
 */
    void remove(Effect e);
/**
 * Attiva un'effetto dallo stack se lo stack non è vuoto
 */
    void resolve();
/**
 * Stampa lo stack
 */
    void printStack();
}
