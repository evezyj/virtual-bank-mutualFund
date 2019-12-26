package com.virtualBank.investment.mutualFund.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket getMyDocket(){
        return new Docket((DocumentationType.SWAGGER_2))
                .apiInfo(getApiInfo())
                .groupName("MutualFund")
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.virtualBank.investment.mutualFund.controller"))
                .build();
    }
    private ApiInfo getApiInfo(){
        Contact contact = new Contact("Jenny","","2571706435@qq.com");
        return new ApiInfo("MutualFund API Documentation",
                "Investment MutualFund API Documentation",
                "V1.0",
                "http://18.216.128.62",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
