package com.otus.spring.blog.dto

data class SaveCommentRequestDTO(
        val userId: Long,
        val topicId: Long,
        val text: String
)