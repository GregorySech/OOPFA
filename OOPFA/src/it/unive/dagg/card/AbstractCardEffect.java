/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.card;

import it.unive.interfaces.Card;
import it.unive.interfaces.Effect;
import it.unive.interfaces.Player;

/**
 *
 * @author alessandro
 * Classe astratta che generalizza le carte con effetto
 */

public abstract class AbstractCardEffect implements Effect {
    
    protected Player player;
    protected Card card;
/**
 * Costruisce una carta senza il proprietario
 * @param carta 
 */
    protected AbstractCardEffect(Card carta) {
        this.card = carta;
        player = null;
    }
    
/**
 * Se non ha proprietario ritorna i dettagli della carta, altrimenti ritorna il 
 * proprietario e i dettaagli
 * @return 
 */
    @Override
    public String toString() {
        if(player == null)
            return card.toString();
        else
            return "["+player.getName()+"] casted "+card.toString();
    }
    
/**
 * attiva l'effetto della carta
 */
    @Override
    public void resolve(){
       
    }
/**
 * Definisce il proprietario della carta, ovvero il player che la carica nello stack
 * @param p 
 */    
    @Override
    public void setCaster(Player p){
        this.player=p;
    }

/**
 * 
 * Ritorna chi ha caricato l'effetto della carta nello stack
 * @return giocatore che carica l'effetto nello stack
 */
    @Override
    public Player getCaster() {
       return player;
    }

    
    
    
}
