package com.otus.spring.blog.controller

import com.otus.spring.blog.dto.SaveUserRequestDTO
import com.otus.spring.blog.service.UserService
import org.springframework.web.bind.annotation.*


@RestController
class UserController(private val userService: UserService) {
    @PostMapping("api/v1/user")
    fun save(@RequestBody request: SaveUserRequestDTO) = userService.save(request)

    @GetMapping("api/v1/users")
    fun findAll(
            @RequestParam(name = "firstName", required = false) firstName: String?,
            @RequestParam(name = "lastName", required = false) lastName: String?,
            @RequestParam(name = "email", required = false) email: String?
    ) = userService.findAll(firstName, lastName, email)

    @GetMapping("api/v1/user/{userId}")
    fun loadById(@PathVariable("userId") userId: Long) = userService.loadById(userId)
}