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
    fun map(user: User) = UserDTO(user.id, user.name)

    fun map(message: Message) = MessageDTO(message.createdAt, message.id, message.user?.id, message.text)

    fun map(request: SaveUserRequestDTO) = User(request.name)

    fun map(request: SaveMessageRequestDTO): Optional<Message> {
        return userRepository.findById(request.userId)
                .map { user -> Message(user, request.text) }
    }

    fun map(users: List<User>) = FindUsersResponseDTO(users.map { user -> map(user) })

    fun map(messages: List<Message>) = FindMessagesResponseDTO(messages.map { message -> map(message) })
}