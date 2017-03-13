/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.interfaces;

/**
 *
 */
public interface PermanentObserver {
    void created(Permanent p);
    void summoned(Permanent p);
    void destroyed(Permanent p);
    void removed(Permanent p);
}
