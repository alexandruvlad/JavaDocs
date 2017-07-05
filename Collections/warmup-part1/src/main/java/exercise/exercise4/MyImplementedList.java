package exercise.exercise4;

import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * You should implement from zero a data structure that acts as an ArrayList.
 * We have a default capacity of {@link MyImplementedList#DEFAULT_CAPACITY} elements of type <code>E</code>.
 * We have a {@link MyImplementedList#size} property that stores the number of elements of type <code>E</code> from the data structure.
 * We have an array property, {@link MyImplementedList#elementData}, that keeps the elements from the data structure.
 * We have a {@link MyImplementedList#LOAD_FACTOR} property that specify the maximum accepted load of the data structure.
 * We have a {@link MyImplementedList#INCREASE_SIZE_FACTOR} property to use it when we must increase the capacity of the data structure.
 * We have a {@link MyImplementedList#capacityAfterExtending} property to use it to retain the new capacity after increasing it.
 * <p>
 * Starting with this properties we must implement a data structure that acts ~ as an ArrayList for some objects of type <code>E</code>.
 * <p>
 * TODO if you need to throw some exceptions YOU MUST create them!
 * TODO if you get some warning from the compiler you can use @SuppressWarnings("all") before the method name!
 * TODO if you get this error "usage of api documented as @since 1.6+" you should go to File > Project Structure > Modules and make sure you have the Language level >= 1.6!
 * TODO you should expose as <code>public</code> only the methods that you usually use over a collection!
 * TODO if you need a getter/setter for the properties you must define then, but keep in mind the java concepts!
 * TODO make sure you cover all the possible use-cases for your data structure!
 *
 * @author Cristian.Dumitru
 * @since 7/3/2017.
 */
public class MyImplementedList<E> implements Iterable{

    /**
     * The maximum accepted load property of the data structure.
     */
    private static final double LOAD_FACTOR = 0.75d;

    /**
     * The factor for increasing the size of the data structure.
     */
    private static final int INCREASE_SIZE_FACTOR = 2;

    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * The size of the ArrayList (the number of elements it contains).
     */
    private int size;

    /**
     * The array buffer into which the elements of the {@link MyImplementedList} are stored.
     */
    private Object[] elementData;

    /**
     * Property to keep the extended capacity.
     * TODO if you choose another way to implement the extending capacity you can define your own properties,
     * TODO but the rest of them must remain as they are.
     */

    private int capacityAfterExtending;

    //TODO a) implement the empty constructor for the your data structure
    public MyImplementedList() {
        //TODO a) HINT - DEFAULT_CAPACITY, capacityAfterExtending and elementData properties
        size = 0;
        elementData = new Object[DEFAULT_CAPACITY];
        capacityAfterExtending = DEFAULT_CAPACITY;
    }

    //TODO b) create the int size() method that returns the size of the data structure

    public int size(){
        return size;
    }

    //TODO c) create the boolean add(E e) method that adds at the end of the data structure an element
    //TODO pay attention to the LOAD_FACTOR of the data structure

    public boolean add(E e){
        if(e != null && LOAD_FACTOR>(float)size/(float)capacityAfterExtending){
            elementData[size] = (Object)e;
            size++;
            return true;
        } else if(e != null && LOAD_FACTOR<=(float)size/(float)capacityAfterExtending) {
            extendCapacity(capacityAfterExtending);
            resize(capacityAfterExtending);
            elementData[size] = (Object)e;
            size++;
        }
        return false;
    }

    public void resize(int capacity){
        Object[] aux = new Object[size];
        for(int i = 0; i<size; i++){
            aux[i] = elementData[i];
        }
        elementData = new Object[capacity];
        for(int i = 0;i<size;i++){
            elementData[i] = aux[i];
        }
    }

    //TODO d) create the boolean isEmpty() method that checks if the data structure have elements

    public boolean isEmpty(){
        if(size == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    //TODO e) create the boolean contains(Object o_O) method that checks if the data structure contains the object o_O

    public boolean contains(Object o_O){
        for(Object o:elementData){
            if(o == o_O){
                return true;
            }
        }
        return false;
    }

    //TODO f) create the int indexOf(Object o_O) method that returns the position in the data structure of the object o_O
    //TODO if exists, otherwise return -1

    public int indexOf(Object o_O){
        for (int i = 0; i<size; i++){
            if(elementData[i] == o_O){
                return i;
            }
        }
        return -1;
    }

    //TODO g) create the int lastIndexOf(Object o_O) method that returns the last position in the data structure of the object o_O
    //TODO if exists, otherwise return -1

    public int lastIndexOf(Object o_O){
        for(int i = size; i>=0; i--){
            if(elementData[i] == o_O){
                return i;
            }
        }
        return -1;
    }

    //TODO h) create the E get(int index) method that returns the object from the given index
    //TODO pay attention to the size property

    public E get(int index) throws CastException {
        if(index>=size || index<0)
            return null;
        try {
            return (E) elementData[index];
        } catch(Exception e) {
            throw new CastException("Nu se face Castul!!!");
        }
    }

    //TODO i) create the E set(int index, E element) method that updates the value of the element from the given index
    //TODO pay attention to the size property

    public E set(int index, E element)throws CastException{
        if(index>=size || index<0) {
            return null;
        }
        elementData[index] = element;
        try {
            return (E) elementData[index];
        } catch(Exception e){
            throw new CastException("Nu se face Castul!!!!!!");
        }
    }

    //TODO j) create the E remove(int index) method that removes the element from the given index

    public E remove(int index){
        E oldValue = (E) elementData[index];

        for(int i = index; i<size-1;i++){
            elementData[i] = elementData[i+1];
        }
        size--;
        elementData[size] = null;
        return oldValue;
    }

    //TODO k) extend the current default capacity, if the number of elements in the data structure is > 75% of it
    //TODO you should name it: void extendCapacity(int capacity) - HINT use capacity, DEFAULT_CAPACITY, LOAD_FACTOR and INCREASE_SIZE_FACTOR

    public void extendCapacity(int capacity){
        capacityAfterExtending = capacity * INCREASE_SIZE_FACTOR;
    }

    //TODO l) implement the iterator() method in order to use the foreach statement over your data structure - HINT Iterable interface
    //TODO and implement a custom iterator for your custom data structure - methods boolean hasNext(), Object next() and void remove()

    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {

            private int currentIndex = 0;


            public boolean hasNext() {
                return currentIndex < size;
            }


            public E next(){

                return (E)elementData[++currentIndex];

            }


            public void remove() {
                currentIndex--;
                MyImplementedList.this.remove(currentIndex);

            }
        };
        return it;
    }

    //TODO m) implement a method, that uses a Comparator, for your data structure to sort the elements
    //TODO you should name it: void sort(Comparator<? super E> c)
    //TODO create a custom comparator that compares objects by their "what you want" :D - HINT Comparator interface

    public void sort(Comparator<? super E> c){

    }


}
