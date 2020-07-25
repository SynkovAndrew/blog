package com.otus.spring.blog.controller

import com.otus.spring.blog.dto.FindAuthorsResponseDTO
import com.otus.spring.blog.dto.AuthorDTO
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.util.Lists
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AuthorControllerIntegrationTest(
        @Autowired val restTemplate: TestRestTemplate
) {

    @Test
    fun `Load all authors`() {
        val entity = restTemplate.getForEntity<FindAuthorsResponseDTO>("/api/v1/authors")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(entity.body).extracting("content").isEqualToComparingFieldByField(
                Lists.newArrayList(
                        AuthorDTO(1, "Morty", "Razen", "mora@gmail.com", LocalDate.of(1991, 1, 1),
                                LocalDateTime.of(LocalDate.of(2019, 1, 8), LocalTime.of(0, 5, 6))),
                        AuthorDTO(2, "Richard", "Vagner", "rivas@gmail.com", LocalDate.of(1946, 2, 1),
                                LocalDateTime.of(LocalDate.of(2013, 1, 8), LocalTime.of(4, 0, 6))),
                        AuthorDTO(3, "Mahart", "Towad", "masdfg@gmail.com", LocalDate.of(1992, 3, 3),
                                LocalDateTime.of(LocalDate.of(2016, 1, 8), LocalTime.of(0, 0, 1)))
                )
        )
    }

    @Test
    fun `Load author by name`() {
        val entity = restTemplate.getForEntity<FindAuthorsResponseDTO>("/api/v1/authors?firstName=rt&email=gmail")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(entity.body).extracting("content").isEqualToComparingFieldByField(
                Lists.newArrayList(
                        AuthorDTO(1, "Morty", "Razen", "mora@gmail.com", LocalDate.of(1991, 1, 1),
                                LocalDateTime.of(LocalDate.of(2019, 1, 8), LocalTime.of(0, 5, 6))),
                        AuthorDTO(3, "Mahart", "Towad", "masdfg@gmail.com", LocalDate.of(1992, 3, 3),
                                LocalDateTime.of(LocalDate.of(2016, 1, 8), LocalTime.of(0, 0, 1)))
                )
        )
    }
}
