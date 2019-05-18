package com.deglen.map.search.dto;

import com.deglen.map.search.api.dto.EntityDto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class GNEntitySearchDto implements EntityDto {

    private String adminCode1;
    private double lng;
    private String geonameId;
    private String toponymName;
    private String countryId;
    private String fcl;
    private Long population;
    private String countryCode;
    private String name;
    private String fclName;
    private String countryName;
    private String fcodeName;
    private String adminName1;
    private double lat;
    private String fcode;

    @Override
    public String getCountry() {
        return this.countryName;
    }

    @Override
    public double getLatitude() {
        return lat;
    }

    @Override
    public double getLongitude() {
        return lng;
    }
}
