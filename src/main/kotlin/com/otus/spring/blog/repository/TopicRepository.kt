package com.otus.spring.blog.repository

import com.otus.spring.blog.domain.Topic
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TopicRepository : JpaRepository<Topic, Long> {
    fun findAllByUserId(userId: Long): List<Topic>
}