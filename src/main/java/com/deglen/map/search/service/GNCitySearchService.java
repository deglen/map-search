package com.deglen.map.search.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.deglen.map.search.api.service.CitySearchService;
import com.deglen.map.search.dto.GNSearchDto;

@Component
public class GNCitySearchService implements CitySearchService {

    @Value("${geonames.url}")
    private String geoNamesUrl;

    @Value("${search.max.rows}")
    private Long maxRows;

    @Value("${geonames.account}")
    private String geoNamesAccount;

    private RestOperations restOperations;

    public GNCitySearchService() {
        this.restOperations = new RestTemplate();
    }

    @Override
    public GNSearchDto getCities(String filter) {
        String url = buildUrl(filter);
        ResponseEntity<GNSearchDto> result = restOperations.getForEntity(url, GNSearchDto.class);
        return result.getBody();
    }

    private String buildUrl(String filter) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(geoNamesUrl);
        builder.path("?name_equals={filter}&maxRows={maxRows}&featureClass=P&username={account}");
        String url = builder.buildAndExpand(filter, maxRows, geoNamesAccount).toUriString();
        return url;
    }

}
