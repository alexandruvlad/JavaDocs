package ro.teamnet.zerotohero.proiect.oop;

/**
 * Created by Alexandru.Vlad on 7/4/2017.
 */
public class VeterinarZoo implements AngajatZoo{
    public int bonusSalarial = 0;
    @Override
    public void lucreaza(Animal animal) {
        if (animal instanceof AnimalZooFeroce) {
            animal.faceBaie();
        } else {
            System.out.println("Angajatul are grija de animalul" + animal.nume);
        }
        calculeazaBonusSalarial();
    }

    @Override
    public void calculeazaBonusSalarial() {
        bonusSalarial += 2*valoareBonusPerAnimal;
        System.out.println("Veterinarul a primit "+bonusSalarial);
    }
}
