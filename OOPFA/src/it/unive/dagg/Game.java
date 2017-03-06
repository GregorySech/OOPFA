/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg;

import it.unive.dagg.phases.AbstractPhase;
import it.unive.dagg.phases.PhaseManager;
import it.unive.interfaces.Phase;
import it.unive.interfaces.PhaseListener;
import it.unive.interfaces.Player;


/**
 * @author Gregory Sech
 * Contiene la logica e il ciclo di vita del gioco.
 * Ha un metodo main().
 */
public class Game implements it.unive.interfaces.Game {
    
    private static Game me = null;
    
    private PhaseManager pm;
    private boolean running;
    private Player p1,p2;
    private PhaseObserver po;
    
    private Game(){
        this.po = new PhaseObserver();
        this.running = false;
    }
    
    private void run(Player a, Player b){
        if(!running){
            if(((int) (Math.random()*10)) % 2 == 0){
                p1 = a;
                p2 = b;
            }else{
                p2 = a;
                p1 = b;
            }
            this.pm = new PhaseManager(p1);
            po.addPhaseListener(pm.getPhaseListener());
            running = true;
            
        }
    }
    
    public static Game getInstance(){
        if(me == null)
            me = new Game();
        return me;
    }
    
    public Player getRival(Player p){
        if(p == p1)
            return p2;
        else if(p == p2)
            return p1;
        else
            return null;
    }
    

    @Override
    public void phaseStarted(Phase p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addPhaseListener(PhaseListener pl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void removePhaseListener(PhaseListener pl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void phaseEnded(AbstractPhase aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void start() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
