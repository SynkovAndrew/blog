package com.otus.spring.blog.dto

import java.time.LocalDateTime

data class SaveTopicResponseDTO(
        val text: String?,
        val title: String?,
        val createdAt: LocalDateTime?,
        val id: Long?,
        val userId: Long?
)