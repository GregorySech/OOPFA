/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.interfaces;

/**
 *
 * @author giacomo
 */
public interface CreaturePermanent {
      public int getHp();
      public int getAttack();
      public boolean isTapped();
      public void defenseFrom(CreaturePermanent attacker);
      public Player getChief();
      
}
