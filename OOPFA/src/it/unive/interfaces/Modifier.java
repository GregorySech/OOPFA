/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.interfaces;

/**
 * Modificatore di statistiche di una creatura
 */
public interface Modifier {
    int getHpMod();
    int getAttackMod();
    void setHpMod(int hp);
    void setAttackMod(int atk);
}
