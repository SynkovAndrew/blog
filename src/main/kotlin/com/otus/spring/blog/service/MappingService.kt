package com.otus.spring.blog.service

import com.otus.spring.blog.domain.Message
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

    fun map(m: Message) = MessageDTO(m.createdAt, m.id, m.user?.id, m.text)

    fun map(r: SaveUserRequestDTO) = User(r.email, r.firstName, r.lastName, r.birthday)

    fun map(r: SaveMessageRequestDTO): Optional<Message> =
            userRepository.findById(r.userId).map { user -> Message(user, r.text) }

    fun map(us: List<User>) = FindUsersResponseDTO(us.map { u -> map(u) })

    fun map(ms: List<Message>) = FindMessagesResponseDTO(ms.map { m -> map(m) })
}