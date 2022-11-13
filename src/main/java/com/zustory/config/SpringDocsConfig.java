package com.zustory.config;

import com.zustory.domain.dto.PageableRequestDto;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.SpringDocUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;

@Configuration
public class SpringDocsConfig {

    @Bean
    public OpenAPI openAPI() {

        SpringDocUtils.getConfig().replaceWithClass(Pageable.class, PageableRequestDto.class);

        Info info = new Info()
                .title("주스토리 API") // 타이틀
                .version("v1") // 문서 버전
                .description("주스토리 API 문서입니다.");

        return new OpenAPI().info(info);
    }
}
