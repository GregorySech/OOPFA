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
    void add(Effect e);
    void remove(Effect e);
    void resolve();
    void printStack();
}
