package ro.teamnet.zerotohero.exceptions;

import javax.crypto.ExemptionMechanism;
import java.rmi.server.ExportException;
import java.util.concurrent.ExecutionException;

/**
 * Created by Alexandru.Vlad on 7/4/2017.
 */
public class Useall {

    public void use(int a, int b) throws MyException{
        try{
            System.out.println(a+b);
        }
        catch(Exception e){
            throw new MyException("Nu au ajuns numerele!!");
        }
        finally {
            System.out.println(a*b);
        }
    }

    public void use2(int a, int b){
        try{
            System.out.println(a+b);
        }
        finally {
            System.out.println(a*b);
        }
    }

    public void use3(int a, int b) throws MyException{
        try{
            System.out.println(a/b);
        }catch(ArithmeticException e){
            System.out.println("Nu merge pentru ca!");
        }
        catch(NullPointerException e){
            System.out.println("Nu merge nici aici!");
        }
        catch(RuntimeException e){
            System.out.println("Nu e bine nici asa!!!!");
        }
    }

    public void use4(int a, int b) throws Exception{
        try{
            System.out.println(a/b);
        }
        catch( NumberFormatException | ArithmeticException  e) {
            System.out.println("Nu merge nici aici!");
        }
    }

}
