package com.deglen.map.search.api.service;

import com.deglen.map.search.api.dto.SearchDto;

public interface CitySearchService {

    SearchDto getCities(String filter);
    
}
