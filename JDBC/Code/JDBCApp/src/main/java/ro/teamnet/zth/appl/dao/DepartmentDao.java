package ro.teamnet.zth.appl.dao;

import ro.teamnet.zth.api.em.EntityManager;
import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.appl.domain.Department;

import java.util.List;
import java.util.Map;

/**
 * Created by Alexandru.Vlad on 7/14/2017.
 */
public class DepartmentDao {

    EntityManager mgn = new EntityManagerImpl();

    public <Department> Department findById(Class<Department> entityClass, Long id) {
        return mgn.findById(entityClass,id);
    }

    public <Department> Object insert(Department entity) {
        return mgn.insert(entity);
    }

    public <Department> List<Department> findAll(Class<Department> entityClass) {
        return mgn.findAll(entityClass);
    }

    public <Department> Department update(Department entity) {
        return mgn.update(entity);
    }

    public <Department> List<Department> findByParams(Class<Department> entityClass, Map<String, Object> params){
        return mgn.findByParams(entityClass,params);
    }

}
