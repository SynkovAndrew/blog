package com.otus.spring.blog.dto

import java.time.LocalDateTime

data class TopicDTO(
    val createdAt: LocalDateTime?,
    val id: Long?,
    val author: AuthorDTO?,
    val text: String?,
    val title: String?
)