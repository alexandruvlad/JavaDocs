package ro.teamnet.zth.appl;

import org.junit.Test;
import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.appl.dao.DepartmentDao;
import ro.teamnet.zth.appl.dao.LocationDao;
import ro.teamnet.zth.appl.domain.Department;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by Alexandru.Vlad on 7/14/2017.
 */
public class EntityDaoTest {

    @Test
    public void findByIdTest() {
        DepartmentDao mgn = new DepartmentDao();

        Department department = mgn.findById(Department.class,10L);

        assertEquals(department.getDepartmentName(),"Administration");

    }

    @Test
    public void insertTest(){
        DepartmentDao mgn = new DepartmentDao();
        Department nou = new Department();
        nou.setDepartmentName("Piroman");
        nou.setLocation(1700L);
        Department dep = (Department) mgn.insert(nou);

        assertEquals(dep.getDepartmentName(),"Piroman");

    }


    @Test
    public void findAllTest(){
        DepartmentDao mgn = new DepartmentDao();
        List<Department> dep = mgn.findAll(Department.class);
        assertEquals(dep.get(0).getDepartmentName(),"Administration");
    }


    @Test
    public void updateTest(){
        DepartmentDao mgn = new DepartmentDao();
        Department dep = new Department();
        dep.setLocation(2000L);
        dep.setDepartmentName("Blablablac");
        dep.setId(20L);
        Department d = mgn.update(dep);

        assertEquals(d.getDepartmentName(),"Blablablac");

    }



    @Test
    public void findByParamsTest() {
        DepartmentDao mgn = new DepartmentDao();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("location_id", 1400L);
        params.put("department_id", 60L);
//        params.put("department_id",30L);

        List<Department> depList = mgn.findByParams(Department.class, params);
        assertEquals(depList.size(), 1);
    }

    @Test
    public void findByIdTest2() {
        LocationDao mgn = new LocationDao();

        Department department = mgn.findById(Department.class,10L);

        assertEquals(department.getDepartmentName(),"Administration");

    }

    @Test
    public void insertTest2(){
        LocationDao mgn = new LocationDao();
        Department nou = new Department();
        nou.setDepartmentName("Piroman");
        nou.setLocation(1700L);
        Department dep = (Department) mgn.insert(nou);

        assertEquals(dep.getDepartmentName(),"Piroman");

    }


    @Test
    public void findAllTest2(){
        LocationDao mgn = new LocationDao();
        List<Department> dep = mgn.findAll(Department.class);
        assertEquals(dep.get(0).getDepartmentName(),"Administration");
    }

    @Test
    public void updateTest2(){
        LocationDao mgn = new LocationDao();
        Department dep = new Department();
        dep.setLocation(2000L);
        dep.setDepartmentName("Blablablac");
        dep.setId(20L);
        Department d = mgn.update(dep);

        assertEquals(d.getDepartmentName(),"Blablablac");

    }


    @Test
    public void findByParamsTest2() {
        LocationDao mgn = new LocationDao();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("location_id", 1400L);
        params.put("department_id", 60L);
//        params.put("department_id",30L);

        List<Department> depList = mgn.findByParams(Department.class, params);
        assertEquals(depList.size(), 1);
    }
}
