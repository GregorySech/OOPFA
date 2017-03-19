package it.unive.interfaces;

/**
 *
 * @author giacomo
 */
public interface Creature extends Permanent{
      /**
       * ritorna i punti vita della creatura
       * @return 
       */
      int getHp();
      /**
       * ritorna i punti di attacco della creatura
       * @return 
       */
      int getAttack();
      /**
       * ritorna true se la creatura è tappata
       * @return 
       */
      boolean isTapped();
      /**
       * tappa la creatura
       */
      void tap();
      /**
       * untappa la creatura
       */
      void untap();
      /**
       * Infligge danni alla creatura e potenzialmente la distrugge
       * @param val danni inflitti alla creatura
       */
      void damage(int val);
      /**
       * ripristina i punti vita
       */
      void restoreHp();
      /**
       * ritorna la Stringa contenente le info della creatura
       * @return 
       */
      String toString();
      
      void addModifier(Modifier m);
      void removeModifier(Modifier m);
}