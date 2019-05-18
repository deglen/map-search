package com.deglen.map.search.view;

import org.springframework.beans.factory.annotation.Value;

import com.deglen.map.search.api.controller.CitySearchController;
import com.deglen.map.search.api.dto.EntityDto;
import com.deglen.map.search.api.dto.SearchDto;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

@StyleSheet("styles.css")
@Route("search")
public class CitySearchView extends VerticalLayout {

    /**
     * 
     */
    private static final long serialVersionUID = 5377344431955043154L;

    private static final int DEFAULT_ZOOM = 15;

    // controller, configuration
    private CitySearchController controller;
    private Long searchMaxRows;
    private String googleApiKey;

    // components
    private TextField filterText = new TextField();
    private Label totalResultCount = new Label();
    private Grid<EntityDto> grid = new Grid<>(EntityDto.class);
    private GoodMapWrapper goodMap;

    public CitySearchView(CitySearchController controller, @Value("${googe.api.key}") String googleApiKey,
            @Value("${search.max.rows}") Long searchMaxRows) {
        this.controller = controller;
        this.searchMaxRows = searchMaxRows;
        this.googleApiKey = googleApiKey;

        this.grid.setColumns("name", "country", "population");
        this.grid.setSizeFull();
        this.totalResultCount.setTitle("Total result count");

        this.configureSearch();

        HorizontalLayout header = new HorizontalLayout(this.filterText, this.totalResultCount);
        HorizontalLayout content = new HorizontalLayout(this.grid);
        content.setSizeFull();
        add(header, content);

        this.grid.addItemDoubleClickListener(event -> {
            EntityDto dto = event.getItem();
            addMap(content, dto);
        });

        setSizeFull();
    }

    private void addMap(HorizontalLayout content, EntityDto dto) {
        if (goodMap != null) {
            content.remove(goodMap);
        }
        goodMap = new GoodMapWrapper(this.googleApiKey);
        goodMap.setMapOptions("{\"mapTypeId\": \"satellite\"}");
        goodMap.setZoom(DEFAULT_ZOOM);
        goodMap.setLatitude(dto.getLatitude());
        goodMap.setLongitude(dto.getLongitude());
        content.add(goodMap);
    }

    private void configureSearch() {
        this.filterText.setPlaceholder("Filter by city name...");
        this.filterText.setClearButtonVisible(true);

        this.filterText.setValueChangeMode(ValueChangeMode.ON_CHANGE);
        this.filterText.addValueChangeListener(e -> search(this.filterText.getValue()));
    }

    private void search(String text) {
        SearchDto result = this.controller.getCities(text);
        String label = String.format("Total result count %d, displayed max up to %d entries.",
                result.getTotalResultsCount(), this.searchMaxRows);
        this.totalResultCount.setText(label);
        this.grid.setItems(result.getEntities());
    }

}
