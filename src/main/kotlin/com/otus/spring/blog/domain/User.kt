package com.otus.spring.blog.domain

import javax.persistence.*

@Entity
@Table(name = "users")
class User(

        @Column(nullable = false)
        var name: String? = null,

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null
)