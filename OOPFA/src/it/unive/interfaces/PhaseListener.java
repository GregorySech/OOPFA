package it.unive.interfaces;
/**
 *
 * @author Gregory Sech
 */
public interface PhaseListener {
    /**
     * 
     * @param p fase appena iniziata.
     */
    public void onPhaseStarted(Phase p);
    /**
     * 
     * @param p fase in fase (eheh) di terminazione.
     */
    public void onPhaseEnded(Phase p);
}
