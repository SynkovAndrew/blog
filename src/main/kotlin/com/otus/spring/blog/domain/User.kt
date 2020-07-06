package com.otus.spring.blog.domain

import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = -1,
        @Column(nullable = false)
        val name: String = ""
)