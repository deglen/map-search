package com.deglen.map.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.deglen.map.search")
public class MapSearchApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MapSearchApplication.class, args);
	}

}
