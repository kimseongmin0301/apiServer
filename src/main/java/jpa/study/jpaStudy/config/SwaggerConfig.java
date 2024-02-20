package jpa.study.jpaStudy.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi openAPI() {
        return GroupedOpenApi.builder().group("user")
                .addOpenApiCustomizer(openApi -> openApi.info(
                        new Info()
                                .title("Swagger Test API")
                                .description("기본적인 CRUD를 테스트 합니다.")
                                .version("1.0.0"))
                ).build();
    }
}
