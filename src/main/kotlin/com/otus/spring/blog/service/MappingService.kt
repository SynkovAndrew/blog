package com.otus.spring.blog.service

import com.otus.spring.blog.domain.User
import com.otus.spring.blog.dto.FindUsersResponseDTO
import com.otus.spring.blog.dto.SaveUserRequestDTO
import com.otus.spring.blog.dto.UserDTO
import org.springframework.stereotype.Service

@Service
class MappingService {
    fun map(user: User) = UserDTO(user.id, user.name)

    fun map(request: SaveUserRequestDTO) = User(request.name)

    fun map(users: List<User>) = FindUsersResponseDTO(users.map { user -> map(user) })
}