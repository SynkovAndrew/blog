package com.otus.spring.blog.service

import com.otus.spring.blog.domain.Topic
import com.otus.spring.blog.domain.User
import com.otus.spring.blog.dto.*
import com.otus.spring.blog.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class MappingService(
        private val userRepository: UserRepository
) {
    fun map(u: User) = UserDTO(u.id, u.firstName, u.lastName, u.email, u.birthday, u.createdAt)

    fun map(m: Topic) = TopicDTO(m.createdAt, m.id, m.user?.id, m.text, m.title)

    fun map(r: SaveUserRequestDTO) = User(r.email, r.firstName, r.lastName, r.birthday)

    fun map(r: SaveTopicRequestDTO): Optional<Topic> =
            userRepository.findById(r.userId).map { user -> Topic(user, r.text, r.title) }

    fun map(us: List<User>) = FindUsersResponseDTO(us.map { u -> map(u) })

    fun map(ms: List<Topic>) = FindTopicsResponseDTO(ms.map { m -> map(m) })
}