package com.iswar.usercrud.Swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "User Crud",
                description = "Basic crud operation in the User",
                contact = @Contact(
                        name = "iswar",
                        email = "iswar@zessta.com"
                ),
                version = "v1"
        )
)
public class OpenApiConfig {

}
