package it.unive.dagg.phases;

import it.unive.interfaces.Player;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * chief's main phase, chief can cast a spell from his hand and start a chain.
 * @author Gregory Sech
 */
public class MainPhase extends AbstractPhase{
    
    public MainPhase(Player chief) {
        super(chief);
    }

    @Override
    protected void activity() {
        super.activity();
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        System.out.println("Main Phase di "+getChief().getName());
        System.out.println("HAND : ");
        while(choice < 0 || choice > getChief().getHand().size()){
            getChief().printHand();
            try{
            System.out.println("Card to play? 0 to skip");
            choice = sc.nextInt();
            }catch(InputMismatchException ime){
                choice = -1;
                System.out.println("Card's index not found");
                sc.next();
            }catch(Exception e){
                choice = -1;
                System.out.println("Something went wrong, retry");
                sc.next();
            }
        }
        if(choice != 0){
            getChief().play(choice);
        }
        
    }
    
    
   
}
