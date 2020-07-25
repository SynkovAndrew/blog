package com.otus.spring.blog.controller

import com.otus.spring.blog.dto.SignUpUserRequestDTO
import com.otus.spring.blog.dto.UserDTO
import com.otus.spring.blog.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(private val service: UserService) {
    @PostMapping("api/v1/signUp")
    fun signUp(@RequestBody request: SignUpUserRequestDTO): UserDTO = service.singUp(request)
}