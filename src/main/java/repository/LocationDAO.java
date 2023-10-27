package repository;

import config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import model.LocationEntity;

import java.util.List;

public class LocationDAO {

    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();
    private static LocationDAO locationDAO = null;
    private LocationDAO() {}

    public static LocationDAO getInstance() {
        if (locationDAO == null) {
            locationDAO = new LocationDAO();
        }
        return locationDAO;
    }

    public LocationEntity createLocation(LocationEntity location) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(location);
            em.getTransaction().commit();
            em.close();
            return location;
        }
    }

    public LocationEntity readLocation(Long locationID){
        try(EntityManager em = emf.createEntityManager()){
            LocationEntity locationEntity = em.find(LocationEntity.class, locationID);
            return locationEntity;
        }
    }

    public LocationEntity updateLocation(LocationEntity location){
        try (EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            LocationEntity locationEntity = em.merge(location);
            em.getTransaction().commit();
            em.close();
            return locationEntity;
        }
    }

    public void deleteLocation(Long locationID) {
        try(EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            LocationEntity locationEntity = readLocation(locationID);
            if(locationID != null){
                em.remove(locationEntity);
            }
            em.getTransaction().commit();
        }
    }

    public List<LocationEntity> readAllLocations () {
        try (EntityManager em = emf.createEntityManager()) {
            List<LocationEntity> locationEntities = em.createQuery("SELECT l FROM LocationEntity l", LocationEntity.class).getResultList();
            return locationEntities;
        }
    }
}
