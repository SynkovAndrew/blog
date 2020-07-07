package com.otus.spring.blog.dto

import java.time.LocalDate

data class SaveUserRequestDTO(
        val firstName: String?,
        val lastName: String?,
        val email: String?,
        val birthday: LocalDate?
)