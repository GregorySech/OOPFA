package it.unive.interfaces;

import java.util.List;

/**
 *
 * @author gregory
 */
public interface PhaseManager {
    /**
     * 
     * @return la prossima fase del gioco
     */
    Phase getNextPhase();
    /**
     * 
     * @return il generatore di fasi che viene utilizzato attualmente
     */
    PhaseGenerator getPhaseGenerator();
    /**
     * 
     * @param pg nuovo generatore delle fasi
     */
    void setPhaseGenerator(PhaseGenerator pg);
    /**
     * 
     * @param lp aggiunge fasi.
     */
    void stashPhases(List<Phase> lp);
    /**
     * 
     * @return la lista delle prossime fasi, usare con cautela.
     */
    List<Phase> getStashedPhases();
}
