package com.otus.spring.blog.dto

import java.time.LocalDateTime

data class CommentDTO(
        val createdAt: LocalDateTime?,
        val id: Long?,
        val userId: Long?,
        val topicId: Long?,
        val text: String?
)