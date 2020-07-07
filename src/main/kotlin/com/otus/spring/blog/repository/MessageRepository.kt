package com.otus.spring.blog.repository

import com.otus.spring.blog.domain.Message
import com.otus.spring.blog.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MessageRepository : JpaRepository<Message, Long> {
    fun findAllByUserId(userId: Long): List<Message>
}