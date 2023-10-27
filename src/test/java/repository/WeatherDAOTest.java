package repository;

import config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import model.LocationEntity;
import model.WatherDTOtoEntity;
import model.WeatherEntity;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class WeatherDAOTest {
    private static EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();
    private static WeatherDAO weatherDAO;

    @BeforeAll
   static void setUp() { weatherDAO = WeatherDAO.getInstance();
    }

    @AfterAll
    static void tearDown() { emf.close();
    }

    @Test
    void getInstance() {
        WeatherDAO weatherDAO1 = WeatherDAO.getInstance();
        assertNotNull(weatherDAO1);
        assertEquals(weatherDAO1, weatherDAO);
    }

    @Test
    void createWeather() {
        WeatherEntity testWeatherEntity = new WeatherEntity();
        WeatherEntity weatherEntity = weatherDAO.createWeather(testWeatherEntity);
        assertNotNull(weatherEntity);
        assertTrue(weatherEntity.getId()>0);
    }

    @Test
    void readWeather() {
        WeatherEntity testWeatherEntity = new WeatherEntity();
        WeatherEntity weatherEntity = weatherDAO.createWeather(testWeatherEntity);
        WeatherEntity readWeather = weatherDAO.readWeather((long) weatherEntity.getId());
        assertNotNull(readWeather);
        assertEquals(testWeatherEntity.getId(), readWeather.getId());
    }


    @Test
    void deleteWeather() {
        WeatherEntity testWeatherEntity = new WeatherEntity();
        WeatherEntity weatherEntity = weatherDAO.createWeather(testWeatherEntity);
        weatherDAO.deleteWeather((long) weatherEntity.getId());
        WeatherEntity readWeather= weatherDAO.readWeather((long) weatherEntity.getId());
        assertNull(readWeather);
    }
}