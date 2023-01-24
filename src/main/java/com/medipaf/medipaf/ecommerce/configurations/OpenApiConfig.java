package com.medipaf.medipaf.ecommerce.configurations;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;

import java.util.List;

/*
    You can customise the security, when you need it look for it. It means that is swagger
    interface you can use it util you authenticate
 */

/*
    Also you can categorise the packages controllers, I mean in big projects you have a lot of
    controllers in this case you have to categorise things like that it will be easy for working
 */

/*
    There are many things to do with openApi or swagger3, that all what I need for now,
    when I'll in a big project than I will fall in problems that will let me looking for solutions,
    but you can look at for advanced features in books and videos like that you will have an Idea
    about what openApi or swagger3 contains.
*/
@Configuration
@OpenAPIDefinition()
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("Website Ecommerce REST API")
                        .description("Website Ecommerce API documentation")
                        .contact(getContact())
                )
                .servers(List.of(new Server().url("http://localhost:9090")));
    }

    @Bean
    public GroupedOpenApi stockGroup(){
        String packagesToscan[]={"com.medipaf.medipaf.ecommerce.Controller" ,
        };
        return GroupedOpenApi.builder()
                .group("Ecommerce Stock Mangement")
                .packagesToScan(packagesToscan)
                .addOperationCustomizer(appTokenHeaderParam())
                .build();
    }

    @Bean
    public GroupedOpenApi usersGroup(){
        String packagesToscan[]={"com.medipaf.medipaf.ecommerce.users.Controller"};
        return GroupedOpenApi.builder()
                .group("Ecommerce Users Mangement")
                .packagesToScan(packagesToscan)
                .addOperationCustomizer(appTokenHeaderParam())
                .build();
    }
    Contact getContact(){
        Contact contact= new Contact();
        contact.setEmail("rachidbenkitou1@gmail.com");
        contact.setName("Rachid Benkitou");
        contact.setUrl("https://github.com/rachidbenkitou");
        return contact;
    }

    @Bean
    public OperationCustomizer appTokenHeaderParam(){

        return (Operation operation, HandlerMethod handlerMethod) ->{
            Parameter headerParameter= new Parameter().in(ParameterIn.HEADER.toString()).required(false).
                    schema(new StringSchema()._default("app_token_header_value")).name("app_token_header").description("App Token Header");
            operation.addParametersItem(headerParameter);
            return operation;
        };
    }

}
