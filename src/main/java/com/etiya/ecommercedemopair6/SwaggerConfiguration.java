package com.etiya.ecommercedemopair6;

import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OperationCustomizer customGlobalHaders(){
    return  (Operation operation , HandlerMethod handlerMethod)-> {
        Parameter headerParameter = new Parameter()
                .in(ParameterIn.HEADER.toString())
                .schema(new StringSchema())
                .name("Accept-Language")
                .description("Multi Language Properties.")
                .required(false);
        operation.addParametersItem(headerParameter);
        return operation;
      };
    }
}
