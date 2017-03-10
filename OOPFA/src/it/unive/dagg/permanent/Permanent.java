/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.permanent;

import it.unive.interfaces.Card;
import it.unive.interfaces.Effect;
import it.unive.interfaces.Player;

/**
 *
 * @author giacomo
 */
/* PERMANENT rappresenta la creatura o l'incantesimo nel campo.*/
public abstract class Permanent implements it.unive.interfaces.Permanent{
    protected String name;
    protected Player chief; /*Player è il possessore del Permanent. */
    /*CONSTRUCTOR*/
      public Permanent(Card c, Player p){
          chief = p;
          name = c.nome();
      }
      
}
