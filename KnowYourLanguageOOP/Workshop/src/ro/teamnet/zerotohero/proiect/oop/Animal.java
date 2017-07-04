package ro.teamnet.zerotohero.proiect.oop;

import ro.teamnet.zerotohero.proiect.exceptions.AnimalManancaOmException;

/**
 * Created by Alexandru.Vlad on 7/4/2017.
 */
public abstract class Animal {

    public String nume;
    public String numeleTariideOrigine;

    public Animal(){
        System.out.println("Animal nou");
    }

    abstract void mananca(Object obj) throws AnimalManancaOmException;
    abstract void seJoaca();
    abstract void faceBaie();
    public void doarme(){
        System.out.println("Animalul doarme");
    }
}
