package ro.teamnet.zerotohero.oop.runapp;

import ro.teamnet.zerotohero.canvas.Canvas;
import ro.teamnet.zerotohero.oop.graphicsshape.*;
import ro.teamnet.zerotohero.exceptions.*;

/**
 * Created by Alexandru.Vlad on 7/4/2017.
 */
public class RunApp {
    public static void main(String[] args) throws Exception {
        Circles c = new Circles();
        System.out.println("aria cercului este:" + c.getAreaPub());

        c.getAreaDef();

        Canvas can = new Canvas();

        //can.paint();

        Shape sh = new Circle(10);
        System.out.println(sh.area()+"\n");

        ShapeBehaviour shbeh = new Square(10);
        System.out.println(shbeh.area()+"\n");

        Object p1 = new Point(10, 20);
        Object p2 = new Point(50, 100);
        Object p3 = new Point(10, 20);
        //Now if you type:
        System.out.println("p1 equals p2 is " + p1.equals(p2));
        System.out.println("p1 equals p3 is " + p1.equals(p3));

//        Exercise e = new Exercise();
//
//        e.except();

//        Propagation p = new Propagation();
//
//        p.metoda3(10,0);

//        NestedException n = new NestedException();
//
//        n.nested(2);
//        Resources r = new Resources();
//
//        r.res("text.txt");

        Useall u = new Useall();

//        u.use(4,5);
        u.use2(6,12);


    }
}
