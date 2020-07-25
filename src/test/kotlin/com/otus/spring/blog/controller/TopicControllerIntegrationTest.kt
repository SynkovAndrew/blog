package com.otus.spring.blog.controller

import com.otus.spring.blog.dto.*
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.util.Lists
import org.assertj.core.util.Maps
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.boot.test.web.client.getForObject
import org.springframework.boot.test.web.client.postForObject
import org.springframework.http.HttpStatus
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TopicControllerIntegrationTest(
        @Autowired val restTemplate: TestRestTemplate
) {

    @Test
    fun `Load topics of second author`() {
        val entity = restTemplate.getForEntity<FindTopicsResponseDTO>("/api/v1/topics?authorId=2")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(entity.body).extracting("content").isEqualToComparingFieldByField(
                Lists.newArrayList(
                        TopicDTO(
                                LocalDateTime.of(LocalDate.of(2019, 1, 8), LocalTime.of(13, 5, 12)),
                                3,
                                AuthorDTO(2, "Richard", "Vagner", "rivas@gmail.com", LocalDate.of(1946, 2, 1),
                                        LocalDateTime.of(LocalDate.of(2013, 1, 8), LocalTime.of(4, 0, 6))),
                                "Interesting site",
                                "My first"
                        ),
                        TopicDTO(
                                LocalDateTime.of(LocalDate.of(2019, 1, 8), LocalTime.of(15, 5, 6)),
                                4,
                                AuthorDTO(2, "Richard", "Vagner", "rivas@gmail.com", LocalDate.of(1946, 2, 1),
                                        LocalDateTime.of(LocalDate.of(2013, 1, 8), LocalTime.of(4, 0, 6))),
                                "The weather is horrible",
                                "Weather"
                        )
                )
        )
    }

    @Test
    fun `Save new topic`() {
        val saved = restTemplate.postForObject<SaveTopicResponseDTO>("/api/v1/topic",
                SaveTopicRequestDTO("Can somebody help me with my homework?", "Need help!", 1)
        )
        assertThat(saved).extracting("id").isNotNull()
        assertThat(saved).extracting("createdAt").isNotNull()
        assertThat(saved).extracting("authorId").isEqualTo(1L)
        assertThat(saved).extracting("title").isEqualTo("Need help!")
        assertThat(saved).extracting("text").isEqualTo("Can somebody help me with my homework?")

        val topicId = saved?.id
        val found = restTemplate.getForObject<TopicDTO>("/api/v1/topic/{topicId}",
                Maps.newHashMap("topicId", topicId))
        assertThat(found).extracting("id").isEqualTo(topicId)
        assertThat(found).extracting("author").isEqualToComparingFieldByField(
                AuthorDTO(1, "Morty", "Razen", "mora@gmail.com", LocalDate.of(1991, 1, 1),
                        LocalDateTime.of(LocalDate.of(2019, 1, 8), LocalTime.of(0, 5, 6)))
        )
        assertThat(found).extracting("createdAt").isNotNull()
        assertThat(found).extracting("title").isEqualTo("Need help!")
        assertThat(found).extracting("text").isEqualTo("Can somebody help me with my homework?")
    }
}
