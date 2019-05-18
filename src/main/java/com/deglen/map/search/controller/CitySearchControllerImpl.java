package com.deglen.map.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deglen.map.search.api.controller.CitySearchController;
import com.deglen.map.search.api.dto.SearchDto;
import com.deglen.map.search.api.service.CitySearchService;

@Component
public class CitySearchControllerImpl implements CitySearchController {

    @Autowired
    private CitySearchService citySearchService;

    @Override
    public SearchDto getCities(String filter) {
        return citySearchService.getCities(filter);
    }

}
