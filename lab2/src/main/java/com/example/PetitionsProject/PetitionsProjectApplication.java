package com.example.PetitionsProject;

import com.example.PetitionsProject.repository.PetitionRepository;
import com.example.PetitionsProject.service.PetitionService;
import com.example.PetitionsProject.service.impl.PetitionServiceImplementation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class PetitionsProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(PetitionsProjectApplication.class, args);
	}
	@Bean
	@Scope("singleton")
	public PetitionService petitionServiceSingleton(PetitionRepository petitionRepository) {
		return new PetitionServiceImplementation(petitionRepository);
	}

	@Bean
	@Primary
	@Scope("prototype")
	public PetitionService petitionServicePrototype(PetitionRepository petitionRepository) {
		return new PetitionServiceImplementation(petitionRepository);
	}

}
