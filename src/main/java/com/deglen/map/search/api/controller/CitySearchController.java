package com.deglen.map.search.api.controller;

import com.deglen.map.search.api.dto.SearchDto;

public interface CitySearchController {

    SearchDto getCities(String filter);
    
}
