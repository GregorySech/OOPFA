/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.permanent;

import it.unive.interfaces.Modifier;

/**
 *
 * Implementazione astratta di un modificatore di statistiche
 */
public abstract class AbstractModifier implements Modifier{
    private int hp;
    private int atk;

    @Override
    public int getAttackMod() {
        return atk;
    }

    @Override
    public int getHpMod(){
        return hp;
    }

    @Override
    public void setAttackMod(int atk) {
        this.atk = atk;
    }

    @Override
    public void setHpMod(int hp) {
        this.hp = hp;
    }

}
