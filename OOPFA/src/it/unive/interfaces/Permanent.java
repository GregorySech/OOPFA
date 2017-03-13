/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.interfaces;

/**
 * Metodi che Permanent DEVE offrire
 * 
 */
public interface Permanent {
    /**
     * ritorna il Player che possiede il permanent
     * @return 
     */
    public Player getOwner();
    /**
     * setta il possessore del permanent
     * @param owner 
     */
    public void setOwner(Player owner);
    /**
     * ritorna il nome del permanent
     * @return 
     */
    public String getName();
    /**
     * avvisa l'observer della distruzione del permanente
     */
    public void destroy(); /*distrugge il permanent avvisando l'observer */
    /**
     * ritorna la Stringa contenente le info del permanente
     * @return 
     */
    public String toString();
    
            
}