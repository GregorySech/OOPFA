/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.interfaces;

import java.util.List;

/**
 *
 * @author gregory
 */
public interface PhaseGenerator {
    List<Phase> generateTurn(Player p);
}
