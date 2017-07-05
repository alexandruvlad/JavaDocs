package exercise.exercise0;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Radu.Hoaghe on 4/20/2015.
 *
 * Exercise 0: Create a List (ArrayList or LinkedList), add elements to it and print all of them using ListIterator
 *             for loop and foreach loop.
 *
 */
public class Exercise0 {

    public Exercise0(){

    }

    public void iterateThroughList(){

        // TODO Exercise #0 a) Create a list (ArrayList or LinkedList) and add elements to it
        // TODO Exercise #0 a) Don't forget to specify the type of the list (Integer, String etc.)

        List<Integer> intArray = new ArrayList<Integer>(10);

        for (int i = 0; i<10; i++){
            intArray.add(i*2);
        }

        // TODO Exercise #0 b) Iterate through the list using ListIterator and print all its elements

        //ListIterator<Integer> l = intArray.listIterator();


        // TODO Exercise #0 c) Iterate through the list using classic for loop and print all its elements

        for (ListIterator<Integer> it = intArray.listIterator(); it.hasNext(); ) {
            Integer i = it.next();
            System.out.print(i+" ");
        }
        System.out.println();

        // TODO Exercise #0 d) Iterate through the list using foreach loop and print all its elements

        ListIterator<Integer> l1 = intArray.listIterator();
        for(Integer o : intArray){
            System.out.print(o+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // TODO Exercise #0 e) Create a new instance of Exercise0 class and call the iterateThroughList() method

        Exercise0 e0 = new Exercise0();

        e0.iterateThroughList();

    }
}
