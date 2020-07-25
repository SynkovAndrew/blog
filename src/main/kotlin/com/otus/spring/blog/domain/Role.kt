package com.otus.spring.blog.domain

import org.springframework.security.core.GrantedAuthority
import javax.persistence.*

@Entity
@Table(name = "roles")
class Role (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "role", nullable = false, length = 50)
    var role: String? = null,

    @Column(name = "username", nullable = false, unique = true, length = 50)
    var username: String? = null
) : GrantedAuthority {
    override fun getAuthority(): String {
        return role?: ""
    }
}