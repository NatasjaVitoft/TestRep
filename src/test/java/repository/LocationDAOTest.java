package repository;

import config.HibernateConfig;
import jakarta.persistence.EntityManagerFactory;
import model.LocationEntity;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationDAOTest {

    private static EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();
    private static LocationDAO locationDAO;

    @BeforeAll
    static void setUp() {
        locationDAO = LocationDAO.getInstance();
    }

    @AfterAll
    static void tearDown() {
        emf.close();
    }

    @Test
    void getInstance() {
        LocationDAO locationDAO1 = LocationDAO.getInstance();
        assertNotNull(locationDAO1);
        assertEquals(locationDAO1, locationDAO);
    }


    @Test
    void createLocation() {
        LocationEntity testLocationEntity = new LocationEntity();
        LocationEntity locationEntity = locationDAO.createLocation(testLocationEntity);
        assertNotNull(locationEntity);
        assertTrue(locationEntity.getId()>0);
    }

    @Test
    void readLocation() {
        LocationEntity testLocationEntity = new LocationEntity();
        LocationEntity locationEntity = locationDAO.createLocation(testLocationEntity);
        LocationEntity readLocation = locationDAO.readLocation((long) locationEntity.getId());
        assertNotNull(readLocation);
        assertEquals(testLocationEntity.getId(), readLocation.getId());
    }

    @Test
    void deleteLocation() {
        LocationEntity testLocationEntity = new LocationEntity();
        LocationEntity locationEntity = locationDAO.createLocation(testLocationEntity);
        locationDAO.deleteLocation((long) locationEntity.getId());
        LocationEntity readLocation = locationDAO.readLocation((long) locationEntity.getId());
        assertNull(readLocation);
    }

    @Test
    void readAllLocations() {
        LocationEntity testLocationEntity = new LocationEntity();
        LocationEntity locationEntity = locationDAO.createLocation(testLocationEntity);
        LocationEntity testLocationEntity2 = new LocationEntity();
        LocationEntity locationEntity2 = locationDAO.createLocation(testLocationEntity2);
        LocationEntity testLocationEntity3 = new LocationEntity();
        LocationEntity locationEntity3 = locationDAO.createLocation(testLocationEntity3);
        assertEquals(3, locationDAO.readAllLocations().size());
    }
}