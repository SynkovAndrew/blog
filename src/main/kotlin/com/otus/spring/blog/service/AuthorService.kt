package com.otus.spring.blog.service

import com.otus.spring.blog.domain.Author
import com.otus.spring.blog.dto.FindAuthorsResponseDTO
import com.otus.spring.blog.dto.SaveAuthorRequestDTO
import com.otus.spring.blog.dto.AuthorDTO
import com.otus.spring.blog.repository.AuthorRepository
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.stereotype.Service

@Service
class AuthorService(
    private val authorRepository: AuthorRepository,
    private val mappingService: MappingService
) {
    fun loadById(authorId: Long): AuthorDTO = authorRepository.findById(authorId)
            .map { author -> mappingService.map(author) }
            .orElse(null)

    fun save(request: SaveAuthorRequestDTO): AuthorDTO = mappingService.map(
            authorRepository.save(
                    mappingService.map(request)
            )
    )

    fun findAll(firstName: String?, lastName: String?, email: String?): FindAuthorsResponseDTO =
            mappingService.map(authorRepository.findAll(
                    Example.of(Author(email = email, firstName = firstName, lastName = lastName), matcher())
            ))

    fun matcher(): ExampleMatcher = ExampleMatcher.matchingAll()
            .withIgnorePaths("createdAt")
            .withMatcher("firstName", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
            .withMatcher("lastName", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
            .withMatcher("email", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
}