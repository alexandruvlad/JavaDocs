package ro.teamnet.zerotohero.oop.runapp;

import java.util.Date;

/**
 * Created by Alexandru.Vlad on 7/4/2017.
 */
public class Immutable {
        private final double aMass;
        private final String aName;
        private final Date aDateOfDiscovery;


    public Immutable(double aMass, String aName, Date aDateOfDiscovery) {
        this.aMass = aMass;
        this.aName = aName;
        this.aDateOfDiscovery = aDateOfDiscovery;
    }

    public double getMass() {
        return aMass;
    }

    public String getName() {
        return aName;
    }

    public Date getDateOfDiscovery() {
        return new Date(aDateOfDiscovery.getTime());
    }

}
