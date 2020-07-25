package com.otus.spring.blog.dto

import java.time.LocalDate

data class SaveAuthorRequestDTO(
        val firstName: String?,
        val lastName: String?,
        val userName: String?,
        val email: String?,
        val birthday: LocalDate?
)