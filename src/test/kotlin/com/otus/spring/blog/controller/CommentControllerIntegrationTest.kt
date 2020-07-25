package com.otus.spring.blog.controller

import com.otus.spring.blog.dto.*
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.util.Maps
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForObject
import org.springframework.boot.test.web.client.postForObject
import org.springframework.test.annotation.DirtiesContext
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class CommentControllerIntegrationTest(
        @Autowired val restTemplate: TestRestTemplate
) {

    @Test
    fun `Save new comment`() {
        val saved = restTemplate.postForObject<SaveCommentResponseDTO>("/api/v1/comment",
                SaveCommentRequestDTO(null, 1, 1, "I really appreciate it!")
        )
        assertThat(saved).extracting("id").isEqualTo(3L)
        assertThat(saved).extracting("createdAt").isNotNull()
        assertThat(saved).extracting("authorId").isEqualTo(1L)
        assertThat(saved).extracting("topicId").isEqualTo(1L)
        assertThat(saved).extracting("text").isEqualTo("I really appreciate it!")

        val found = restTemplate.getForObject<FindCommentsResponseDTO>("/api/v1/comments")
        assertThat(found?.content?.size).isEqualTo(3)
    }

    @Test
    fun `Update comment`() {
        val saved = restTemplate.postForObject<SaveCommentResponseDTO>("/api/v1/comment",
                SaveCommentRequestDTO(1, 2, 1, "I really appreciate it!")
        )
        assertThat(saved).extracting("id").isEqualTo(1L)
        assertThat(saved).extracting("createdAt").isNotNull()
        assertThat(saved).extracting("authorId").isEqualTo(2L)
        assertThat(saved).extracting("topicId").isEqualTo(1L)
        assertThat(saved).extracting("text").isEqualTo("I really appreciate it!")

        val found = restTemplate.getForObject<FindCommentsResponseDTO>("/api/v1/comments")
        assertThat(found?.content?.size).isEqualTo(2)
    }
}
