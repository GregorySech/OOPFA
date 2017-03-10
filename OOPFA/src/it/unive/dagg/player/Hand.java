/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.player;
import java.util.ArrayList;
import it.unive.interfaces.Card;

/**
 *
 * @author diletta
 */
public class Hand extends ArrayList<Card>{
    
    public Hand(){
        super();
    }
    
    public boolean isFull(){
        if(this.size()<7){
            return false;
        }
        return true;
    }
}
