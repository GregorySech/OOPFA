/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.player;


/**
 *
 * @author diletta
 */
import java.util.Collection;
import it.unive.interfaces.Card;
import java.util.NoSuchElementException;
public class Player implements it.unive.interfaces.Player{
    Deck deck;
    Hand hand;
    Field field;
    
    public Player(Collection<Card> deck){
        this.deck = new Deck(deck);
        this.hand = new Hand();
        for(int i=0; i<5;i++){
            this.draw();
        }
        
    }

    @Override
    /**
     * metodo per pescare, se il mazzo del giocatore è vuoto il giocatore perde
     */
    public void draw() {
       if(deck.isEmpty()){ 
           NoSuchElementException ball= new NoSuchElementException();
           throw ball;
       }else{
           hand.add(deck.remove(0));
       }
    }
    
    
    
    
    
    
}
