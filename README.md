# map-search
Sample map search application using GeoNames and Google Map API.

Version 0.0.1-SNAPSHOT

Currently supports only city/village search.

Built on:
1. Spring Boot 
2. Vaadin

Avaliable application properties:
1. geonames.account MANDATORY
2. google.api.key   MANDATORY

if google.api.key is empty, application will start, but map will not work and be displayed in DEV mode

3. search.max.rows OPTIONAL

Default value is 20. Note grid page size is not added yet.

Build executable jar:
mvn clean install

Execution:
java -Dgeonames.account=YOUR_GEONAMES_ACCOUNT -Dgoogle.api.key=YOUR_GOOGLE_API_KEY -jar map-search-version.jar

After application start visit http://localhost:8080/search

For more information see:
https://www.geonames.org/manual.html#account
https://developers.google.com/maps/documentation/javascript/get-api-key
