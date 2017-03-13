/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.interfaces;

/**
 * Metodi che Card DEVE offrire
 * @author Gregory Sech
 */
public interface Card {

    // ritorna l'effetto che deve essere inserito nello stackgetEffetto(Player proprietario);
    Effect getEffetto(Player proprietario);
    String nome();
    String tipo(); //incantesimo, istantanea o creatura
    String getDescrizione();
    boolean isInstantaneo();
    String getName();
    void cast(Player caster);
}
