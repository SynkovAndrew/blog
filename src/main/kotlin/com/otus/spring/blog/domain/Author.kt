package com.otus.spring.blog.domain

import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "authors")
class Author(

        @OneToOne
        @JoinColumn(name = "username", referencedColumnName = "username",  nullable = false)
        var user: User? = null,

        @Column(name = "email", nullable = false)
        var email: String? = null,

        @Column(name = "first_name", nullable = true)
        var firstName: String? = null,

        @Column(name = "last_name", nullable = true)
        var lastName: String? = null,

        @Column(name = "birthday", nullable = true)
        var birthday: LocalDate? = null,

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

        @Column(nullable = false)
        var createdAt: LocalDateTime? = LocalDateTime.now()
)