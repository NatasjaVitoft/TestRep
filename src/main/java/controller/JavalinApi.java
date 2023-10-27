package controller;

import io.javalin.Javalin;
import model.WatherDTOtoEntity;
import model.WeatherEntity;
import repository.WeatherDAO;

import java.util.List;

public class JavalinApi {
    public static void main(String[] args) {

        WeatherDAO weatherDAO = WeatherDAO.getInstance();

        WeatherEntity w1 = WatherDTOtoEntity.weatherDTOtoEntity(ApiReader.apiGet("Roskilde"));
        WeatherEntity w2 =WatherDTOtoEntity.weatherDTOtoEntity(ApiReader.apiGet("Hillerød"));
        WeatherEntity w3 =WatherDTOtoEntity.weatherDTOtoEntity(ApiReader.apiGet("Albertslund"));
        WeatherEntity w4 =WatherDTOtoEntity.weatherDTOtoEntity(ApiReader.apiGet("Amager"));

        weatherDAO.createWeather(w1);
        weatherDAO.createWeather(w2);
        weatherDAO.createWeather(w3);
        weatherDAO.createWeather(w4);


        var app = Javalin.create().start(7500);

        //ctx står for context og er endpoint handlers i javalin - se: https://javalin.io/documentation#getting-started

        //med GET sender jeg data til klienten
        app.get("/", ctx -> ctx.result("Hello World! forntpage of app"));

        app.get("/api/weather", ctx -> {
            try {
                List<WeatherEntity> weatherEntityList = weatherDAO.readAllWeather();
                ctx.json(weatherEntityList.toString());
            } catch (Exception e) {
                ctx.status(500).result(e.getMessage());
            }
        });

        //med POST modtager jeg data fra klienten
        app.post("/api/weather", ctx -> {
            try {
                // Convert incoming request body to WeatherEntity
                WeatherEntity weatherEntity = ctx.bodyAsClass(WeatherEntity.class);

                // Use the DAO instance to persist the entity
                weatherDAO.createWeather(weatherEntity);

                // Return status 201 (Created)
                ctx.status(201);    
            } catch (Exception e) {
                // Handle any potential exceptions
                ctx.status(500).result(e.getMessage());
            }
        });


    }
}
