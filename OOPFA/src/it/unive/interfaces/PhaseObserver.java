package it.unive.interfaces;

/**
 *
 * @author Gregory Sech
 */
public interface PhaseObserver {
    public void addPhaseListener(PhaseListener pl);
    public void removePhaseListener(PhaseListener pl);
    /**
     * avvisa l'oggetto dell'inizio di una fase
     * @param p fase iniziata
     */
    public void phaseStarted(Phase p);
    /**
     * avvisa l'oggetto della fine di una fase
     * @param p fase finita
     */
    public void phaseEnded(Phase p);
}
