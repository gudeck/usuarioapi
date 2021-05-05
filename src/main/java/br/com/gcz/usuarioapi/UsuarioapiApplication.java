package br.com.gcz.usuarioapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableFeignClients
@EnableSwagger2
public class UsuarioapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsuarioapiApplication.class, args);
    }

}
