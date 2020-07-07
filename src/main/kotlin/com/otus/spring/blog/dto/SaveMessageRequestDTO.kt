package com.otus.spring.blog.dto

data class SaveMessageRequestDTO(
        val text: String,
        val userId: Long
)