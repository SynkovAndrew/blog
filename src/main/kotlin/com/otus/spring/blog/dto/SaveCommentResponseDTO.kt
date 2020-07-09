package com.otus.spring.blog.dto

data class SaveCommentResponseDTO(
        val userId: Long?,
        val id: Long?,
        val topicId: Long?,
        val text: String?
)