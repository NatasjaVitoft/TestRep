package DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class YrWeatherDTO {
    private CurrentDataDTO currentData;

    public void setTemperature(String temperature) {
        if (currentData == null) {
            currentData = new CurrentDataDTO();
        }
        currentData.setTemperature(temperature);
    }

    @Override
    public String toString() {
        return "WeatherDTO(temperature=" + (currentData != null ? currentData.getTemperature() : "null") + ")";
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class CurrentDataDTO {
        private String temperature;
    }
}
