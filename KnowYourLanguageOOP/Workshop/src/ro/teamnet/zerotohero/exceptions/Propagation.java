package ro.teamnet.zerotohero.exceptions;

/**
 * Created by Alexandru.Vlad on 7/4/2017.
 */
public class Propagation {

    public void metoda1(int a, int b){
        System.out.println(a/b);
    }

    public void metoda2(int a, int b){
        metoda1(a,b);
    }

    public void metoda3(int a,int b) throws Exception{
        try{
            metoda2(a,b);
        } catch(Exception e){
            System.out.println("Impartire imposibila!!!");
        }
    }


}
