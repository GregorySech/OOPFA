/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Gregory Sech 
 * Contiene la logica e il ciclo di vita del gioco.
 * Ha un metodo main().
 */
public class Game {
    
    public static void main(String[] args){
        System.out.println("Hello");
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("pippo");
        lista.add("pluto");
        lista.add("paperino");
        
        while(lista.size() > 1){
            System.out.println(""+lista.remove(1));
        }

}
