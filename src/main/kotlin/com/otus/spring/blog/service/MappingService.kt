package com.otus.spring.blog.service

import com.otus.spring.blog.domain.User
import com.otus.spring.blog.dto.FindUsersResponseDTO
import com.otus.spring.blog.dto.SaveUserRequestDTO
import com.otus.spring.blog.dto.UserDTO
import org.mapstruct.Mapper
import org.springframework.stereotype.Service

@Service
class MappingService {
    fun map(user: User): UserDTO {
        return UserDTO(user.id, user.name)
    }

    fun map(request: SaveUserRequestDTO): User {
        return User(null, request.name )
    }

    fun map(users: List<User>): FindUsersResponseDTO {
        return FindUsersResponseDTO(
                users.map(this::map)
        )
    }
}