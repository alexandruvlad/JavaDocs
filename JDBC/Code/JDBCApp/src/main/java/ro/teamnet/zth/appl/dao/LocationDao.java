package ro.teamnet.zth.appl.dao;

import ro.teamnet.zth.api.em.EntityManager;
import ro.teamnet.zth.api.em.EntityManagerImpl;

import java.util.List;
import java.util.Map;

/**
 * Created by Alexandru.Vlad on 7/14/2017.
 */
public class LocationDao {

    EntityManager mgn = new EntityManagerImpl();

    public <Location> Location findById(Class<Location> entityClass, Long id) {
        return mgn.findById(entityClass,id);
    }

    public <Location> Object insert(Location entity) {
        return mgn.insert(entity);
    }

    public <Location> List<Location> findAll(Class<Location> entityClass) {
        return mgn.findAll(entityClass);
    }

    public <Location> Location update(Location entity) {
        return mgn.update(entity);
    }

    public <Location> List<Location> findByParams(Class<Location> entityClass, Map<String, Object> params){
        return mgn.findByParams(entityClass,params);
    }

}
