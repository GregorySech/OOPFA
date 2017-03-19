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
public abstract class AbstractPermanent implements it.unive.interfaces.Permanent{
    protected String name;
    protected Player owner; /*owner è il possessore del Permanent. */
    /*CONSTRUCTOR*/
      public AbstractPermanent(String name, Player p){
          owner = p;
          this.name = name;
          Game.getInstance().getPermanentObserver().created(this);
      }
    @Override
      public void destroy(){
          Game.getInstance().getPermanentObserver().destroyed(this);
      }
    @Override
      public String getName(){
          return name;
      }
    @Override
      public Player getOwner() {
          return owner;
      }
    @Override
      public void setOwner(Player owner){
          this.owner = owner;
      }
    @Override
      public String toString(){
          return "("+owner.getName()+") ["+name+"]";
      }
      
}