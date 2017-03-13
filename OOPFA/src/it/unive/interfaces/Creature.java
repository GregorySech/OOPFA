/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.interfaces;

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
    void attack(); // da implementare
    void defend(Creature c); // da implementare
    void getInflictDamage(int dmg);
    void resetDamage();
    int getAttack();
    int getDefence();
    int getDefRemain();
    boolean isDefender(); //vedi se ti serve nei permanent
    
    // ritorna gli effetti associati alle creature
    List<Effect> effects();
    
    // ritorna gli effetti avviabili
    // dipende dallo stato, ad esempio tapped o non tapped
    List<Effect> avaliableEffects();
}

