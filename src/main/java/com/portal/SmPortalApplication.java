package com.portal;

import com.portal.model.AdvertisementType;
import com.portal.service.AdvertisementTypeService;
import com.portal.service.ProductTypeService;
import com.portal.service.SellingUnitService;
import com.portal.service.SouvenirService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SmPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmPortalApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(AdvertisementTypeService advertisementTypeService, SouvenirService souvenirService,
							 SellingUnitService sellingUnitService, ProductTypeService productTypeService) {
		return args -> {
			advertisementTypeService.create(new AdvertisementType(00001,"BASIC", "Basic Advertisments"));

		};
	}


}
