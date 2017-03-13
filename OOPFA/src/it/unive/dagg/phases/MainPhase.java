/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.phases;

import it.unive.interfaces.Player;
import java.util.InputMismatchException;
import java.util.Scanner;
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
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        
        System.out.println("Main Phase di "+getChief().getName());
        System.out.println("HAND : ");
        while(choice < 1 || choice > getChief().getHand().size()){
            getChief().printHand();
            try{
            System.out.println("Card to play?");
            choice = sc.nextInt();
            }catch(InputMismatchException ime){
                choice = 0;
                System.out.println("Card's index not found");
            }catch(Exception e){
                choice = 0;
                System.out.println("Something went wrong, retry");
            }
        }
        
        
    }
    
    
   
}
