package com.otus.spring.blog.controller

import com.otus.spring.blog.dto.SaveUserRequestDTO
import com.otus.spring.blog.service.UserService
import org.springframework.web.bind.annotation.*


@RestController
class UserController(private val userService: UserService) {
    @PostMapping("api/v1/user")
    fun save(request: SaveUserRequestDTO) = userService.save(request)

    @GetMapping("api/v1/users")
    fun findAll(@RequestParam(name = "name", required = false) name: String?) = userService.findAll(name)

    @GetMapping("api/v1/user/{userId}")
    fun loadById(@PathVariable("userId") userId: Long) = userService.loadById(userId)
}