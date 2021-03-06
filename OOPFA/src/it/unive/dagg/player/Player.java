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
import java.util.NoSuchElementException;
import java.util.Scanner;
public class Player implements it.unive.interfaces.Player{
    Deck deck;
    Hand hand;
    Field field;
    String name;
    int life;
    int maxHand = 7;
    
    public int getMaxHand(){
        return maxHand;
    }
    
    public void setMaxHand(int max){
        maxHand = max;
    }
    
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
            if(this.life <= 0)
                Game.getInstance().getVictoryObserver().won(Game.getInstance().getRival(this));
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
        while(hand.size()>maxHand){
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
        System.out.println("Which one you want to discard? (insert number betwen 1 and "+hand.size()+")");
        do{
            index = scan.nextInt();
        }while(index < 1 || index > hand.size());
        return hand.get(index-1);
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
        if(cardHandIndex>=1 && cardHandIndex<=this.hand.size()){
            hand.remove(cardHandIndex-1).cast(this);
        }else{
            throw new IndexOutOfBoundsException("Choosen index resulted to be not valid");
        }
    }
    
    public void play(Card card){
        if(this.hand.contains(card)){
            hand.remove(card);
            card.cast(this);
        }else{
            throw new NoSuchElementException("Choosen card does not exist");
        }
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
    
    @Override
    public ArrayList<Flash> handFlashList(){
        ArrayList<Flash> handFlash = new ArrayList();
        for(Card c: this.hand){
            if(c instanceof Flash){
                handFlash.add((Flash)c);
            }
        }
        return handFlash;
    }
    
    @Override
    public ArrayList<Flash> fieldFlashList(){
        ArrayList <Flash> fieldFlash = new ArrayList();
        for(Permanent p: this.field){
            if(p instanceof Flash){
                fieldFlash.add((Flash)p);
            }
        }
        return fieldFlash;
    }
    
     public ArrayList<Flash> joinFlash(ArrayList<Flash> fieldFlash, ArrayList<Flash> handFlash){
        ArrayList<Flash> flashes = new ArrayList();
        for(Flash f: fieldFlash){
            flashes.add(f);
        }
        for(Flash f: handFlash){
            flashes.add(f);
        }
        return flashes;
    }

    @Override
    public Flash stackPlay() {
        int index;
        ArrayList<Flash> flashes = joinFlash(fieldFlashList(), handFlashList());
        do{
            Scanner scan = new Scanner(System.in);
            System.out.println("["+this.getName()+ "]Choose a card to insert in the stack");
            for(Flash f: flashes){
                System.out.println((flashes.indexOf(f)+1)+" "+f.getName());
            }
            System.out.println("If you don't want to add anything to the stack press 0");
            index = scan.nextInt();
        }while(index<0 || index>flashes.size());
        if(index == 0){
            return null;
        }else{
            return flashes.get(index-1);
        }
    }

    @Override
    public void play(Flash flash) {
       if(this.hand.contains(flash)){
           this.hand.remove((Card)flash);
       }
       flash.flash(this);
    }

    @Override
    public void winner() {
        if(this.deck.isEmpty() || this.life == 0){
            Game.getInstance().getVictoryObserver().won(Game.getInstance().getRival(this));
        }
    }
    
    
}
