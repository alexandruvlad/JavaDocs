package exercise3;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alexandru.Vlad on 7/7/2017.
 */
public class Exercise3Test {

    public static void main(String[] args){
        Map<Stud, BigDecimal> map1 = new HashMap<Stud, BigDecimal>();
        Map<Stud2, BigDecimal> map2 = new HashMap<Stud2, BigDecimal>();
        Map<Stud3, BigDecimal> map3 = new HashMap<Stud3, BigDecimal>();
        Map<Stud4, BigDecimal> map4 = new HashMap<Stud4, BigDecimal>();

        map1.put(new Stud("Marius","Capota"), BigDecimal.valueOf(9));
        map1.put(new Stud("Liliac","Vasile"), BigDecimal.valueOf(6));
        map1.put(new Stud("Marius","George"), BigDecimal.valueOf(8));
        map1.put(new Stud("Pictor","Virgil"), BigDecimal.valueOf(5));

        map2.put(new Stud2("Bujie","Radu"), BigDecimal.valueOf(6));
        map2.put(new Stud2("Nea","Ion"), BigDecimal.valueOf(8));
        map2.put(new Stud2("Hartie","Remus"), BigDecimal.valueOf(9));
        map2.put(new Stud2("Nea","Ion"), BigDecimal.valueOf(10));

        map3.put(new Stud3("Castron","Liviu"), BigDecimal.valueOf(6));
        map3.put(new Stud3("Randunica","Mirela"), BigDecimal.valueOf(9));
        map3.put(new Stud3("Lazar","Ana-Maria"), BigDecimal.valueOf(8));
        map3.put(new Stud3("Covor","Ioana"), BigDecimal.valueOf(7));

        map4.put(new Stud4("Virgula","Stefania"), BigDecimal.valueOf(5));
        map4.put(new Stud4("Piulita","Mihai"), BigDecimal.valueOf(10));
        map4.put(new Stud4("Valoare","Andrei"), BigDecimal.valueOf(5));
        map4.put(new Stud4("Vitamina","Claudiu"), BigDecimal.valueOf(7));

        System.out.println(map1);
        System.out.println(map2);
        System.out.println(map3);
        System.out.println(map4);
    }
}
