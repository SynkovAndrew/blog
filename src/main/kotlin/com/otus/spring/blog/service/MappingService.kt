package com.otus.spring.blog.service

import com.otus.spring.blog.domain.Author
import com.otus.spring.blog.domain.Comment
import com.otus.spring.blog.domain.Topic
import com.otus.spring.blog.domain.User
import com.otus.spring.blog.dto.*
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class MappingService(
    private val passwordEncoder: PasswordEncoder
) {
    fun map(u: Author) = AuthorDTO(u.id, u.firstName, u.lastName, u.email, u.birthday, u.createdAt)

    fun map(t: Topic) = TopicDTO(t.createdAt, t.id, map(t.author ?: Author()), t.text, t.title)

    fun mapToResponse(t: Topic) = SaveTopicResponseDTO(t.text, t.title, t.createdAt, t.id, t.author?.id)

    fun mapToResponse(c: Comment) = SaveCommentResponseDTO(c.author?.id, c.id, c.topic?.id, c.text, c.createdAt)

    fun map(c: Comment) = CommentDTO(c.createdAt, c.id, map(c.author ?: Author()), c.topic?.id, c.text)

    fun map(r: SaveCommentRequestDTO) = Comment(Author(id = r.authorId), Topic(id = r.topicId), r.text, r.commentId)

    fun map(r: SaveAuthorRequestDTO) = Author(User(name = r.userName), r.email, r.firstName, r.lastName, r.birthday)

    fun map(r: SignUpUserRequestDTO) = User(true, r.userName, passwordEncoder.encode(r.password))

    fun map(u: User) = UserDTO(u.enabled, u.name)

    fun map(r: SaveTopicRequestDTO) = Topic(Author(id = r.authorId), r.text, r.title)

    fun map(us: List<Author>) = FindAuthorsResponseDTO(us.map { u -> map(u) })

    fun map(cs: List<Comment>) = FindCommentsResponseDTO(cs.map { c -> map(c) })

    fun map(ms: List<Topic>) = FindTopicsResponseDTO(ms.map { m -> map(m) })
}