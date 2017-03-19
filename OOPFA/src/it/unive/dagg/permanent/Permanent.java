/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.permanent;

import it.unive.dagg.Game;
import it.unive.interfaces.Player;

/**
 *
 * @author giacomo
 */
/* PERMANENT rappresenta la creatura o l'incantesimo nel campo.*/
public abstract class Permanent implements it.unive.interfaces.Permanent{
    protected String name;
    protected Player owner; /*owner è il possessore del Permanent. */
    /*CONSTRUCTOR*/
      public Permanent(String name, Player p){
          owner = p;
          this.name = name;
          Game.getInstance().getPermanentObserver().created(this);
      }
      public void destroy(){
          Game.getInstance().getPermanentObserver().destroyed(this);
      }
      public String getName(){
          return name;
      }
      public Player getOwner() {
          return owner;
      }
      public void setOwner(Player owner){
          this.owner = owner;
      }
      public String toString(){
          return "("+owner.getName()+") ["+name+"]";
      }
      
}