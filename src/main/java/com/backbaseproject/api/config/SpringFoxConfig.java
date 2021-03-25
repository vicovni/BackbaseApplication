package com.backbaseproject.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Api(value = "Swagger configuration", description = "Backbase API")
@ApiModel
@Configuration
@EnableSwagger2
public class SpringFoxConfig {   
	
	@ApiModelProperty("Product API method")
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.backbaseproject.api"))
            .paths(PathSelectors.regex("/v1.*"))
            .build();
    }
}