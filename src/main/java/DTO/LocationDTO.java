package DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LocationDTO {

    private String navn;
    private String href;

    private String nr;

    @Override
    public String toString() {
        return "LocationDTO(navn=" + navn + ", href=" + href + ")";
    }
}