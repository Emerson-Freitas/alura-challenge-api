package br.com.alura.challenge.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .addServersItem(new Server().url("https://alura-challenge-api-production.up.railway.app"))
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                .info(new Info()
                        .title("API Vídeos")
                        .description("API Rest, contendo as funcionalidades de CRUD de vídeos e de categorias, além de muitos outros end-points")
                        .contact(new Contact()
                                .name("Emerson Freitas de Sousa")
                                .email("emerson_freitas@outlook.com.br"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://alura-challenge/api/licenca")));
    }

}
