package exercise3;

/**
 * Created by Alexandru.Vlad on 7/7/2017.
 */
public class Stud extends Student{


    public Stud(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public int hashCode(){
        return firstName.hashCode();
    }

    @Override
    public boolean equals(Object o){
        if(this == o)   return true;
        if(o==null||getClass()!=o.getClass())    return false;
        Student st = (Student)o;
        if(!firstName.equals(st.firstName))   return false;
        return true;
    }
    @Override
    public String toString(){
        String s ="First Name = " + this.firstName + ", Last Name = " + this.lastName + ";";
        return s;
    }
}
