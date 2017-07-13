package ro.teamnet.zth.api.em;

import org.junit.Test;
import ro.teamnet.zth.appl.domain.Department;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Alexandru.Vlad on 7/13/2017.
 */
public class EntityManagerTest {

    @Test
    public void findByIdTest() {
        EntityManagerImpl manager = new EntityManagerImpl();

        Department department = manager.findById(Department.class,10L);

        assertEquals(department.getDepartmentName(),"Administration");

    }

    @Test
    public void nextIdValTest(){

        EntityManagerImpl manager = new EntityManagerImpl();

        Long result = null;

        result = manager.getNextIdVal("Departments","department_id");

        System.out.println(result);

        assertFalse(result==null);
    }

    @Test
    public void insertTest(){
        EntityManagerImpl mgn = new EntityManagerImpl();
        Department nou = new Department();
        nou.setDepartmentName("Piroman");
        nou.setLocation(1700L);
        Department dep = (Department) mgn.insert(nou);

        assertFalse(dep==null);

    }

    @Test
    public void findAllTest(){
        EntityManagerImpl mgn = new EntityManagerImpl();
        List<Department> dep = mgn.findAll(Department.class);
        assertEquals(dep.get(0).getDepartmentName(),"Administration");
    }

}
