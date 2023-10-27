package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
@Setter

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class YrWeather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private String locationName;
    private String temperature;


}
