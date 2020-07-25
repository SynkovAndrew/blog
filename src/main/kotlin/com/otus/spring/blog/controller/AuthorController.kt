package com.otus.spring.blog.controller

import com.otus.spring.blog.dto.SaveAuthorRequestDTO
import com.otus.spring.blog.service.AuthorService
import org.springframework.web.bind.annotation.*


@RestController
class AuthorController(private val authorService: AuthorService) {
    @PostMapping("api/v1/author")
    fun save(@RequestBody request: SaveAuthorRequestDTO) = authorService.save(request)

    @GetMapping("api/v1/authors")
    fun findAll(
            @RequestParam(name = "firstName", required = false) firstName: String?,
            @RequestParam(name = "lastName", required = false) lastName: String?,
            @RequestParam(name = "email", required = false) email: String?
    ) = authorService.findAll(firstName, lastName, email)

    @GetMapping("api/v1/author/{authorId}")
    fun loadById(@PathVariable("authorId") authorId: Long) = authorService.loadById(authorId)
}