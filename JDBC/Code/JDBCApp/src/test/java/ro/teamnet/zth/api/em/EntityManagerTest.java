package ro.teamnet.zth.api.em;

import org.junit.Test;
import ro.teamnet.zth.appl.domain.Department;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        assertEquals(dep.getDepartmentName(),"Piroman");
        assertEquals((Object)dep.getId(),300L);

    }

    @Test
    public void findAllTest(){
        EntityManagerImpl mgn = new EntityManagerImpl();
        List<Department> dep = mgn.findAll(Department.class);
        assertEquals(dep.get(0).getDepartmentName(),"Administration");
    }

    @Test
    public void updateTest(){
        EntityManagerImpl mgn = new EntityManagerImpl();
        Department dep = new Department();
        dep.setLocation(2000L);
        dep.setDepartmentName("Blablablac");
        dep.setId(20L);
        Department d = mgn.update(dep);

        assertEquals(d.getDepartmentName(),"Blablablac");

    }

    @Test
    public void deleteTest(){
        EntityManagerImpl mgn = new EntityManagerImpl();
        Department dep = new Department();
        dep.setId(290L);
//        dep.setDepartmentName("Blablablac");
//        dep.setLocation(2000L);
        mgn.delete(dep);
        Department d = mgn.findById(Department.class,dep.getId());
        assertEquals(null,d);
    }

    @Test
    public void findByParamsTest(){
        EntityManagerImpl mgn = new EntityManagerImpl();
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("location_id",1400L);
        params.put("department_id",60L);
//        params.put("department_id",30L);

        List<Department> depList = mgn.findByParams(Department.class,params);
        assertEquals(depList.size(),1);
    }

}
