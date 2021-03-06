
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
    @Override
    public String toString();
    
            
}