package com.deglen.map.search.dto;

import java.util.Collections;
import java.util.List;

import com.deglen.map.search.api.dto.EntityDto;
import com.deglen.map.search.api.dto.SearchDto;

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
public class GNSearchDto implements SearchDto {

    private Long totalResultsCount;
    private List<GNEntitySearchDto> geonames;
    
    @Override
    public List<EntityDto> getEntities() {
        return Collections.unmodifiableList(geonames);
    }
    
}
