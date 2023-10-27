package model;

import DTO.LocationDTO;

public class LocationDTOtoEntity {

    public static LocationEntity locationDTOtoEntity(LocationDTO locationDTO) {

        LocationEntity locationEntity = new LocationEntity();
        locationEntity.setNavn(locationDTO.getNavn());
        locationEntity.setHref(locationDTO.getHref());
        locationEntity.setNr(locationDTO.getNr());
        return locationEntity;
    }
}