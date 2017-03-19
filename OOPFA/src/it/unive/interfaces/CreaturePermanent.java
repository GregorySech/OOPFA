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
       * ritorna la vita corrente della creatura
       * @return 
       */
      public int getLife();
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
      public void defenseFrom(CreaturePermanent attacker) throws Exception;
      /**
       * attacca il Player enemy
       * @param enemy 
       */
      public void attack(Player enemy) throws Exception;
      /**
       * ripristina il dannno della creatura
       */
      public void restoreDamage();
      /**
       * ritorna la Stringa contenente le info della creatura
       * @return 
       */
      public String toString();
}