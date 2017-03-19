package it.unive.dagg;

import it.unive.dagg.card.CardStack;
import it.unive.dagg.card.cards.OmeopatyCardCreator;
import it.unive.dagg.listeners.DefaultStackListener;
import it.unive.dagg.listeners.DefaultVictoryListener;
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
    /**
     * @return singoletto di Game.
     */
    public static Game getInstance(){
        if(me == null)
            me = new Game();
        return me;
    }
    
    /**
     * Dati due giocatori da il via ad un nuovo gioco.
     * @param a Uno dei due giocatori generico.
     * @param b Uno dei due giocatori generico.
     */
    private void run(Player a, Player b){
        
        if(!running){
            Phase p;
            if(((int) (Math.random()*10)) % 2 == 0){ //random starting order.
                p1 = a;
                p2 = b;
            }else{
                p2 = a;
                p1 = b;
            }
            pm = new it.unive.dagg.phases.PhaseManager(p1);
            sl = new DefaultStackListener();
            so.addStackListener(sl);
            vl = new DefaultVictoryListener();
            vo.addVictoryListener(vl);  
            
            running = true;
            while(running){
                p = pm.getNextPhase();
                p.phaseRun();
            }
        }
    }
    
    /**
     * Inizia il ciclo di vita del gioco.
     */
    @Override
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
                System.out.println("Player 1 what's your name?");
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
                System.out.println("Player 2 what's your name?");
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

    /**
     * 
     * @return osservatore delle fasi di Game.
     */
    @Override
    public PhaseObserver getPhaseObserver() {
        return po;
    }

    /**
     * 
     * @return osservatore dei permanenti di Game.
     */
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
    
    @Override
    public EffectStack getEffectStack() {
        return es;
    }

    @Override
    public void stop() {
        this.running = false;
    }

    @Override
    public StackListener getGameStackListener() {
        return this.sl;
    }

    @Override
    public VictoryListener getGameVictoryListener() {
        return this.vl;
    }

    @Override
    public void changeStackListener(StackListener sl) {
        so.removeStackListener(this.sl);
        so.addStackListener(sl);
        this.sl = sl;
    }

    @Override
    public void changeVictoryListener(VictoryListener vl) {
        vo.removeVictoryListener(this.vl);
        vo.addVictoryListener(vl);
        this.vl = vl;
    }

    @Override
    public PhaseManager getPhaseManager() {
        return pm;
    }
    
    public static void main(String[] args){
        System.out.println("MAGIC - FIRST ASSIGNMENT");
        Game.getInstance().start();
    }
}
