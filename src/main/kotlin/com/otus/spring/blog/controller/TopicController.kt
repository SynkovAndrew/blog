package com.otus.spring.blog.controller

import com.otus.spring.blog.dto.SaveTopicRequestDTO
import com.otus.spring.blog.service.TopicService
import org.springframework.web.bind.annotation.*


@RestController
class TopicController(private val topicService: TopicService) {
    @PostMapping("api/v1/topic")
    fun save(@RequestBody request: SaveTopicRequestDTO) = topicService.save(request)

    @GetMapping("api/v1/topics")
    fun findAll(
            @RequestParam("userId") userId: Long?,
            @RequestParam("text") text: String?
    ) = topicService.findAll(userId, text)

    @GetMapping("api/v1/topic/{topicId}")
    fun loadById(@PathVariable("topicId") topicId: Long) = topicService.loadById(topicId)
}