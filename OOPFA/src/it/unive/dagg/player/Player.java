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
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class Player implements it.unive.interfaces.Player{
    Deck deck;
    Hand hand;
    Field field;
    String name;
    
    public Player(Collection<Card> deck){
        this.deck = new Deck(deck);
        this.hand = new Hand();
        for(int i=0; i<5;i++){
            this.draw();
        }
        
    }
    
    public void getName(){
       Scanner scan = new Scanner(System.in);
        System.out.println("Please, insert your player name");
        name = scan.next();
        System.out.println("Your name is: "+name);  
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

    @Override/**
     * resizeHand viene chiamato solo nella drawphase e fa scartare carte al giocatore
     * fino a che questo non ha 7 carte in mano, l'intero è passato a Discard è uno 
     * perchè non si sa quante carte bisognerà scartare prima di arrivare a 7
     */
    public void resizeHand() {
        while(hand.size()>7){
            discard(1);
        }
    }

    @Override/**
     * Metodo per scartare una o più carte, prende in input un intero perchè se ci sono
     * effetti che mi dicono di scartare carte, mi passeranno l'esatto numero di carte 
     * scartare
     */
    public void discard(int num) {
        if(hand.isEmpty()==false){
            for(; num==0; num--){
                hand.remove(choiceCard());
            }
        }
    }
    /**
     * Il metodo choiceCard fa scegliere all'utente che carta scartare
     */
    public Card choiceCard(){
        Card temp = null;
        int index;
        Scanner scan = new Scanner(System.in);
        System.out.println("You have to choose a card to discard. These are your cards:");
        for(Iterator<Card> i = hand.iterator(); i.hasNext();){
            temp = i.next();
            if(temp!=null){
                System.out.println(hand.indexOf(temp)+1+temp.getName());
            }
        }
        System.out.println("Which one you want to discard?");
        index = scan.nextInt();
        return hand.get(index);
    }
    
    
    
    
    
    
    
    
}
