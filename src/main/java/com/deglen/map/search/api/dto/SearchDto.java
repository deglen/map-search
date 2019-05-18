package com.deglen.map.search.api.dto;

import java.util.List;

public interface SearchDto {

    Long getTotalResultsCount();

    List<EntityDto> getEntities();

}
