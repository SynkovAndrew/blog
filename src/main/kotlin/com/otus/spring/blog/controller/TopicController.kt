package com.otus.spring.blog.controller

import com.otus.spring.blog.dto.SaveTopicRequestDTO
import com.otus.spring.blog.service.TopicService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class TopicController(private val topicService: TopicService) {
    @PostMapping("api/v1/topic")
    fun save(request: SaveTopicRequestDTO) = topicService.save(request)

    @GetMapping("api/v1/topics")
    fun findAll(
            @RequestParam("userId") userId: Long?,
            @RequestParam("text") text: String?
    ) = topicService.findAll(userId, text)
}