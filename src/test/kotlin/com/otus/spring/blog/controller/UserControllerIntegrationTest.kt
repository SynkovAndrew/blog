package com.otus.spring.blog.controller

import com.otus.spring.blog.dto.FindUsersResponseDTO
import com.otus.spring.blog.dto.UserDTO
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.util.Lists
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerIntegrationTest(@Autowired val restTemplate: TestRestTemplate) {

    @Test
    fun `Load all users`() {
        val entity = restTemplate.getForEntity<FindUsersResponseDTO>("/api/v1/users")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
/*        assertThat(entity.body).extracting("users").isEqualToComparingFieldByField(
                Lists.newArrayList(UserDTO(1, "Admin"))
        )*/
    }
}
