package com.sena.crud_basic.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("CRUD Basic Store API")
                        .version("1.0.0")
                        .description("API REST para gestión de tienda online con CRUD completo de productos, clientes, pedidos, pagos, reseñas y más.")
                        
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html")))
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8085")
                                .description("Servidor de desarrollo"),
                        new Server()
                                .url("https://api.ejemplo.com")
                                .description("Servidor de producción")
                ));
    }
}
