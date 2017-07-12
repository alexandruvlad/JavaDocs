package ro.teamnet.zerotohero.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * TODO
 * in order to resolve the exercises below, you will have to create
 * all the needed clasees, with their members and methods
 * (in ro.teamnet.zerotohero.reflection.demoobjects package)
 */

class ceva {
    int x = 10;

    public ceva(int x) {
        this.x = x;
    }
    public ceva() {
        this.x = 5;
    }
    public ceva(int x, int y) {
        this.x = x/y;
    }
}

class altceva extends ceva{
    String y = "lalalala";
    private int xyz = 20;
}

class altceva2 extends altceva{
    Boolean z = true;
}

class multiclass {
    class gri{
        int i = 10;
    }

    class maro {
        String j = "casa";
    }
}

public class ClassReflectionDemoMain {

    public enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
        THURSDAY, FRIDAY, SATURDAY
    }

    public static void main(String[] args) throws Exception{
        // get the class for a String object, and print it

        Class myClass = "ceva text".getClass();
        System.out.println(myClass);

        //get the class of an Enum, and print it


        Class myEnum = Day.MONDAY.getClass();
        System.out.println(myEnum);
        

        // get the class of a collection, and print it

        ArrayList array = new ArrayList(10);
        Class myCollection = array.getClass();
        System.out.println(myCollection);

        // get the class of a primitive type, and print it
        int a = 100;
        Class myPrimitive =Integer.valueOf(a).getClass();
        System.out.println(myPrimitive);

        // get and print the class for a field of primitive type
        ceva nou = new ceva();
        Class myFieldClass = null;
        int value = -20;
        Field f = nou.getClass().getDeclaredField("x");
        value = (int)f.get(nou);

        System.out.println(value);

        // get and print the class for a primitive type, using the wrapper class

        Class wrapp = Integer.TYPE;
        System.out.println(wrapp);

        // get the class for a specified class name

        Class myClassName = Class.forName("ro.teamnet.zerotohero.reflection.altceva");
        System.out.println(myClassName);

        // get the superclass of a class, and print it
        // get the superclass of the superclass above, and print it

        Class superClass = altceva.class.getSuperclass();
        System.out.println(superClass);
        Class supersuperClass = altceva2.class.getSuperclass();
        System.out.println(supersuperClass);


        //get and print the declared classes within some other class

        Class[] declaredClass = multiclass.class.getDeclaredClasses();
        for(Class i : declaredClass)
            System.out.println(i);

        //print the number of constructors of a class

        Constructor[] construct = ceva.class.getDeclaredConstructors();
        for(Constructor j : construct){
            System.out.println(j);
        }

        //get and invoke a public constructor of a class

        Constructor invokeconstr = ceva.class.getConstructor();
        Object z = invokeconstr.newInstance();
        System.out.println(z);

        //get and print the class of one private field

        Class privateField = altceva.class.getDeclaredField("xyz").getType();
        System.out.println(privateField);
		
		//set and print the value of one private field for an object

        ceva obj = new ceva();
        Field objField = obj.getClass().getDeclaredField("x");
        objField.setAccessible(true);
        objField.set(obj,234);
        System.out.println(objField.get(obj));

        //TODO get and print only the public fields class

        ceva cv = new ceva();



        //TODO get and invoke one public method of a class
        

        //TODO get and invoke one inherited method of a class
       
		
		//TODO invoke a method of a class the classic way for ten times, and print the timestamp (System.currentTimeMillis())
		//TODO invoke a method of a class by Reflection for 100 times, and print the timestamp
		//what do you observe?
		
    }
}
