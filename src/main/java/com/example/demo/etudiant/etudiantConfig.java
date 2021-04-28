package com.example.demo.etudiant;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class etudiantConfig {
    @Bean
    CommandLineRunner commandLineRunner(etudiantRepository etudiantRepository){
        return args -> {
                etudiant mariam = new etudiant(
                        "maryam",
                        "habili",
                        LocalDate.of(2000, Month.APRIL,6)
                );

            etudiant mohamed = new etudiant(
                    "mohamed",
                    "ait",
                    LocalDate.of(1994, Month.JUNE,16)
            );
            etudiantRepository.saveAll(List.of(mariam,mohamed));
        };
    }
}
