package ro.teamnet.zerotohero.exceptions;

/**
 * Created by Alexandru.Vlad on 7/4/2017.
 */
public class NestedException {

    public void nested(int a) throws MyException{
        try{
            System.out.println(a/0);
        }catch(Exception e){
            if(a>3){
                throw new MyException("Nu e bine!!!!!");
            } else {
                throw new MyException("Tot nu e bine!!!");
            }
        }
    }

}
