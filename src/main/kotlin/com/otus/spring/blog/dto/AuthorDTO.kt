package com.otus.spring.blog.dto

import java.time.LocalDate
import java.time.LocalDateTime

data class AuthorDTO(
        val id: Long?,
        val firstName: String?,
        val lastName: String?,
        val email: String?,
        val birthday: LocalDate?,
        val createdAt: LocalDateTime?
)