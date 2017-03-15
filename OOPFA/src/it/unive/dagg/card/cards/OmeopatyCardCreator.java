/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.card.cards;

import it.unive.dagg.card.AbstractCardEffect;
import it.unive.dagg.card.InstantCard;
import it.unive.interfaces.Card;

/**
 *
 * @author alessandro
 */
public class OmeopatyCardCreator{
   

    public static Card getCard(){
        Card omeopathy = new InstantCard("Omeopathy",  "Does nothing");
        omeopathy.setEffect(new AbstractCardEffect(omeopathy) {});
        return omeopathy;
    }
    
}
