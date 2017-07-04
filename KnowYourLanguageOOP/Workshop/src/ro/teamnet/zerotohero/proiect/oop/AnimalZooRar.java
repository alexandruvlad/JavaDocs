package ro.teamnet.zerotohero.proiect.oop;

import ro.teamnet.zerotohero.proiect.exceptions.AnimalManancaOmException;

/**
 * Created by Alexandru.Vlad on 7/4/2017.
 */
public class AnimalZooRar extends Animal{



    public AnimalZooRar() {
        this.nume = "Leu";
        this.numeleTariideOrigine = "Africa";
    }

    public AnimalZooRar(String nume) {
        this.nume = nume;
        this.numeleTariideOrigine = "Mexic";
    }

    public AnimalZooRar(String nume, String numeleTariideOrigine) {
        this.nume = nume;
        this.numeleTariideOrigine = numeleTariideOrigine;
    }

    @Override
    void mananca(Object obj) throws AnimalManancaOmException{
        if(obj instanceof AngajatZoo || obj instanceof Animal){
            throw new AnimalManancaOmException("AnimalManancaCeNuTrebuieException");
        } else {
            System.out.println("AnimalulZooRar mananca");
        }
    }

    @Override
    void seJoaca() {
        System.out.println("AnimalulZooRar se joaca");
    }

    @Override
    void faceBaie() {
        System.out.println("AnimalulZooRar face baie");
        super.doarme();
    }

}
