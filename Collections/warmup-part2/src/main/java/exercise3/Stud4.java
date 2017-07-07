package exercise3;

/**
 * Created by Alexandru.Vlad on 7/7/2017.
 */
public class Stud4 extends Student{
    public Stud4(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = firstName.hashCode() + lastName.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student st = (Student) o;
        if (!firstName.equals(st.firstName) && lastName.equals(st.lastName)) return false;
        return true;
    }

    @Override
    public String toString(){
        String s ="First Name = " + this.firstName + ", Last Name = " + this.lastName + ";";
        return s;
    }
}
