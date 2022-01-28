package com.tutorials.springTutorial.beans;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI basic() {
        var info = new Info();
        info.setDescription("Demo For springdoc");
        info.setTitle("TechSymphosium");
        info.setVersion("V1");


        var securityScheme = new SecurityScheme();
        securityScheme.setName("userAuthScheme");
        securityScheme.setDescription("User Authentication");
        securityScheme.setIn(SecurityScheme.In.HEADER);
        securityScheme.setType(SecurityScheme.Type.HTTP);
        securityScheme.setScheme("basic");
        return new OpenAPI().info(info).components(new Components().addSecuritySchemes("userAuthScheme", securityScheme));
    }

    @Bean
    public GroupedOpenApi admin(){
        return GroupedOpenApi
                .builder()
                .group("AdminApi")
                .pathsToMatch("/adminApis/**")
                .build();
    }

    @Bean
    public GroupedOpenApi users(){
        return GroupedOpenApi
                .builder()
                .group("UsersApi")
                .pathsToMatch("/users/**")
                .build();
    }
}
