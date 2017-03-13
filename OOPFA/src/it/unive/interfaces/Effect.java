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
public interface Effect {
    // lancio l'effetto
    void resolve();
    void setcaster();
    Player getCaster();
}
