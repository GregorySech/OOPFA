/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.card;

import java.util.List;

/**
 *
 * @author alessandro
 */
public interface Creature{

    String nome();
    boolean tap();
    boolean untap();
    boolean isTapped();
    void attacca(); // da implementare
    void difendi(Creature c); // da implementare
    void infliggiDanno(int dmg);
    void resetDanno();
    int getAttack();
    int getDefence();
    int getDefRemain();
    boolean isDefender();
    
    // ritorna gli effetti associati alle creature
    List<Effect> effects();
    
    // ritorna gli effetti avviabili
    // dipende dallo stato, ad esempio tapped o non tapped
    List<Effect> avaliableEffects();
}

