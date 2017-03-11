/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.interfaces;


public interface PermanentListener {
    void onPermanentCreated(Permanent p);
    void onPermanentDestroyed(Permanent p);
    void onPermanentSummoned(Permanent p);
}
