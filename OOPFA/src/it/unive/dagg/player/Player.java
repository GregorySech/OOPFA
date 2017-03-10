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
    int life;
    
    public Player(Collection<Card> deck){
        this.life = 20;
        this.deck = new Deck(deck);
        this.hand = new Hand();
        for(int i=0; i<5;i++){
            this.draw();
        }
        
    }
    
     public Player(Collection<Card> deck, int life){
        this.life = life;
        this.deck = new Deck(deck);
        this.hand = new Hand();
        for(int i=0; i<5;i++){
            this.draw();
        }
        
    }
     
    public void addLife(int num){
        if(num<0){
           throw new UnsupportedOperationException("You cannot add a negative number to life");
        }else{
            this.life+=num;
        }
    }
    
    public void sotractLife(int num){
        if(num<0){
            throw new UnsupportedOperationException();
        }else{
            this.life-=num;
        }
    }
    
    public int getLife(){
        return this.life;
    }
    
    public void setName(){
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
        int index;
        Scanner scan = new Scanner(System.in);
        System.out.println("You have to choose a card to discard. These are your cards:");
        printHand();
        System.out.println("Which one you want to discard?");
        index = scan.nextInt();
        return hand.get(index);
    }
    
    Collection<Card> getHand(){
        return this.hand;
    }
    
    public void printHand(){
        Card temp = null;
        for(Iterator<Card> i = hand.iterator(); i.hasNext();){
            temp = i.next();
            if(temp!=null){
                System.out.println(hand.indexOf(temp)+1+temp.getName());
            }
        }
    }
    
    @Override
    public String getName() {
        return this.name;
    }
    
    
    
    
    
    
    
    
}
