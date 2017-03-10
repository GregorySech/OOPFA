/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.phases;

import it.unive.interfaces.Player;

/**
 *
 * @author Gregory Sech
 */
public class MainPhase extends AbstractPhase{
    
    public MainPhase(Player chief) {
        super(chief);
    }

    @Override
    void activity() {
        super.activity(); 
        
        System.out.println("Main Phase di "+getChief().getName());    
    }
    
    
   
}
