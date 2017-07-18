package ro.teamnet.zth.web;

/**
 * Created by Alexandru.Vlad on 7/18/2017.
 */
public class Person {

    String firstName;
    String lastName;
    Long age;
    boolean married;

    public Person(String firstName, String lastName, Long age, boolean married) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.married = married;
    }

    @Override
    public String toString() {
        String s = firstName + "; " + lastName + "; " + age + "; ";
        if(married){
            s += "Mariied.";
        } else {
            s+="Not Married.";
        }
        return s;
    }
}
