package com.otus.spring.blog.configuration

import com.otus.spring.blog.service.MappingService
import org.mapstruct.factory.Mappers
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ContextConfiguration {

    @Bean
    fun mappingService(): MappingService {
        return Mappers.getMapper(MappingService::class.java)
    }
}