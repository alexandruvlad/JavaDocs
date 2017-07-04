package ro.teamnet.zerotohero.proiect.oop;

import ro.teamnet.zerotohero.proiect.exceptions.AnimalManancaOmException;
import ro.teamnet.zerotohero.proiect.exceptions.AnimalPeCaleDeDisparitieException;

/**
 * Created by Alexandru.Vlad on 7/4/2017.
 */
public class IngrijitorZoo implements AngajatZoo{

    public int bonusSalarial = 0;

    @Override
    public void lucreaza(Animal animal) {
        System.out.println("Ingrijitorul intra in cusca animalului "+animal.nume);
    }

    @Override
    public void calculeazaBonusSalarial() {
        bonusSalarial += 3*valoareBonusPerAnimal;
        System.out.println("Angajatul a primit "+bonusSalarial);
    }

    public void lucreaza(Animal animal, Object mancare) throws AnimalPeCaleDeDisparitieException {
        lucreaza(animal);
        animal.doarme();
        animal.faceBaie();
        if(mancare instanceof AnimalZooRar && mancare != null){
            throw new AnimalPeCaleDeDisparitieException("A disparut!");
        } else {
            try {
                animal.mananca(mancare);
                calculeazaBonusSalarial();
            } catch (AnimalManancaOmException e) {
                e.printStackTrace();
            }
        }

    }
}
