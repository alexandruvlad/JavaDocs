package ro.teamnet.zerotohero.oop.graphicsshape;
import java.lang.Math;

/**
 * Created by Alexandru.Vlad on 7/4/2017.
 */
public class Circle extends Shape{

    private int xPos, yPos, radius;
    static double pi = Math.PI;

    public Circle() {
        this.xPos = 3;
        this.yPos = 2;
        this.radius = 3;
    }

    public Circle(int xPos) {
        this.xPos = xPos;
        this.yPos = 2;
        this.radius = 3;
    }

    public Circle(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = 3;
    }

    public Circle(int xPos, int yPos, int radius) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;
    }

    @Override
    public double area() {
        return pi*radius*radius;
    }

    @Override
    public String toString() {
        String s = "center :("+xPos+","+yPos+") and radius = "+radius;
        return s;
    }

    public void fillColour(){
        System.out.println(super.getColor()+"\n");
    }

    public void fillColour(int param){
        super.setColor(param);
        System.out.println("The circle color is now " + param +"\n");

    }

    public void fillColour(float param){
        super.saturation = param;
        System.out.println("The circle saturation is now " + param+"\n");
    }


}
