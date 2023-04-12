package com.example.projectmanagerapp.config;

//http://localhost:8080/swagger-ui.html
//http://localhost:8080/v3/api-docs

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "basicAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "basic"
)
@OpenAPIDefinition(
        info = @Info(
                title = "REST API documentation",
                version = "1.0",
                description = "Веб - приложение \"проектный менеджер\".<br>" +
                        "<br> Логин: <b>admin</b>  Пароль: <b>password</b> " +
                        "<br>Логин: <b>user</b>  Пароль: <b>password</b>" +
                        "<br>В базу добавлены тестовые данные",
                contact = @Contact(url = "https://github.com/nikita-1100", name = "Dolbilov Nikita", email = "nikita11001100@gmail.com")
        ),
        security = @SecurityRequirement(name = "basicAuth")
)
public class OpenApiConfig {

}