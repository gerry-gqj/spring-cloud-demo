package com.qibria.cloud.alibaba.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("qibria_public")
                .addOpenApiCustomiser(publicApiCustomiser())
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public GroupedOpenApi adminApi() {
        return GroupedOpenApi.builder()
                .addOpenApiCustomiser(adminApiCustomiser())
                .group("qibria_admin")
                .pathsToMatch("/**")
                .build();
    }

    /**
     * 定义 OpenApiCustomiser ，用于指定的 group
     * @return
     */
    public OpenApiCustomiser publicApiCustomiser() {
        return openApi -> openApi.info(new io.swagger.v3.oas.models.info.Info()
                .title("public API 文档")
                .description("实现对用户数据的增删改查等操作")
                .version("1.0")
                .contact(new io.swagger.v3.oas.models.info.Contact().name("lanweihong").email("986310747@qq.com")));
    }



    /**
     * 定义 OpenApiCustomiser ，用于指定的 group
     * @return
     */
    public OpenApiCustomiser adminApiCustomiser() {
        return openApi -> openApi.info(new io.swagger.v3.oas.models.info.Info()
                .title("admin API 文档")
                .description("实现对用户数据的增删改查等操作")
                .version("1.0")
                .contact(new io.swagger.v3.oas.models.info.Contact().name("qibria").email("986310747@qq.com")));
    }

    //@Bean("publicOpenAPI")
//    public OpenAPI publicOpenAPI() {
//        return new OpenAPI()
//                .info(new Info().title("qibria public API")
//                        .description("Spring shop sample application")
//                        .version("v0.0.1")
//                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
//                .externalDocs(new ExternalDocumentation()
//                        .description("base demo ")
//                        .url("https://springshop.wiki.github.org/docs"));
//    }

//    @Bean("adminOpenAPI")
//    public OpenAPI adminOpenAPI() {
//        return new OpenAPI()
//                .info(new Info().title("qibria admin API")
//                        .description("Spring shop sample application")
//                        .version("v0.0.1")
//                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
//                .externalDocs(new ExternalDocumentation()
//                        .description("base demo ")
//                        .url("https://springshop.wiki.github.org/docs"));
//    }


}
