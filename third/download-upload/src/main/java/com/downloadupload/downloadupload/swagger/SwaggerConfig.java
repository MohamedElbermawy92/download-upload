package com.downloadupload.downloadupload.swagger;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@EnableSwagger2
@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {
    @Bean
    public Docket apiDocket() {

        Contact contact = new Contact("stc-task", "http://www.stc.com/", "mohamed.elbermawy92@gmail.com");

        List<VendorExtension> vendorExtensions = new ArrayList<>();

        ApiInfo apiInfo = new ApiInfo("download-upload Documentation", "This pages documents download and upload task endpoints", "1.0",
                "http://www.stc.com/", contact, "", "", vendorExtensions);

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.downloadupload.controller"))
                .paths(PathSelectors.any())
                .build();

        return docket;

    }
}
