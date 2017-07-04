package ro.teamnet.zerotohero.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.Buffer;

/**
 * Created by Alexandru.Vlad on 7/4/2017.
 */
public class Resources {

    public void res(String path) throws MyException{
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));

        }
        catch(Exception e){
            throw new MyException("Nu s-a gasit fisierul!!");
        }
    }

}
