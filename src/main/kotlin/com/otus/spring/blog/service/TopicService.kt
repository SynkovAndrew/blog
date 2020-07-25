package com.otus.spring.blog.service

import com.otus.spring.blog.domain.Topic
import com.otus.spring.blog.domain.Author
import com.otus.spring.blog.dto.FindTopicsResponseDTO
import com.otus.spring.blog.dto.SaveTopicRequestDTO
import com.otus.spring.blog.dto.SaveTopicResponseDTO
import com.otus.spring.blog.dto.TopicDTO
import com.otus.spring.blog.repository.TopicRepository
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.stereotype.Service

@Service
class TopicService(
        private val topicRepository: TopicRepository,
        private val mappingService: MappingService
) {

    fun loadById(topicId: Long): TopicDTO = topicRepository.findById(topicId)
            .map { topic -> mappingService.map(topic) }
            .orElse(null)

    fun save(request: SaveTopicRequestDTO): SaveTopicResponseDTO =
            mappingService.mapToResponse(topicRepository.save(mappingService.map(request)))

    fun findAll(authorId: Long?, text: String?): FindTopicsResponseDTO =
            mappingService.map(topicRepository.findAll(
                    Example.of(Topic(Author(id = authorId), text = text), matcher())
            ))

    fun matcher(): ExampleMatcher = ExampleMatcher.matchingAll()
            .withIgnorePaths("createdAt", "author.createdAt")
            .withMatcher("text", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
}