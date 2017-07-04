package ro.teamnet.zerotohero.oop.graphicsshape;

/**
 * Created by Alexandru.Vlad on 7/4/2017.
 */
public class Square extends Shape{
    private int side;

    public Square() {
        this.side = 4;
    }

    public Square(int side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side*side;
    }
}
