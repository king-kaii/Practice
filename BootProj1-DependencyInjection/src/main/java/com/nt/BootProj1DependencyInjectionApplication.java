package com.nt;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.sbeans.SeasonFinder;

@SpringBootApplication
public class BootProj1DependencyInjectionApplication {
	
	@Bean(name="ld")
	public LocalDate createDate() {
		return LocalDate.now();
	}


	public static void main(String[] args) {
		// Create IOC Container
		ApplicationContext ctx = SpringApplication.run(BootProj1DependencyInjectionApplication.class, args);

		// Get Target Class Bean
		SeasonFinder finder =ctx.getBean("sf",SeasonFinder.class);
		
		//Invoke The b.logic
		String seasonName=finder.seasonFinder();
		
		//Display the Current Season name
		System.out.println("SeasonName:"+seasonName);
		
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}

}
