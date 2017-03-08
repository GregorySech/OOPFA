/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.player;

import java.util.ArrayList;
import java.util.Collections;
import it.unive.interfaces.Card;
/**
 *
 * @author diletta
 */
public class Deck extends ArrayList<Card> {
    
    public Deck(){
        super();
        for(int counter=0; counter<20; counter++){
            this.add(new Card(){});
        }
    }
    
    public void shuffle(){
        Collections.shuffle(this);
    }
}
