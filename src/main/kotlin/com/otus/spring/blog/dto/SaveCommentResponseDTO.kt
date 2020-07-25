package com.otus.spring.blog.dto

import java.time.LocalDateTime

data class SaveCommentResponseDTO(
        val authorId: Long?,
        val id: Long?,
        val topicId: Long?,
        val text: String?,
        var createdAt: LocalDateTime?
)