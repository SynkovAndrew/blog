package com.otus.spring.blog.service

import com.otus.spring.blog.domain.User
import com.otus.spring.blog.dto.FindUsersResponseDTO
import com.otus.spring.blog.dto.SaveUserRequestDTO
import com.otus.spring.blog.dto.UserDTO
import com.otus.spring.blog.repository.UserRepository
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.stereotype.Service

@Service
class UserService(
        private val userRepository: UserRepository,
        private val mappingService: MappingService
) {
    fun loadById(userId: Long): UserDTO = userRepository.findById(userId)
            .map { user -> mappingService.map(user) }
            .orElse(null)

    fun save(request: SaveUserRequestDTO): UserDTO = mappingService.map(
            userRepository.save(
                    mappingService.map(request)
            )
    )

    fun findAll(name: String?): FindUsersResponseDTO = mappingService.map(
            userRepository.findAll(
                    Example.of(User(name), ExampleMatcher.matchingAll()
                            .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING))
            )
    )

}