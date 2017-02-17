/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg;

import java.util.ArrayList;

/**
 * Classe Player, contiene dati sul giocatore
 * @author Gregory Sech
 */
public class Player {
    private final String name;
    private int vita;
    private ArrayList<Card> mano;
    private ArrayList<Card> mazzo;
    /**
     * Crea un nuovo giocatore con un nome e 20 punti vita.
     * @param name nome del giocatore.
     * @param mazzo mazzo del giocatore.
     */
    public Player(String name, ArrayList<Card> mazzo){
        vita = 20;
        this.name = name;
        this.mazzo = new ArrayList<>();
        for(int i = 0; i < mazzo.size(); i++)
            this.mazzo.add(mazzo.remove((int) (Math.random() * mazzo.size())));
    }
    
    /**
     * Crea un giocatore con un nome e dei punti vita.
     * Non va utilizzato in produzione del gioco ma solo per debug.
     * @param name nome del giocatore.
     * @param vita vita del giocatore.
     * @param mazzo mazzo del giocatore.
     */
    Player(String name, int vita, ArrayList<Card> mazzo){
        this.name = name;
        this.vita = vita;
        this.mazzo = new ArrayList<>(mazzo);
    }
    
    /**
     * 
     * @return nome del giocatore.
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @return vita rimasta al giocatore.
     */
    public int getVita() {
        return vita;
    }
    
    /**
     * 
     * @param danni inflitti al giocatore.
     * @return Trigger per attivare effetti.
     */
    public Trigger danneggia(int danni){
        Trigger t = null;
        if(danni > 0)
            vita -= danni;
        return t;
    }
    
    /**
     * 
     * @param cure vite recuperate dal giocatore
     * @return Trigger per attivare effetti.
     */
    public Trigger cura(int cure){
        Trigger t = null;
        if(cure > 0)
            vita += cure;
        return t;
    }
    
    public Trigger pesca(){
        Trigger t = null;
        mano.add(mazzo.remove(0));
        return t;
    }
    
    public Trigger inMazzo(Card c, int pos){
        Trigger t = null;
        mazzo.add(pos, c);
        return t;
    }
    
    public Trigger inMano(Card c){
        Trigger t = null;
        mano.add(c);
        return t;
    }
    
   
}
