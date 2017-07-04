package ro.teamnet.zerotohero.proiect.oop;

import ro.teamnet.zerotohero.proiect.exceptions.AnimalManancaOmException;

/**
 * Created by Alexandru.Vlad on 7/4/2017.
 */
public class AnimalZooFeroce extends Animal{

    @Override
    void mananca(Object obj) throws AnimalManancaOmException {
        if(obj instanceof AngajatZoo || obj instanceof Animal){
            throw new AnimalManancaOmException("AnimalManancaCeNuTrebuieException");
        } else {
            System.out.println("AnimalulZooFeroce mananca");
        }
    }

    @Override
    void seJoaca() {
        System.out.println("AnimalulZooFeroce se joaca");
    }

    @Override
    void faceBaie() {
        System.out.println("AnimalulZooFeroce face baie");
    }

    @Override
    public void doarme(){
        super.doarme();
        System.out.println("Animalul feroce vaneaza");
    }

}
