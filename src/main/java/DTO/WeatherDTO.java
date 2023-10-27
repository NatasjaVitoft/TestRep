package DTO;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class WeatherDTO {
    private String LocationName;
    private CurrentDataDTO CurrentData;

    @Override
    public String toString() {
        return "WeatherDTO(locationName=" + LocationName + ", temperature=" + CurrentData.getTemperature() + ", forecastText=" + CurrentData.getSkyText() + ", humidity=" + CurrentData.getHumidity() + ", windText=" + CurrentData.getWindText() + ")";
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class CurrentDataDTO {
        private String temperature;
        private String skyText;
        private String humidity;
        private String windText;
    }
}

