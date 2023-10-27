import DTO.YrWeatherDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class WeatherScraping {

    private static final String WEATHER_URL = "https://www.yr.no/nb/v%C3%A6rvarsel/daglig-tabell/2-2618468/Danmark/Region%20Hovedstaden/Lyngby-T%C3%A5rb%C3%A6k/Kgs.%20Lyngby";
    private static final String TEMPERATURE_CSS_SELECTOR = "span.temperature.temperature--warm";

    public static YrWeatherDTO fetchWeatherData() throws IOException {
        Document document;

        try {
            document = Jsoup.connect(WEATHER_URL).get();
            Element temperatureElement = document.select(TEMPERATURE_CSS_SELECTOR).first();

            if (temperatureElement != null) {
                String temperatureText = temperatureElement.text();
                YrWeatherDTO yrWeatherDTO = new YrWeatherDTO();
                yrWeatherDTO.setTemperature(temperatureText);
                System.out.println(yrWeatherDTO);
                return yrWeatherDTO;
            } else {
                return null; // Temperature element not found, return null
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to fetch weather data", e);
        }
    }
}
