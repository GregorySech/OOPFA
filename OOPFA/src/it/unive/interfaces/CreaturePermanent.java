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
public interface CreaturePermanent extends Permanent{
      /**
       * ritorna i punti vita della creatura
       * @return 
       */
      public int getHp();
      /**
       * ritorna i punti di attacco della creatura
       * @return 
       */
      public int getAttack();
      /**
       * ritorna true se la creatura è tappata
       * @return 
       */
      public boolean isTapped();
      /**
       * ritorna true se la creatura è in difesa
       * @return 
       */
      public boolean isDefender();
      /**
       * setta la creatura come difensore o no 
       * @param def 
       */
      public void setDefender(boolean def);
      /**
       * tappa la creatura
       */
      public void tap();
      /**
       * untappa la creatura
       */
      public void untap();
      /**
       * difendi il Player da attacker
       * @param attacker 
       */
      public void defenseFrom(CreaturePermanent attacker);
      /**
       * attacca il Player enemy
       * @param enemy 
       */
      public void attack(Player enemy);
      /**
       * ripristina i punti vita
       */
      public void restoreHp();
      /**
       * ritorna la Stringa contenente le info della creatura
       * @return 
       */
      public String toString();
}