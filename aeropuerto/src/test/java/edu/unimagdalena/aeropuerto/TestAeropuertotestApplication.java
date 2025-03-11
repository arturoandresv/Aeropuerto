package edu.unimagdalena.aeropuerto;

import org.springframework.boot.SpringApplication;

public class TestAeropuertotestApplication {

    public static void main(String[] args) {
        SpringApplication.from(AeropuertotestApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
