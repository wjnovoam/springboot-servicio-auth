package com.wjnovoam.app.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients //Esta anotacion es importente para habilitar nuestros clientes feing, nos permite inyectar estos feing en los controladores
@SpringBootApplication
public class SpringbootServicioItemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootServicioItemApplication.class, args);
    }

}
