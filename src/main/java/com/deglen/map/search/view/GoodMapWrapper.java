package com.deglen.map.search.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;

@Tag("good-map")
@HtmlImport("bower_components/good-map/good-map.html")
public class GoodMapWrapper extends Component {

    /**
     * 
     */
    private static final long serialVersionUID = -5613074642242915513L;
    
    public GoodMapWrapper(String apiKey) {
        getElement().setAttribute("api-key", apiKey);
    }
    
    public void setLatitude(double lat) {
        getElement().setAttribute("latitude", lat + "");
    }

    public void setLongitude(double lon) {
        getElement().setAttribute("longitude", lon + "");
    }
    
    public double getLatitude() {
        return Double.valueOf(getElement().getAttribute("latitude"));
    }
     
    
    public double getLongitude() {
        return Double.valueOf(getElement().getAttribute("longitude"));
    }
    
    public void setZoom(int zoom) {
        getElement().setAttribute("zoom", zoom + "");
    }

    public void setMapOptions(String options) {
        getElement().setAttribute("map-options", options);
    }
    
    
}
