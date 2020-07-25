package com.otus.spring.blog.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users")
class User (

    @Column(name = "enabled", nullable = false)
    var enabled: Boolean = false,

    @Id
    @Column(name = "username", nullable = false, unique = true, length = 50)
    var name: String? = null,

    @Column(name = "password", nullable = false, length = 500)
    var password: String? = null
)