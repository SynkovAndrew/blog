package com.otus.spring.blog.service

import com.otus.spring.blog.domain.Comment
import com.otus.spring.blog.domain.Topic
import com.otus.spring.blog.dto.FindCommentsResponseDTO
import com.otus.spring.blog.dto.SaveCommentRequestDTO
import com.otus.spring.blog.dto.SaveCommentResponseDTO
import com.otus.spring.blog.repository.CommentRepository
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.stereotype.Service

@Service
class CommentService(
        private val commentRepository: CommentRepository,
        private val mappingService: MappingService
) {

    /*    fun loadById(topicId: Long): TopicDTO = topicRepository.findById(topicId)
                .map { topic -> mappingService.map(topic) }
                .orElse(null)
    */
    fun save(request: SaveCommentRequestDTO): SaveCommentResponseDTO =
            mappingService.mapToResponse(commentRepository.save(mappingService.map(request)))

    fun delete(id: Long) = commentRepository.deleteById(id)

    fun findAll(topicId: Long?, text: String?): FindCommentsResponseDTO =
            mappingService.map(commentRepository.findAll(
                    Example.of(Comment(topic = Topic(id = topicId), text = text), matcher())
            ))

    fun matcher(): ExampleMatcher = ExampleMatcher.matchingAll()
            .withIgnorePaths("createdAt", "topic.createdAt", "user.createdAt")
            .withMatcher("text", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
}