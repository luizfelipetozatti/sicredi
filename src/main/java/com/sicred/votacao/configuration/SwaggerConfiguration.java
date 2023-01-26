package com.sicred.votacao.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public Docket docket10() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("votacao-api-1.0")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sicred.votacao.controller"))
                .paths(PathSelectors.regex(".*/v1.0.*"))
                .build()
                .apiInfo(new ApiInfoBuilder().version("1.0").title("Votacao API").description("Documentation Votacao API v1.0").build());
    }

    @Bean
    public Docket docket11() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("votacao-api-1.1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sicred.votacao.controller"))
                .paths(PathSelectors.regex(".*/v1.1.*"))
                .build()
                .apiInfo(new ApiInfoBuilder().version("1.1").title("Votacao API").description("Documentation Votacao API v1.1").build());
    }
}