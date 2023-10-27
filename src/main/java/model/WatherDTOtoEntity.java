package model;

import DTO.WeatherDTO;

public class WatherDTOtoEntity {

    public static WeatherEntity weatherDTOtoEntity(WeatherDTO weatherDTO) {
        WeatherEntity weatherEntity = new WeatherEntity();
        weatherEntity.setLocationName(weatherDTO.getLocationName());
        weatherEntity.setTemperature(weatherDTO.getCurrentData().getTemperature());
        weatherEntity.setForecastText(weatherDTO.getCurrentData().getSkyText());
        weatherEntity.setHumidity(weatherDTO.getCurrentData().getHumidity());
        weatherEntity.setWindText(weatherDTO.getCurrentData().getWindText());
        return weatherEntity;
    }
}
