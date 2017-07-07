package exercise0;

import java.util.*;

/**
 * Created by Radu.Hoaghe on 4/20/2015.
 *
 * Exercise 0: Iterate over the keys of a Map using keySet method (this method returns a Set of all the map keys) and
 *          print all its elements.
 */
public class Exercise0 {

    public Exercise0(){

    }

    public void iterateThroughMap(){

        //  Exercise #0 a) Create a Map (HashMap) and add elements to it (using put() method)
        //  Exercise #0 a) Hint: Don't forget to specify the types of the key and value when creating the Map

        Map<Integer, String> map = new HashMap<Integer,String>();

        map.put(0,"Zero");
        map.put(0,"Zerooooooo");
        map.put(1,"Unu");
        map.put(2,"Doi");
        map.put(3,"Trei");
        map.put(4,"Patru");
        map.put(5,"Cinci");
        map.put(6,"Sase");


        // Exercise #0 b) Iterate over the Map using keySet() method and print all its elements
        // Exercise #0 b) The elements could be printed like this: [key1=value1, key2=value2, ...]

        System.out.println(map);


        System.out.println("---------------------------------------------");
        Set<Integer> keyset = map.keySet();

        System.out.print("{");

        for(Integer key : keyset){
            System.out.print(key + "=" + map.get(key) + ",");
        }

        System.out.println("}");
        
    }

    public static void main(String[] args) {
        Exercise0 exercise0 = new Exercise0();
        exercise0.iterateThroughMap();
    }
}
