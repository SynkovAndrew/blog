package com.otus.spring.blog.controller

import com.otus.spring.blog.dto.FindMessagesResponseDTO
import com.otus.spring.blog.dto.MessageDTO
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
class MessageControllerIntegrationTest(
        @Autowired val restTemplate: TestRestTemplate
) {

    @Test
    fun `Load messages of second user`() {
        val entity = restTemplate.getForEntity<FindMessagesResponseDTO>("/api/v1/user/2/messages")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(entity.body).extracting("content").isEqualToComparingFieldByField(
                Lists.newArrayList(
                        MessageDTO(
                                LocalDateTime.of(LocalDate.of(2019, 1, 8), LocalTime.of(13, 5, 12)),
                                3,
                                2,
                                "Interesting site"
                        ),
                        MessageDTO(
                                LocalDateTime.of(LocalDate.of(2019, 1, 8), LocalTime.of(15, 5, 6)),
                                4,
                                2,
                                "The weather is horrible"
                        )
                )
        )
    }
}
