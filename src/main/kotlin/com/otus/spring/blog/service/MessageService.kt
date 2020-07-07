package com.otus.spring.blog.service

import com.otus.spring.blog.dto.FindMessagesResponseDTO
import com.otus.spring.blog.dto.MessageDTO
import com.otus.spring.blog.dto.SaveMessageRequestDTO
import com.otus.spring.blog.repository.MessageRepository
import org.springframework.stereotype.Service

@Service
class MessageService(
        private val messageRepository: MessageRepository,
        private val mappingService: MappingService
) {

    fun save(request: SaveMessageRequestDTO): MessageDTO = mappingService.map(request)
            .map { message -> messageRepository.save(message) }
            .map { saved -> mappingService.map(saved) }
            .orElse(null)

    fun findAllByUserId(userId: Long): FindMessagesResponseDTO = mappingService.map(
            messageRepository.findAllByUserId(userId)
    )
}