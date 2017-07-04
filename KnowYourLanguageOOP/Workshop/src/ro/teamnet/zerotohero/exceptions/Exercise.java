package ro.teamnet.zerotohero.exceptions;

/**
 * Created by Alexandru.Vlad on 7/4/2017.
 */
public class Exercise {

    private int x;

    public Exercise() {
        this.x = 6;
    }

    public int except() throws MyException{
        throw new MyException("Nu suna bine!!!!");

    }

}
