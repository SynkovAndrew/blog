package com.otus.spring.blog.controller

import com.otus.spring.blog.dto.FindTopicsResponseDTO
import com.otus.spring.blog.dto.SaveCommentRequestDTO
import com.otus.spring.blog.dto.SaveTopicRequestDTO
import com.otus.spring.blog.dto.TopicDTO
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.util.Lists
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
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
    fun `Load topics of second user`() {
        val entity = restTemplate.getForEntity<FindTopicsResponseDTO>("/api/v1/topics?userId=2")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(entity.body).extracting("content").isEqualToComparingFieldByField(
                Lists.newArrayList(
                        TopicDTO(
                                LocalDateTime.of(LocalDate.of(2019, 1, 8), LocalTime.of(13, 5, 12)),
                                3,
                                2,
                                "Interesting site",
                                "My first"
                        ),
                        TopicDTO(
                                LocalDateTime.of(LocalDate.of(2019, 1, 8), LocalTime.of(15, 5, 6)),
                                4,
                                2,
                                "The weather is horrible",
                                "Weather"
                        )
                )
        )
    }

    @Test
    fun `Save new topic`() {
        val entity = restTemplate.postForObject<TopicDTO>("/api/v1/topic",
                SaveTopicRequestDTO("Can somebody help me with my homework?", "Need help!", 1)
        )
        assertThat(entity).extracting("id").isNotNull()
        assertThat(entity).extracting("userId").isEqualTo(1L)
        assertThat(entity).extracting("createdAt").isNotNull()
        assertThat(entity).extracting("title").isEqualTo("Need help!")
        assertThat(entity).extracting("text").isEqualTo("Can somebody help me with my homework?")
    }
}
