package com.otus.spring.blog.controller

import com.otus.spring.blog.dto.SaveMessageRequestDTO
import com.otus.spring.blog.service.MessageService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class MessageController(private val messageService: MessageService) {
    @PostMapping("api/v1/message")
    fun save(request: SaveMessageRequestDTO) = messageService.save(request)

    @GetMapping("api/v1/user/{userId}/messages")
    fun findAll(@PathVariable("userId") userId: Long) = messageService.findAllByUserId(userId)
}