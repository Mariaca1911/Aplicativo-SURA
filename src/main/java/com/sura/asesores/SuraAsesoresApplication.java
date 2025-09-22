package com.sura.asesores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SuraAsesoresApplication {
    public static void main(String[] args) {
        SpringApplication.run(SuraAsesoresApplication.class, args);
        System.out.println("\n----------------------------------------------------------");
        System.out.println("  Sistema SURA Asesores iniciado");
        System.out.println("  Accede al frontend: http://localhost:8080/view/clientes");
        System.out.println("----------------------------------------------------------\n");
    }
}
