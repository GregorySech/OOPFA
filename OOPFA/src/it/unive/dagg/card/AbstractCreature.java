/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unive.dagg.card;

/**
 *
 * @author alessandro
 */


public abstract class AbstractCreature implements Creature {

    protected Player giocatore;
    protected boolean isTapped = false;
    protected int damageLeft = getDefence();
    private Creature cavia;//sarà la creatura fisica in campo

    protected AbstractCreature(Player giocatore) {
        this.giocatore = giocatore;
    }

    @Override
    public boolean tap() {
        if (isTapped) {
            System.out.println("creatura " + nome() + ": TAPPATA");
            return false;
        }
    System.out.println("tappo " + nome());
        isTapped = true;
        return true;
    }

    @Override
    public boolean untap() {
        if (!isTapped) {
            System.out.println("creatura " + nome() + ": NON TAPPATA");
            return false;
        }

        System.out.println("stappo " + nome());
        isTapped = false;
        return true;
    }

    @Override
    public boolean isTapped() {
        return isTapped;
    }

    @Override
    public void attacca() {
        //da implementare
    } 

    @Override
    public void difendi(Creature c) {
        //da implementare
    }

    @Override
    public void infliggiDanno(int dmg) {
        int damage = giocatore.damageCreature(dmg);

        damageLeft = cavia.getDefRemain() - damage;
        System.out.print("\n Danno inflitto "+damage+" alla creatura: "+this.nome());

        if (damageLeft <= 0) {
            System.out.print("\n\n\n" + this.nome() + " vita = 0 .... distrutto \n");
            //la creatura va distrutta
        }
    }
    
    @Override
    public int getDefRemain (){
        return damageLeft;
    }

    @Override
    public void resetDanno() {
        damageLeft = getDefence();
    }

    @Override
    public boolean isDefender() {
        return false;
    }

}
