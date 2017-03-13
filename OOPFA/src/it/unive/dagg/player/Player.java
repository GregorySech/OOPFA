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
import it.unive.dagg.Game;
import java.util.Collection;
import it.unive.interfaces.Card;
import it.unive.interfaces.Flash;
import it.unive.interfaces.Permanent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class Player implements it.unive.interfaces.Player{
    Deck deck;
    Hand hand;
    Field field;
    String name;
    int life;
    
    public Player(Collection<Card> deck, String name){
        this.life = 20;
        this.name = name;
        this.field = new Field();
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
    
    @Override
    public void subtractLife(int num){
        if(num<0){
            throw new UnsupportedOperationException();
        }else{
            this.life-=num;
        }
    }
    
    public int getLife(){
        return this.life;
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
        if(!hand.isEmpty()){
          for(int i=num; i!=0; i--){
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
    
    @Override
    public Collection<Card> getHand(){
        return this.hand;
    }
    
    @Override
    public void printHand(){
        for(Card c: hand){
            System.out.println((hand.indexOf(c)+1)+" "+c.getName());
        }
    }
    
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void play(int cardHandIndex) {
        hand.remove(cardHandIndex-1).cast();
    }
    
    public void play(Card card){
        hand.remove(card);
        card.cast();
    }
    
    /**
     * Prende in input un permanente da inserire nel campo personale del giocatore
     * @param p 
     */
    @Override
    public void addInField(Permanent p){
        field.add(p);
        Game.getInstance().getPermanentObserver().summoned(p);
    }
    
    public void takeFromField(Permanent p){
        field.remove(p);
        Game.getInstance().getPermanentObserver().removed(p);
    }
    
    public void takeFromField(int index){
        Game.getInstance().getPermanentObserver().removed(field.remove(index));
    }
    
    public Iterator<Flash> handFlashIterator(){
        ArrayList<Flash> handFlash = new ArrayList();
        for(Card c: this.hand){
            if(c instanceof Flash){
                handFlash.add((Flash)c);
            }
        }
        return handFlash.iterator();
    }
    
    public Iterator<Flash> fieldFlashIterator(){
        ArrayList <Flash> fieldFlash = new ArrayList();
        for(Permanent p: this.field){
            if(p instanceof Flash){
                fieldFlash.add((Flash)p);
            }
        }
        return fieldFlash.iterator();
    }
}
