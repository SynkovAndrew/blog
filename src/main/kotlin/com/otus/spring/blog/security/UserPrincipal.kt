package com.otus.spring.blog.security

import com.otus.spring.blog.domain.Role
import com.otus.spring.blog.domain.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

data class UserPrincipal(
    val user: User,
    val roles: Set<Role>
) : UserDetails {

    override fun getAuthorities(): Collection<GrantedAuthority?> {
        return roles
    }

    override fun getPassword(): String {
        return user.password?: ""
    }

    override fun getUsername(): String {
        return user.name?: ""
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return user.enabled
    }
}