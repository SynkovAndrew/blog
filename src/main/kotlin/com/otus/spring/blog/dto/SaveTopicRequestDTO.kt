package com.otus.spring.blog.dto

data class SaveTopicRequestDTO(
        val text: String,
        val title: String,
        val authorId: Long
)