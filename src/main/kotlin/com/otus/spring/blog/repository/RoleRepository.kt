package com.otus.spring.blog.repository

import com.otus.spring.blog.domain.Role
import com.otus.spring.blog.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoleRepository : JpaRepository<Role, Long>