package com.proyecto.ejercicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.proyecto.ejercicio.infrastructure.output.repository")
public class EjercicioApplication {
    public static void main(String[] args) {
        SpringApplication.run(EjercicioApplication.class, args);
    }
}
