package com.otus.spring.blog.dto

data class SaveCommentRequestDTO(
        val commentId: Long?,
        val authorId: Long,
        val topicId: Long,
        val text: String
)