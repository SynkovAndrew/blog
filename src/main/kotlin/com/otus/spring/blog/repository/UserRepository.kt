package com.otus.spring.blog.repository

import com.otus.spring.blog.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findByName(name: String): List<User>
}