package com.otus.spring.blog.dto

data class SignUpUserRequestDTO(
    val userName: String,
    val email: String,
    val password: String,
    val checkPassword: String
)