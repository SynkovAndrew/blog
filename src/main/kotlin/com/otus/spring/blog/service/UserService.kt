package com.otus.spring.blog.service

import com.otus.spring.blog.dto.FindUsersResponseDTO
import com.otus.spring.blog.dto.SaveUserRequestDTO
import com.otus.spring.blog.dto.UserDTO
import com.otus.spring.blog.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
        private val userRepository: UserRepository,
        private val mappingService: MappingService
) {

    fun save(request: SaveUserRequestDTO): UserDTO {
        return mappingService.map(
                userRepository.save(
                        mappingService.map(request)
                )
        )
    }

    fun findAll(): FindUsersResponseDTO {
        return mappingService.map(
                userRepository.findAll()
        )
    }
}