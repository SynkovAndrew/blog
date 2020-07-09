package com.otus.spring.blog.controller

import com.otus.spring.blog.dto.SaveCommentRequestDTO
import com.otus.spring.blog.service.CommentService
import org.springframework.web.bind.annotation.*


@RestController
class CommentController(private val commentService: CommentService) {
    @PostMapping("api/v1/comment")
    fun save(@RequestBody request: SaveCommentRequestDTO) = commentService.save(request)

    @DeleteMapping("api/v1/comment")
    fun delete(@RequestParam("id") id: Long) = commentService.delete(id)

    @GetMapping("api/v1/comments")
    fun findAll(
            @RequestParam("topicId") topicId: Long?,
            @RequestParam("text") text: String?
    ) = commentService.findAll(topicId, text)

/*    @GetMapping("api/v1/topic/{topicId}")
    fun loadById(@PathVariable("topicId") topicId: Long) = topicService.loadById(topicId)*/
}