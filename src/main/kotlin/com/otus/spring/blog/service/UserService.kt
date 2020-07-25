package com.otus.spring.blog.service

import com.otus.spring.blog.domain.Role
import com.otus.spring.blog.dto.SaveAuthorRequestDTO
import com.otus.spring.blog.dto.SignUpUserRequestDTO
import com.otus.spring.blog.dto.UserDTO
import com.otus.spring.blog.repository.RoleRepository
import com.otus.spring.blog.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository,
    private val authorService: AuthorService,
    private val mappingService: MappingService
) {
    fun singUp(request: SignUpUserRequestDTO): UserDTO {
        if (request.password !== request.checkPassword) {
            throw RuntimeException("Check password doesn't match password!")
        }
        val user = userRepository.save(mappingService.map(request))
        roleRepository.save(Role(role = "REGISTERED_USER_ROLE", username = user.name))
        authorService.save(
            SaveAuthorRequestDTO(
                null, null, request.userName, request.email, null
            )
        )
        return mappingService.map(user)
    }
}