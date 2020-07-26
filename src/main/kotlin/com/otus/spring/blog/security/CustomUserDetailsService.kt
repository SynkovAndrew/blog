package com.otus.spring.blog.security

import com.otus.spring.blog.repository.RoleRepository
import com.otus.spring.blog.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService (
    private val roleRepository: RoleRepository,
    private val userRepository: UserRepository
) : UserDetailsService {
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        return userRepository.findById(username)
            .map { user -> UserPrincipal(user, roleRepository.findAllByUsername(username)) }
            .orElseThrow { UsernameNotFoundException(String.format("User \"%s\" hasn't been found", username)) }
    }
}