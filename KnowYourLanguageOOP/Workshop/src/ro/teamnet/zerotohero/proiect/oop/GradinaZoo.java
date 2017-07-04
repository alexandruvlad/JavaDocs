package ro.teamnet.zerotohero.proiect.oop;

import java.util.Date;

/**
 * Created by Alexandru.Vlad on 7/4/2017.
 */
public class GradinaZoo {
    private final String denumireGradinaZoo;
    private final Date dataDeschideriiGradinii;
    private final AnimalZooRar animalRar;
    private final IngrijitorZoo angajatulLunii;

    public GradinaZoo(String denumireGradinaZoo, Date dataDeschideriiGradinii, AnimalZooRar animalRar, IngrijitorZoo angajatulLunii) {
        this.denumireGradinaZoo = denumireGradinaZoo;
        this.dataDeschideriiGradinii = dataDeschideriiGradinii;
        this.animalRar = animalRar;
        this.angajatulLunii = angajatulLunii;
    }


}
