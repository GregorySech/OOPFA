package it.unive.interfaces;

/**
 * 
 */
public interface Game {
    
    /**
     * 
     * @return entità che farà scattare gli eventi legati alle fasi.
     */
    PhaseObserver getPhaseObserver();
    /**
     * 
     * @return entità che farà scattare gli eventi legati ai permanenti
     */
    PermanentObserver getPermanentObserver();
    /**
     * 
     * @return entità che farà scattare gli eventi legati allo stack.
     */
    StackObserver getStackObserver();
    /**
     * 
     * @return entità che farà scattare gli eventi legati alla vittoria di un giocatore.
     */
    VictoryObserver getVictoryObserver();
    /**
     * 
     * @return stack degli effetti di questo game.
     */
    EffectStack getEffectStack();
    /**
     * 
     * @return azioni che il game esegue quando succede qualcosa allo stack.
     */
    StackListener getGameStackListener();
    /**
     * 
     * @return azioni che il game esegue quando un player vince.
     */
    VictoryListener getGameVictoryListener();
    /**
     * 
     * @return entità incaricata di procurare fasi al gioco.
     */
    PhaseManager getPhaseManager();
    /**
     * 
     * @param sl nuovo stack listener di game.
     */
    void changeStackListener(StackListener sl);
    /**
     * 
     * @param vl nuovo victory listener di game.
     */
    void changeVictoryListener(VictoryListener vl);
    
    /**
     * 
     * @param p uno dei due giocatori
     * @return dato p ritorna il suo avversario
     */
    Player getRival(Player p);
    /**
     * ferma il gioco
     */
    void stop();
    /**
     * fa iniziare il gioco.
     */
    void start();
}
