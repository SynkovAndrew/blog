package com.otus.spring.blog.controller

import com.otus.spring.blog.dto.SaveUserRequestDTO
import com.otus.spring.blog.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class UserController(private val userService: UserService) {
    @PostMapping("api/v1/user")
    fun save(request: SaveUserRequestDTO) = userService.save(request)

    @GetMapping("api/v1/users")
    fun findAll() = userService.findAll()

    @GetMapping("api/v1/user/{userId}")
    fun loadById(@PathVariable("userId") userId: Long) = userService.loadById(userId)
}