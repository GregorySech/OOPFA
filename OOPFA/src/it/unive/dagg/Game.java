/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg;

import it.unive.interfaces.Effect;
import it.unive.interfaces.Card;
import it.unive.interfaces.EffectStack;
import it.unive.interfaces.Flash;
import it.unive.interfaces.Permanent;
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
            sl = new StackListener() {
                @Override
                public void onEffectCasted(Effect e) {
                    Player rival = getRival(e.getCaster());
                    Scanner sc = new Scanner(System.in);
                    boolean clean = false;
                    int selected;
                    ArrayList<Flash> rivalHandFlash = rival.handFlashList();
                    ArrayList<Flash> rivalFieldFlash = rival.fieldFlashList();
                    ArrayList<Flash> casterHandFlash = e.getCaster().handFlashList();
                    ArrayList<Flash> casterFieldFlash = e.getCaster().fieldFlashList();
                    System.out.println("["+e.getCaster()+"] casted an effect.");
                    System.out.println("["+rival+"] Do you want to respond with a card? (0 for pass)");
                    for(Flash f : rivalHandFlash){
                        if(f instanceof Card)
                            System.out.println(""+(rivalHandFlash.indexOf(f)+1)+" "+((Card) f).getName());
                    }
                    do{
                        selected = sc.nextInt();
                    }while(selected >= 0 && selected <= rivalHandFlash.size());
                    if(selected != 0)
                        rival.play(rivalHandFlash.get(selected-1));
                    else{
                        System.out.println("["+rival+"] Do you want to respond with a permanent? (0 for pass)");
                        for(Flash f : rivalFieldFlash){
                            if(f instanceof Permanent)
                                System.out.println(""+(rivalFieldFlash.indexOf(f)+1)+" "+((Permanent) f).getName());
                        }
                        do{
                            selected = sc.nextInt();
                        }while(selected >= 0 && selected <= rivalFieldFlash.size());
                        if(selected != 0)
                            rival.play(rivalFieldFlash.get(selected-1));
                    }
                    if(selected == 0){
                       System.out.println("["+e.getCaster()+"] Dou want to add a card? (0 for pass)");
                       for(Flash f : casterHandFlash){
                        if(f instanceof Card)
                            System.out.println(""+(casterHandFlash.indexOf(f)+1)+" "+((Card) f).getName());
                        }
                        do{
                            selected = sc.nextInt();
                        }while(selected >= 0 && selected <= casterHandFlash.size());
                        if(selected != 0)
                            e.getCaster().play(casterHandFlash.get(selected-1));
                        else{
                            System.out.println("["+e.getCaster()+"] Do you want to add a permanent? (0 for pass)");
                            for(Flash f : casterFieldFlash){
                                if(f instanceof Permanent)
                                    System.out.println(""+(casterFieldFlash.indexOf(f)+1)+" "+((Permanent) f).getName());
                            }
                            do{
                                selected = sc.nextInt();
                            }while(selected >= 0 && selected <= casterFieldFlash.size());
                            if(selected != 0)
                                e.getCaster().play(casterFieldFlash.get(selected-1));
                        }
                    }
                
                }
              
            };
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
                }
            }
            System.out.println("Nice to meet you ["+playerOneName+"] and ["+playerTwoName+"], have a nice game!");
            
            ArrayList<Card> deck1, deck2;
            deck1 = new ArrayList<>();
            deck2 = new ArrayList<>();
       
            
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
