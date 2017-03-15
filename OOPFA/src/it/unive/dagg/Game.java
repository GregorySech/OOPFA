/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg;

import it.unive.dagg.card.CardStack;
import it.unive.dagg.card.cards.OmeopatyCardCreator;
import it.unive.dagg.listeners.DefaultStackListener;
import it.unive.interfaces.Card;
import it.unive.interfaces.EffectStack;
import it.unive.interfaces.PhaseManager;
import it.unive.interfaces.PermanentObserver;
import it.unive.interfaces.Phase;
import it.unive.interfaces.PhaseObserver;
import it.unive.interfaces.Player;
import it.unive.interfaces.StackListener;
import it.unive.interfaces.StackObserver;
import it.unive.interfaces.VictoryListener;
import it.unive.interfaces.VictoryObserver;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Contiene la logica e il ciclo di vita del gioco.
 * Ha un metodo main().
 */
public class Game implements it.unive.interfaces.Game {
    
    private static Game me = null;
    
    private PhaseManager pm;
    private boolean running;
    private Player p1,p2;
    private final PhaseObserver po;
    private final StackObserver so;
    private final PermanentObserver permo;
    private final VictoryObserver vo;
    private VictoryListener vl;
    private StackListener sl;
    private EffectStack es;
    private Game(){
        this.po = new it.unive.dagg.observers.PhaseObserver();
        this.permo = new it.unive.dagg.observers.PermanentObserver();
        this.so = new it.unive.dagg.observers.StackObserver();
        this.vo = new it.unive.dagg.observers.VictoryObserver();
        this.es = new CardStack();
        this.p1 = null;
        this.p2 = null;
        this.running = false;
        
    }
    
    public static Game getInstance(){
        if(me == null)
            me = new Game();
        return me;
    }
    
    private void run(Player a, Player b){
        if(!running){
            Phase p;
            if(((int) (Math.random()*10)) % 2 == 0){/*
                Assegno casualmente il giocatore iniziale.
                */
                p1 = a;
                p2 = b;
            }else{
                p2 = a;
                p1 = b;
            }
            this.pm = new it.unive.dagg.phases.PhaseManager(p1);
            sl = new DefaultStackListener();
            so.addStackListener(sl);
            vl = new VictoryListener() {
                @Override
                public void onVictory(Player p) {
                    System.out.println("Gratz  "+p.getName());
                    running = false;
                }
            };
            vo.addVictoryListener(vl);  
            
            running = true;
            while(running){
                System.out.println("[GAME] Ho iniziato una phase");
                p = pm.getNextPhase();
                p.phaseRun();
            }
        }
    }
    
    public void start() {
        /*
            Greeter del gioco, "form" per la creazione dei giocatori
        */
        if(!running){
            Scanner sc = new Scanner(System.in);
            String playerOneName = "", playerTwoName = "";
            boolean clean = false;
            System.out.println("Welcome Players in Magic Omeopathy Edition!");
            while(!clean){
                System.out.println("What's your name?");
                try {
                    playerOneName = sc.next("[a-zA-Z]+");
                    clean = true;
                } catch (Exception e) {
                    System.out.println("Letters only.");
                    sc.next();
                    clean = false;
                }
            }
            clean = false;
            while(!clean){
                System.out.println("["+playerOneName+"] what's your rival name?");
                try {
                    playerTwoName = sc.next("[a-zA-Z]+");
                    clean = true;
                } catch (Exception e) {
                    System.out.println("Letters only.");
                    sc.next();
                }
            }
            System.out.println("Nice to meet you ["+playerOneName+"] and ["+playerTwoName+"], have a nice game!");
            
            ArrayList<Card> deck1, deck2;
            deck1 = new ArrayList<>();
            deck2 = new ArrayList<>();
            for(int i = 0; i<20; i++){
                deck1.add(OmeopatyCardCreator.getCard());
                deck2.add(OmeopatyCardCreator.getCard());
            }
            
            run(new it.unive.dagg.player.Player(deck1, playerOneName), new it.unive.dagg.player.Player(deck2, playerTwoName));
            
        }
    }

    @Override
    public PhaseObserver getPhaseObserver() {
        return po;
    }

    @Override
    public PermanentObserver getPermanentObserver() {
        return permo;
    }

    @Override
    public StackObserver getStackObserver() {
        return so;
    }
    
    @Override
    public Player getRival(Player p){
        if(p == p1)
            return p2;
        else if(p == p2)
            return p1;
        else
            return null;
    }

    @Override
    public VictoryObserver getVictoryObserver() {
        return vo;
    }
    
    public static void main(String[] args){
        System.out.println("MAGIC - FIRST ASSIGNMENT");
        Game.getInstance().start();
    }

    @Override
    public EffectStack getEffectStack() {
        return es;
    }
}
